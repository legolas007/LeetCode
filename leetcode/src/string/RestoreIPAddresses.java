package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description: IP地址总共有四段，每一段可能有一位，两位或者三位，范围是[0, 255]，
 * 题目明确指出输入字符串只含有数字，所以当某段是三位时，我们要判断其是否越界（>255)，
 * 还有一点很重要的是，当只有一位时，0可以成某一段，如果有两位或三位时，像 00， 01， 001， 011， 000等都是不合法的，所以我们还是需要有一个判定函数来判断某个字符串是否合法。这道题其实也可以看做是字符串的分段问题，在输入字符串中加入三个点，将字符串分为四段，每一段必须合法，求所有可能的情况
 * <p>
 * 由于每段数字最多只能有三位，而且只能分为四段，所以情况并不是很多，
 * 我们可以使用暴力搜索的方法，每一段都循环1到3，然后当4段位数之和等于原字符串长度时，
 * 我们进一步判断每段数字是否不大于255，然后滤去不合要求的数字，加入结果中即可，
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        for (int a = 1; a < 4; a++)
            for (int b = 1; b < 4; b++)
                for (int c = 1; c < 4; c++)
                    for (int d = 1; d < 4; d++) {
                        if (a + b + c + d == s.length()) {
                            int A = Integer.valueOf(s.substring(0, a));
                            int B = Integer.valueOf(s.substring(a, a + b));
                            int C = Integer.valueOf(s.substring(a + b, a + b + c));
                            int D = Integer.valueOf(s.substring(a + b + c));

                            if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
                                String unionStr = String.valueOf(A) + "." + String.valueOf(B)
                                        + "." + String.valueOf(C) + "." + String.valueOf(D);
                                if (unionStr.length() == s.length() + 3)
                                    result.add(unionStr);
                            }
                        }
                    }
        return result;
    }

    /**
     * 在调用递归之前用if语句来滤掉不符合题意的情况，
     * 这里面用了k != std::to_string(val).size()，其实并不难理解，
     * 比如当k=3时，说明应该是个三位数，但如果字符是"010"，那么转为整型val=10，
     * 再转回字符串就是"10"，此时的长度和k值不同了，这样就可以找出不合要求的情况了
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses_2(String s) {
        List<String> res = new ArrayList<String>();
        helper(s, 0, "", res);
        return res;
    }
    private void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) res.add(out);
            return;
        }
        for (int k = 1; k < 4; ++k) {
            if (s.length() < k) break;
            int val = Integer.parseInt(s.substring(0, k));
            if (val > 255 || k != String.valueOf(val).length()) continue;
            helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
        }
    }
}
