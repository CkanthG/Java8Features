package classes.designpatterns.creational.prototype;

import static java.lang.System.*;

public class ProtoTypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoType protoType = new ProtoType("Original");
        out.println(protoType);
        ProtoType copy = protoType.clone();
        out.println(copy);
    }
}
