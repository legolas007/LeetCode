package dp;

/**
 * @Author: Usher
 * @Description:
 *
 */
public class PartitionArrayintoDisjointIntervals {
    public int partitionDisjoint(int[] A) {
        int leftMax = A[0];
        int max = A[0];
        int index = 0;
        for(int i=1; i<A.length; ++i){
            if(A[i]<leftMax){
                index = i; // left数组包含第i+1个数
                leftMax = max; // 当前最大值在index左边，即当前最大值为左边最大值
            }else{
                max = Math.max(max, A[i]);
            }
        }
        return index+1;
    }
    public int partitionDisjoint2(int[] A) {
        int[] dp = new int[A.length];
        for(int i=A.length-1;i>=0;i--){
            if(i==A.length-1){
                dp[i] = A[i];
            }else{
                dp[i] = Math.min(dp[i+1], A[i]);
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = -1;
        for(int i=0;i<A.length-1;i++){
            max = Math.max(max, A[i]);
            if(max <= dp[i+1]){
                ans = i+1;
                break;
            }
        }

        return ans;
    }
}
