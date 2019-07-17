package array;

/**
 * @Author: Usher
 * @Date: 2019/07/07,0007
 * @Description:
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int[] tmp = new int[arr.length];

        for (int i = 0, k = 0; k < arr.length && i < arr.length; i++) {
            if (arr[i] == 0) {
                tmp[k++] = 0;
                if (k < arr.length) tmp[k++] = 0;
            } else {
                tmp[k++] = arr[i];
            }
        }

        System.arraycopy(tmp, 0, arr, 0, arr.length);
    }
}
