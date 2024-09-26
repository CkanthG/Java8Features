package classes.designpatterns.structural.proxy;

public class ProxyDesignPattern {
    public static void main(String[] args) {
        ProxyImage proxyImage = new ProxyImage("test_10mb.jpg");
        proxyImage.display();
        System.out.println("------------------------------------------");
        proxyImage.display();
    }
}
