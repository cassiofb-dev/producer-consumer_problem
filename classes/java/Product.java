package classes.java;

public class Product {

  private String name;          // nome do produto
  private boolean available;    // se o produto esta disponivel

  public Product(String name) { // construtor do produto
    this.name = name;
    this.available = false;
  }

  public synchronized Product consume(String idThread) {
    while(this.available == false) {      // caso nao esteja disponivel espere
      try {
        System.out.println("########## Consumer: " + idThread + " waiting...");
        this.wait();
      } catch (InterruptedException e) {  // em caso de erro printar a pilha de rastros
        e.printStackTrace();
      }
    }

    this.available = false; // apos o consumo o produto nao esta mais disponivel

    notifyAll();            // notifica as outras threads que o produto nao esta disponivel

    System.out.println("\t\tConsumer: " + idThread);
    System.out.println("\t\t\tConsumed: " + this.name + "\n");

    return this;            // retorna o produto
  }

  public synchronized Product produce(String idThread, String name) {
    while(this.available == true) {       // caso esteja disponivel
      try {
        System.out.println("########## Producer: " + idThread + " waiting...");
        this.wait();
      } catch (InterruptedException e) {  // em caso de erro printar a pilha de rastros
        e.printStackTrace();
      }
    }

    this.available = true;  // apos a producao o produto esta disponivel
    this.name = name;       // atribui um nome para o produto produzido

    notifyAll();            // notifica as outras threads que o produto esta disponivel

    System.out.println("\nProducer: " + idThread);
    System.out.println("\tProduced: " + this.name);

    return this;
  }
}
