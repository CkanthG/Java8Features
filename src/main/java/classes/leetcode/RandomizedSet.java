package classes.leetcode;

import java.util.*;

class RandomizedSet {

    Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        Random rnd = new Random();
        Object[] arr = set.toArray();
        return (int) arr[rnd.nextInt(arr.length)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
