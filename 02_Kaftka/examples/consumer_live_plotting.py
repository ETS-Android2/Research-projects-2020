from kafka import KafkaConsumer
from json import loads
from time import sleep
import numpy as np
import matplotlib.pyplot as plt
import re
import string
from collections import Counter
import nltk
from nltk.corpus import stopwords
import json
from random import randint

nltk.download("stopwords") # download the stopword corpus on our computer

colors = []
colors_for_hashtag = dict()
for i in range(25):
    colors.append('#%06X' % randint(0, 0xFFFFFF))

emoticons_str = r"""
    (?:
        [:=;] # Eyes
        [oO\-]? # Nose (optional)
        [D\)\]\(\]/\\OpP] # Mouth
    )"""

regex_str = [
    emoticons_str,
    r'<[^>]+>',  # HTML tags
    r'(?:@[\w_]+)',  # @-mentions
    r"(?:\#+[\w_]+[\w\'_\-]*[\w_]+)",  # hash-tags
    r'http[s]?://(?:[a-z]|[0-9]|[$-_@.&+]|[!*\(\),]|(?:%[0-9a-f][0-9a-f]))+',  # URLs

    r'(?:(?:\d+,?)+(?:\.?\d+)?)',  # numbers
    r"(?:[a-z][a-z'\-_]+[a-z])",  # words with - and '
    r'(?:[\w_]+)',  # other words
    r'(?:\S)'  # anything else
]

tokens_re = re.compile(r'(' + '|'.join(regex_str) + ')', re.VERBOSE | re.IGNORECASE)
emoticon_re = re.compile(r'^' + emoticons_str + '$', re.VERBOSE | re.IGNORECASE)

def tokenize(s):
    return tokens_re.findall(s)


def preprocess(s, lowercase=False):
    tokens = tokenize(s)
    if lowercase:
        tokens = [token if emoticon_re.search(token) else token.lower() for token in tokens]
    return tokens

# stop words
punctuation = list(string.punctuation)
stop = stopwords.words('english') + stopwords.words('spanish') + punctuation + ['rt', 'via', 'RT']

count_hash = Counter()

consumer = KafkaConsumer('twitter-lab',
                         bootstrap_servers=['localhost:9092'],
                         auto_offset_reset='earliest',
                         enable_auto_commit=True,
                         group_id='my-group',
                         value_deserializer=lambda x: loads(x.decode('utf-8')))

fig, ax = plt.subplots(figsize=(15, 8))
ax.barh([], [])
plt.ion()
plt.show()

for message in consumer:
    message = message.value
    print('########################################################################')
    #print('{} received'.format(message))
    message = json.loads(message)
    try:
        terms_hash = [term for term in preprocess(message['text']) if term.startswith('#') and term != '#']
        count_hash.update(terms_hash)
    except KeyError:
        pass

    if len(count_hash) != 0:
        ax.clear()
        sorted_x, sorted_y = zip(*count_hash.most_common(30))
        sorted_x = sorted_x[::-1]
        sorted_y = sorted_y[::-1]

        for key in sorted_x:
            if key not in colors_for_hashtag:
                colors_for_hashtag[key] = colors[randint(0, 24)]

        ax.barh(sorted_x, sorted_y, color=[colors_for_hashtag[hashtag] for hashtag in sorted_x])
        plt.pause(0.001)
        
        print(sorted_x, sorted_y)
