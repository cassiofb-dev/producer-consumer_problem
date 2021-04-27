package classes.java;

public class Producer extends Thread {

  private Product product;      // produto a ser produzido

  public Producer(Product product) {
    this.product = product;     // atribui o produto para o produtor
  }

  @Override
  public void run() { // gera os produtos playstations, depois a sony fali :(
    for (int i = 0; i < 25; i++) try {

      this.product.produce(this.getName(), String.format("PS%d", i+1));
      sleep((long)(Math.random() * 1000) + 500);

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  // gera um array de produtores
  public static Producer[] createProducers(Product product, int producersNumber) {
    Producer[] producers = new Producer[producersNumber];

    for (int i = 0; i < producers.length; i++) producers[i] = new Producer(product);

    return producers;
  }
}
