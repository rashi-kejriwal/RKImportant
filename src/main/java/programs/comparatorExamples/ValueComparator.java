package programs.comparatorExamples;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
class ValueComparator implements Comparator {
    Map map;

    public ValueComparator(Map map) {
        this.map = map;
    }

    public int compare(Object keyA, Object keyB) {
        Comparable valueA = (Comparable) map.get(keyA);
        Comparable valueB = (Comparable) map.get(keyB);
        return valueA.compareTo(valueB);
    }
}
