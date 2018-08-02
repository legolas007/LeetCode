package string;

/**
 * @Author: Usher
 * @Description:
 */
public class ShiftingLetters {
    public static String shiftingLetters(String S, int[] shifts) {
        StringBuilder stringBuilder = new StringBuilder();

        int sum = 0;
        for (int t : shifts) {
            sum += t%26;
        }
        int tmp = sum;
        for (int i = 0; i < S.length(); i++) {
            sum = tmp;
            for (int j = 0; j <i; j++) {
                sum -= shifts[j]%26;
            }
            //System.out.println(sum);
            stringBuilder.append((char)((S.charAt(i) - 'a' + sum) % 26 + 'a'));
            //stem.out.println((char)((S.charAt(i) - 'a' + sum) % 26 + 'a'));
        }

        return stringBuilder.toString();
    }

}
