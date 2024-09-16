package classes.corejava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import static java.lang.System.*;

public class ReadingMap {

    public void readMapUsingWhile() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "abcd");
        map.put(2, "efgh");
        map.put(3, "ijkl");
        Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Integer, String> next = iterator.next();
            out.println(next.getKey() +" - "+ next.getValue());
        }
    }
    public void readMapUsingAdvancedForLoop() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "abcd");
        map.put(2, "efgh");
        map.put(3, "ijkl");
        for (Entry<Integer, String> map1 : map.entrySet()) {
            out.println(map1.getKey() +"-"+map1.getValue());
        }
    }
    public static void main(String[] args) {
        new ReadingMap().readMapUsingWhile();
        new ReadingMap().readMapUsingAdvancedForLoop();
    }
}
