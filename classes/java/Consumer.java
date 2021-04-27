package classes.java;

public class Consumer extends Thread{

  Product product;              // produto a ser consumido

  Consumer(Product product) {
    this.product = product;     // atribui o produto para o consumidor
  }

  @Override
  public void run() { // tenta consumir dez produtos
    for(int i = 0; i < 10; i++) try {
      this.product.consume(this.getName());
      sleep((long)(Math.random() * 2000) + 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  // gera um array de consumidores
  public static Consumer[] createConsumers(Product product, int consumersNumber) {
    Consumer[] consumers = new Consumer[consumersNumber];

    for (int i = 0; i < consumers.length; i++) consumers[i] = new Consumer(product);

    return consumers;
  }
}
