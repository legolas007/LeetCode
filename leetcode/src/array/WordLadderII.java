package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2018/12/31/0031
 * @Description:
 */
public class WordLadderII {


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);

        HashSet<String> set = new HashSet<>(wordList);
        set.remove(beginWord);

        LinkedList<List<String>> queue = new LinkedList<>();
        queue.offer(list);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<String> removeList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                List<String> thisList = new ArrayList<>(queue.poll());
                String thisWord = thisList.get(thisList.size() - 1);

                if (thisWord.equals(endWord)) {
                    res.add(new ArrayList<>(thisList));
                } else {
                    for (int j = 0; j < thisWord.length(); j++) {
                        char[] chars = thisWord.toCharArray();
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            chars[j] = ch;
                            String sb = new String(chars);
                            if (set.contains(sb) && !sb.equals(thisWord) && !thisList.contains(sb)) {
                                thisList.add(sb);
                                removeList.add(sb);
                                queue.offer(new ArrayList<>(thisList));
                                thisList.remove(thisList.size() - 1);
                            }
                        }
                    }
                }

            }
            for (String aRemoveList : removeList) {
                set.remove(aRemoveList);
            }
            if (!res.isEmpty()) {
                break;
            }
        }
        return res;

    }
}
