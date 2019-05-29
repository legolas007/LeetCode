package array;


import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/5/28/0028
 * @Description:
 * 1223
 * heap sort
 */
public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(barcodes[i], 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue().compareTo(a.getValue())));
        pq.addAll(map.entrySet());

        int i = 0;
        while (pq.size() >= 2) {
            Map.Entry<Integer, Integer> entry1 = pq.remove();
            Map.Entry<Integer, Integer> entry2 = pq.remove();

            barcodes[i++] = entry1.getKey();
            barcodes[i++] = entry2.getKey();

            if (entry1.getValue() - 1 > 0) {
                entry1.setValue(entry1.getValue() - 1);
                pq.add(entry1);
            }
            if (entry2.getValue() - 1 > 0) {
                entry2.setValue(entry2.getValue() - 1);
                pq.add(entry2);
            }
        }
        if (pq.size() > 0)
            barcodes[i] = pq.peek().getKey();
        return barcodes;
    }
}
