package math;

/**
 * @Author: Usher
 * @Date: 2019/3/28/0028
 * @Description:
 */
public class ComplementofBase10Integer {
    public int bitwiseComplement(int N) {
        String bin = Integer.toBinaryString(N);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '0') {
                stringBuilder.append('1');
            } else stringBuilder.append('0');

        }

        return Integer.parseInt(stringBuilder.toString(), 2);
    }
}
