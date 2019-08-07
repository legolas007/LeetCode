package recursion;

/**
 * @Author: Usher
 * @Date: 2019/7/27,0027
 * @Description:
 */
public class KthSymbolinGrammar {
    public int kthGrammar(int N, int K) {
        String s = "0";
        return Integer.parseInt(String.valueOf(recursion(s, N, 0).charAt(K)));
    }

    String recursion(String s,int n,int cnt) {
        if (cnt == n) {
            return s;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                stringBuilder.append("01");
            } else stringBuilder.append("10");
        }
        cnt++;
        return recursion(stringBuilder.toString(), n, cnt);
    }

    public int kthGrammar2(int N, int K) {
        if (N == 1) return 0;
        if (kthGrammar(N-1, (K+1)/2) == 0)
            return K%2 == 0 ? 1 : 0;
        else
            return K%2 == 0 ? 0 : 1;
    }
}
