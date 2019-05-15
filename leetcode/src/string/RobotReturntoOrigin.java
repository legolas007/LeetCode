package string;

/**
 * @Author: Usher
 * @Date: 2019/5/15/0015
 * @Description:
 */
public class RobotReturntoOrigin {
    public boolean judgeCircle(String moves) {
        int[] count = new int[256];

        for (int i = 0; i < moves.length(); i++) {
            count[moves.charAt(i) - 'A']++;
        }

        return count['U' - 'A'] == count['D' - 'A'] && count['L' - 'A'] == count['R' - 'A'];
    }
}
