from threading import Thread
from random    import random
from time      import sleep

class Consumer(Thread):

  def __init__(self, product):
    super().__init__()
    self.product = product
  
  def run(self):
    for i in range(10):
      with self.product:
        self.product.consume(self.name)
        sleep(random() * 2 + 1)
  
  @classmethod
  def create_consumers(self, product, consumers_number):
    consumers = []

    for i in range(consumers_number):
      consumers.append(Consumer(product))
    
    return consumers