package classes.designpatterns.structural.proxy;

import static java.lang.System.out;

public class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        out.println("Loading " + fileName + " from disk.");
    }

    @Override
    public void display() {
        out.println("Displaying " + fileName);
    }
}
