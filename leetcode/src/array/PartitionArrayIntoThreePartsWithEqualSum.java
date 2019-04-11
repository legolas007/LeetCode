package array;

/**
 * @Author: Usher
 * @Date: 2019/3/28/0028
 * @Description:
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;

        for (int a : A) {
            sum += a;
        }

        if (sum % 3 != 0) {
            return false;
        }

        sum /= 3;

        int tmpSum = 0,flag = 0;
        for (int a : A) {
            tmpSum += a;

            if (tmpSum == sum) {
                flag++;
                tmpSum = 0;
            }
        }
        return flag == 3;
    }

}
