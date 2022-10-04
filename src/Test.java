import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Set<Integer>> res = new HashMap<Integer, Set<Integer>>();
        res.put(1,null);
        System.out.println("est vide : "+res.get(1).isEmpty());
    }
}
