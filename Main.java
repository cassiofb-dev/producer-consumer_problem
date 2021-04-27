import classes.java.Consumer;
import classes.java.Producer;
import classes.java.Product;

public class Main {
  public static void main(String[] args) {
    Product product = new Product("XBOX");                        // Gera o XBOX

    Producer[] producers = Producer.createProducers(product, 2);  // gera um array com 5 produtores
    Consumer[] consumers = Consumer.createConsumers(product, 5);  // gera um array com 5 consumidores

    for (Producer producer : producers) producer.start();         // inicializa a producao
    for (Consumer consumer : consumers) consumer.start();         // inicializa o consumo
  }
}
