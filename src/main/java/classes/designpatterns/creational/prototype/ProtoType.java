package classes.designpatterns.creational.prototype;

public class ProtoType implements Cloneable{
    private final String name;

    public ProtoType(String name) {
        this.name = name;
    }

    public ProtoType clone() throws CloneNotSupportedException {
        return (ProtoType) super.clone();
    }

    @Override
    public String toString() {
        return "ProtoType{" +
                "name='" + name + '\'' +
                '}';
    }
}
