from kafka import KafkaConsumer
from pymongo import MongoClient
from json import loads
from time import sleep

consumer = KafkaConsumer('numtest',
                         bootstrap_servers=['localhost:9092'],
                         auto_offset_reset='earliest',
                         enable_auto_commit=True,
                         group_id='my-group',
                         value_deserializer=lambda x: loads(x.decode('utf-8')))

# client = MongoClient('localhost:27017')
# collection = client.numtest.numtest

for message in consumer:
    message = message.value
    print('Receiving message')
    # collection.insert_one(message)
    print('{} received'.format(message))
