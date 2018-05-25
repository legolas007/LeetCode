package dp;

/**
 * @Author: Usher
 * @Description:
 */
public class LargestSumofAverages {
    public double largestSumOfAverages(int[] A, int K) {
        int[] cumulativeSum = new int[A.length];
        cumulativeSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + A[i];
        }
        double[][] memo = new double[A.length][K + 1];
        return largestSumofAveragesFrom(A, K, 0, cumulativeSum, memo);
    }

    private double largestSumofAveragesFrom(int[] A, int K, int start, int[] cumulativeSum, double[][] memo) {
        if (memo[start][K] != 0) {
            return memo[start][K];
        }
        if (K == 1) {
            memo[start][1] = ((double)(cumulativeSum[A.length - 1] - cumulativeSum[start]  + A[start]) / (A.length - start));
            return memo[start][1];
        }
        double num = 0;
        for (int tail = start; tail + K - 1 < A.length; tail++) {
            num = Math.max(num, ((double)(cumulativeSum[tail] - cumulativeSum[start]  + A[start]) / (tail + 1 - start)) + largestSumofAveragesFrom(A, K - 1, tail + 1, cumulativeSum, memo));
        }
        memo[start][K] = num;
        return num;
    }

    public double largestSumOfAverages2(int[] A, int K) {
        if ( A.length == 0 ) {
            return 0;
        }
        //The idea is :
        //Answer(j,K) = Math.max ( Answer(j, K), Answer(j +1, K - 1) + Average( start, j ) ); = That's it. No more frills.
        //And final answer is Answer( start, K )
        //Base case would be K = 1.
        //So fill memo for K = 1, which is just average from j to end.

        //First get sums at each j.
        //So why A.length + 1 ? because sum[j] = sum[j-1] + A[j] , j - 1 would be negative for j = 0, so just extend the array by one more element, so your sum[1..A.length] corresponds to A[0...A.length-1]
        //Did you observer j <= A.length ? here when j == A.length sum[j] corresponds to all elemetns in A.

        double[] sum = new double[A.length + 1] ;

        //Here did you observe that sum[0] doesn't cause problem because sum[0] = 0.0 when the array was  created.
        for ( int j = 1; j <= A.length; j++ ) {
            sum[j] = sum[j-1] + A[j-1];

        }

        //Now lets fill our memo for base case K = 1.
        //Now again why in the God's name A.length + 1 ? because we are treating sum[] from 1 to A.length, and why K + 1? because K starts from 1 not 0 !!
        double[][] D = new double[A.length+1][K+1];

        for ( int j = 1; j <= A.length; j++ ) {
            D[j][1] =  ( sum[A.length] - sum[j-1] ) / ( A.length - j + 1 ); //Did you get this ? Basically at index = j, exclude the sum before j i.e. sum[j-1] from total sum i.e. sum[A.length] and divide by the remaining elements ( A.length - ( j - 1 ) )
        }

        //now implement Answer(j,K) = Math.max ( Answer(j, K), Answer(j +1, K - 1) + Average( start, j ) );
        return Answer( A, 1, K, D );

        //I think anybody can write a solution but finally it all boils down to how fast you can code it up elegantly... which is what comes with practice !
    }

    private double Answer( int[] A, int start, int K, double[][] D ) {

        if ( D[start][K] > 0 ) {
            return D[start][K];
        }

        double sum = 0.0;
        for ( int j = start; j < A.length; j++ ) {
            sum = sum + A[j-1]; //Because A's index starts from 0, but D's index starts from 1.
            //Just implemented -> Answer(j,K) = Math.max ( Answer(j, K), Answer(j +1, K - 1) + Average( start, j ) );
            D[start][K] = Math.max( D[start][K],  ( ( sum / ( j - start + 1 ) ) + Answer( A, j + 1, K - 1, D )  ) );
        }

        return D[start][K];

    }
}
