package dp;

/**
 * @Author: Usher
 * @Description:
 */
public class ClimbingStairs {
/*
//递推dp
public int climbStairs(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        for (int i =2;i <= n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }*/

/*
public int  climbStairs(int n){
    int[] f = new int[n+1];
    return numOfSolution(n,f);

}
public int numOfSolution(int n,int[] f){
    if (n <= 1)
        return 1;
    //记忆化递归防止重复计算
    if (f[n] > 0)
        return f[n];
    f[n] = numOfSolution(n-1,f) + numOfSolution(n-2,f);
    return f[n];
}*/
//O(1)空间
public int climbStairs(int n){
    int two = 1;
    int one = 1;
    int cur = 1;
    for(int i=2;i <= n;i++){
        cur = two + one;
        two = one;
        one = cur;
    }
    return cur;
}
}
