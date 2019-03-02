package array;

/**
 * @Author: Usher
 * @Date: 2019/3/2/0002
 * @Description:
 */
public class MaximumSwap {
    public int maximumSwap(int num) {

        int maxNum = num;
        String s = String.valueOf(num);
        char[] numCh = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char c = numCh[i];
                numCh[i] = numCh[j];
                numCh[j] = c;
                String tmp = new String(numCh);
                maxNum = Integer.max(maxNum, Integer.valueOf(tmp));
                c = numCh[i];
                numCh[i] = numCh[j];
                numCh[j] = c;
            }
        }
        return maxNum;
    }
}
