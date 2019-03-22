package array;

/**
 * @Author: Usher
 * @Date: 2019/3/21/0021
 * @Description:
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3 ) {
            return false;
        }

        int key = Integer.MAX_VALUE;
        for (int i = 1; i < A.length-1; i++) {
            //山
            if (A[i + 1] <= A[i] && A[i] >= A[i-1]) {
                key = i;
                break;
                //倒山
            }else if (A[i + 1] >= A[i] && A[i] <= A[i-1]) {
                return false;
            }
        }
        if (key != Integer.MAX_VALUE ) {
            for (int i = key; i < A.length-1; i++) {
                if (A[i] <= A[i + 1]) {
                    return false;
                }
            }
        } else return false;

        return true;

    }
}
