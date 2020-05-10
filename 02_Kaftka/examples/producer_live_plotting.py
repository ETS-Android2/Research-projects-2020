from time import sleep
from json import dumps
from kafka import KafkaProducer
import os
import tweepy
from tweepy import OAuthHandler
from tweepy import Stream
from tweepy.streaming import StreamListener


class MyListener(StreamListener):

    def on_data(self, data):
        producer = KafkaProducer(bootstrap_servers=['localhost:9092'],
                   value_serializer=lambda x:dumps(x).encode('utf-8'))
        try:
            producer.send('twitter-lab', value=data)
            print("DATA SENT")
            return True
        except BaseException as e:
            print("Error on_data: %s" % str(e))
        return True

    def on_error(self, status):
        print(status)
        return True


consumer_key = os.environ['CONSUMER_KEY']
consumer_secret = os.environ['CONSUMER_SECRET']
access_token = os.environ['ACCESS_TOKEN']
access_secret = os.environ['ACCESS_SECRET']

auth = OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_secret)

twitter_stream = Stream(auth, MyListener())
twitter_stream.filter(track=['coronavirus'])
