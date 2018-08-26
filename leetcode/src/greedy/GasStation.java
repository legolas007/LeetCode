package greedy;

/**
 * @Author: Usher
 * @Description:
 * 假设现在我们到达了第i个油站，这时候还剩余的油量为sum，
 * 如果 sum + gas[i] - cost[i]小于0，我们无法
 * 走到下一个油站，所以起点一定不在第i个以及之前的油站里面（都铁定走不到第i +1号油站）
 * ，起点只能在i + 1后者后面。
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0;
        int total = 0;
        int k = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                k = i + 1;
                sum = 0;
            }

            //total += gas[i] - cost[i];
        }
        /*if (total < 0) {
            return -1;
        } else
            return k;*/
        return k;
    }
}
