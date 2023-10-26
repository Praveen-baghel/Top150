import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.remove(val);
        int lastitem = list.remove(list.size() - 1);
        if (lastitem != val) {
            list.set(index, lastitem);
            map.put(lastitem, index);
        }
        return true;

    }

    public int getRandom() {
        int randomIdx = (int) (Math.random() * list.size());
        return list.get(randomIdx);
    }
}
