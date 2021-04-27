from threading import Thread
from random    import random
from time      import sleep

class Producer(Thread):

  def __init__(self, product):
    super().__init__()
    self.product = product
  
  def run(self):
    for i in range(25):
      with self.product:
        self.product.produce(self.name, f"PS{i+1}")
        sleep(random() + 0.5)
  
  @classmethod
  def create_producers(self, product, producers_number):
    producers = []

    for i in range(producers_number):
      producers.append(Producer(product))
    
    return producers