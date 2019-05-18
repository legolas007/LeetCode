package search;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/5/18/0018
 * @Description:
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        UnionFind uf = new UnionFind(accounts.size());
        for (int i = 0; i < accounts.size(); ++i) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); ++j) {
                String email = list.get(j);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    uf.union(emailToIndex.get(email), i);
                }
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            indexToEmails.computeIfAbsent(uf.find(emailToIndex.get(email)), list -> new ArrayList<>()).add(email);
        }
        for (Integer key : indexToEmails.keySet()) {
            Collections.sort(indexToEmails.get(key));
            indexToEmails.get(key).add(0, accounts.get(key).get(0));
        }
        return new ArrayList(indexToEmails.values());
    }
    private class UnionFind {
        int[] father;

        UnionFind(int size) {
            father = new int[size];
            for (int i = 0; i < size; ++i) {
                father[i] = i;
            }
        }

        private int find(int x) {
            int r = x;
            while (father[r] != r) {
                r = father[r];
            }
            while (father[x] != r) {
                int tmp = father[x];
                father[x] = r;
                x = tmp;
            }
            return r;
        }

        private void union(int x1, int x2) {
            int f1 = find(x1);
            int f2 = find(x2);
            if (f1 != f2) {
                father[f2] = f1;
            }
        }
    }
}
