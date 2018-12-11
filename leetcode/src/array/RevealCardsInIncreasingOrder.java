package array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Usher
 * @Description:
 */
public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Deque<Integer> index = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            index.add(i);
        }

        int[] ans = new int[n];
        Arrays.sort(deck);
        for (int card : deck) {
            ans[index.poll()] = card;
            if (!index.isEmpty()) {
                index.add(index.poll());
            }
        }
        return ans;
    }
}