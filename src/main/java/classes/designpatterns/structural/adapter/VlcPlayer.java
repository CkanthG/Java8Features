package classes.designpatterns.structural.adapter;

public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing VLC " + fileName + ".");
    }

    @Override
    public void playMp4(String fileName) {
        // do nothing
    }
}
