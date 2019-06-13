package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

public class TwoSumTest {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);

        for (int num : treeSet) {
            System.out.println(num);
        }
    }

}
