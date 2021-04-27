from classes.python.consumer import Consumer
from classes.python.producer import Producer
from classes.python.product  import Product

if __name__ == "__main__":
  product = Product("XBOX")

  producers = Producer.create_producers(product, 2)
  consumers = Consumer.create_consumers(product, 5)

  for producer in producers:
    producer.start()

  for consumer in consumers:
    consumer.start()