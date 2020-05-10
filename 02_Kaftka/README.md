# Research: Creation of a Tutorial

## Kafka: What is it? How can it help me?
Apache is defined as a **_distributed streaming platform_**. It is a
technology that makes applications capable of capturing data from different
systems, and to react in real-time to the changes in that data. It
started as an internal system used by LinkedIn to manage the 1400 billion
messages, that went through the network on a daily basis.

To achieve this reliable communication, Kafka is run in a cluster of
servers, that encapsulates each unit of data captured as **_records_**.
Each one of these, contains an identification **_key_**, the actual **_value_** of
the data, and a **_timestamp_**. Furthermore, these **_records_** are
grouped into **_topics_**, so it is easy to have a custom classification
of the data collected. 

The following image depicts an example deployment of a Kafka-bases system.
In it, there are Producers (A and B), that are the entities that emit
the messages. Each message is classified into a specific topic, which
in this particular case is "My Topic". Each topic can have multiple
partitions, so messages belonging to the same topic can be further
distributed to different locations. Then we can say that data is stored,
until it is read by a client. These clients are called
Consumers, and they can be subscribed to any set of partitions of any given
number of topics. Consumers read data from the partitions, and make
the reads logically effective by commiting them. This, alongside with the
possibility to group Consumers, makes possible that a number of clients keep
a common state in the system, since commits can be realized bot individually
or in a group level. One powerful feature of Kafka is that, if a consumer
fails, the new or fixed one can start receiving data at the same point its
predecessor was.

![Arch](https://docs.cloudera.com/documentation/kafka/1-2-x/images/kafka-architecture.png "Architecture")

The purpose of this tutorial is to introduce this technology, not seen in
the current CCBDA iteration. It is a ver powerful tool, that can ease
the development of any system that has the analysis of data among its
features. To make the assimilation of information easier, we decided to
reuse one of the labs in the course, so the student doesn't have to spend
time understanding the actual purpose of the lab, and can devote full
attention to learning Kafka.

For more detailed information, please refer to:
* https://kafka.apache.org/intro


## Requisites: Setting up the environment.
For this tutorial, we are going to use python as programming language.
Just downloading the latest version from official sources, to have
the environment available. The use of Anaconda, or a similar packet
manager, eases the process of setting up the requirements for this tutorial.

Once the basic Python environment is set, we need to set up
the `kafka-python` library. This can be done easily, using `pip`, or `conda`
if Anaconda is used.:
````bash
pip install kafka-python

conda install -c conda-forge kafka-python
````

Additionally, to be able to use Kafka in our code, we need to install its
binaries in our computer. Once Kafka is installed, Zookeeper will also
be made available.

Zookeeper is a software that works in the background, and maintains naming
and configuration data, that allows synchronization in distributed systems
such as the ones possible with Kafka. It is a requirement that we have an
instance of Zookeeper running in the background, so Kafka can run on top of
it. If the user tries to run Kafka alone, there will be errors, regarding
the absence of a `broker`. That is, the absence of our Zookeeper background
service.

To sum up, the list of requirements are:

* A `Python` distribution. It is recommended that Anaconda is used.
* The `kafka-python` library.
* The `Kafka` binaries, and the `Zookeeper` software that comes with it.

If you run into any unexpected issue regarding Kafka installation, these two following urls contain a lot of information that we think it was really useful for us in order to solve our installation and usage issues: [DigitalOcean](https://www.digitalocean.com/community/tutorials/how-to-install-apache-kafka-on-ubuntu-18-04) and [Apache](https://kafka.apache.org/quickstart).

## A simple publish-subscribe example.

In the `examples/` folder, you can find several examples in order to solve the tasks during this tutorial. Firstly, we will start by using a very basic example that consists of a *Kafka Producer* and a  *Kafka Consumer*.

First of all, you should have both **Zookeper** and **Kafka** running, as explained in both URLs that we have previously provided. If you configured Zookeper and Kafka with any different ports (by default, Zookeper uses port **2181** and Kafka uses port **9092**) you should updated your Python code accordingly to the ports that you have used to deploy the Kafka server.

In this first example, the *Kafka producer* code basically generates 1000 numbers (starting by 0..1000) and sends them to the *Kafka consumer*, which receives and prints them. So we suggest that you try on your own before checking the code we provide to achieve this result. To do so, you will need two terminals to run one of each different codes, `producer.py` and `consumer.py` respectively.

Focusing on the `producer.py`, you can create a new object producer by using the following line:

```python
producer = KafkaProducer(bootstrap_servers=['localhost:9092'],
                         value_serializer=lambda x:dumps(x).encode('utf-8'))
```

Once this object *KafkaProducer* has been created, the function `send()` can be called upon it as in the following example:

```python
producer.send(topic_name, value)
```

where *topic_name* is a string and *value* in this case should be the different numbers (from 0 to 1000).

On the other hand, we should also create the code that will receive those numbers published by the producer. Hence, the `consumer.py` code will create a *KafkaConsumer* object as in the following example:

```python
consumer = KafkaConsumer(topic_name,
                         bootstrap_servers=['localhost:9092'],
                         auto_offset_reset='earliest',
                         enable_auto_commit=True,
                         group_id='my-group',
                         value_deserializer=lambda x: loads(x.decode('utf-8')))
```

Keep in mind that the *topic_name* passed to the KafkaConsumer init function should be the same that you have previously used in the Kafka producer code, otherwhise your consumer will not receive any of the published messages.

Once the consumer has been created, you can iterate over all the published messages on the given topic as follows:

```python
for message in consumer:
	print(message.value)
```

If at any moment you are facing any issue in which the consumer does not receive any message, you can use the different scripts that Kafka provides such as:

```bash
bin/kafka-topics.sh --list --zookeeper localhost:2181
```

which will list all the topics that Kafka keeps record of, and then:

```bash
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ${topic_name} --from-beginning
```

to list all the messages on a specific *${topic_name}*.


## Kafka Streams: real-time data:
In the official documentation, Apache defines Kafka Streams as _"The 
easiest way to write mission-critical real-time applications
and microservices"_. It is, at its core, a flux-processing library
that works on top of Kafka. It offers a simplistic API, scalability, and
fault tolerance, and has the capability of integrating the processing
of real-time data streams in stateful applications. As an example,
this system has been used to track in real time the state of all the
stations in the public bicycle service of Madrid.

In our case, we are going to use the library to repurpose a laboratory
from this course. In particular, we aim to decouple the architecture that
allowed to capture tweets using `tweepy` for further analysis. The objective
is to have a Producer that captures the tweets and creates Records that are
sent into the system, and a Consumer that reads those Records, and later
performs an analysis on them.


## A More Complex Example

Now that you should be more confident on how to use both a Kafka consumer and producer, we will try to perform the [Laboratory Session 3](https://github.com/CCBDA-UPC/Assignments-2020/blob/master/Lab03.md) but instead of having a single code running, we will use a Kafka Producer to obtain the tweets, and the Kafka consumer will be the one in charge of processing them and creating a plot with the different hashtags obtained.

Focusing on the *KafkaProducer* part, we will need to add the `MyListener(StreamListener)` class that we created in the laboratory session but modifying it. The only change that this class requires is that instead of writing the content to a file, you should use the `send()` function in order to publish the tweets filtered. Here you can find the code from the lab session 3 that needs to be adapted:

```python
class MyListener(StreamListener):

    def on_data(self, data):
        try:
            with open('ArtificialIntelligenceTweets.json', 'a') as f:
                f.write(data)
                return True
        except BaseException as e:
            print("Error on_data: %s" % str(e))
        return True

    def on_error(self, status):
        print(status)
        return True
```


On the other hand, the *KafkaConsumer* code is the one that needs more adaptations. Let us approach this code by parts, so the first part we will focus on is the coding of the processing of tweets, which can be taken from the laboratory session 3 as follows:

```python
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
```

This code basically consists on structures to parse and process the tweets that were published in the topic assigned. A counter for each hashtag will also be needed, which can be also taken from the code of the lab session:

```python
count_hash = Counter()
```
which we will use to account the number of times a hashtag has appeared.

We will also need to initiate the *KafkaConsumer* as in the basic example. Furthermore, for each message in the consumer, we will need to process its text and extract the hashtags. For each hashtag, the `count_hash` will be updated and the plot will need to be created.

In the example of the [consumer](https://github.com/CCBDA-UPC/2020_Project_Tue_9_30/blob/master/research/examples/consumer_live_plotting.py) you can see that we have previously created a plot with matplotlib, and we update its content for each new tweet (and hence the hashtags it contains) live, simulating a "race chart".
