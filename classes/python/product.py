from threading import Condition

class Product(Condition):

  def __init__(self, name):
    super().__init__()
    self.name = name
    self.available = False
  
  def consume(self, id_thread):
    while self.available == False:
      with self:
        print(f"########## Consumer: {id_thread} waiting...")
        self.wait()

    self.available = False

    print(f"\t\tConsumer: {id_thread}")
    print(f"\t\t\tConsumed: {self.name}\n")

    self.notifyAll()

  def produce(self, id_thread, name):
    while self.available == True:
      with self:
        print(f"########## Producer: {id_thread} waiting...")
        self.wait()

    self.available = True
    self.name = name

    print(f"\nProducer: {id_thread}")
    print(f"\tProduced: {self.name}")

    self.notifyAll()