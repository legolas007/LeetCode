package tree;

/**
 * @Author: Usher
 * @Date: 2019/3/10/0010
 * @Description:
 */
public class WordFilter {
    private String[] input;

    public WordFilter(String[] words) {
        input = words;
    }

    public int f(String prefix, String suffix) {
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i].startsWith(prefix) && input[i].endsWith(suffix))
                return i;
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
