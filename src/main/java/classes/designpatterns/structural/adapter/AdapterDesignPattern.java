package classes.designpatterns.structural.adapter;

import static java.lang.System.out;

public class AdapterDesignPattern {
    MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            out.println("Playing mp3 " + fileName + ".");
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            out.println("Invalid media ." + audioType + " format not supported");
        }
    }

    public static void main(String[] args) {
        AdapterDesignPattern audioPlayer = new AdapterDesignPattern();
        audioPlayer.play("mp3", "song.mp3");  // Output: Playing mp3 song.mp3.
        audioPlayer.play("mp4", "video.mp4"); // Output: Playing mp4 video.mp4.
        audioPlayer.play("vlc", "movie.vlc"); // Output: Playing vlc movie.vlc.
        audioPlayer.play("avi", "myvideo.avi"); // Output: Invalid media .avi format not supported
    }
}
