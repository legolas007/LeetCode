package recursion;

/**
 * @Author: Usher
 * @Description:
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 *
 * Output:
 * false
 *
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 *
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        final int sum = maxChoosableInteger * (maxChoosableInteger + 1) >> 1;
        if (sum < desiredTotal)
            return false;
        if (desiredTotal <= 0)
            return true;

        int[] m_ = new int[1 << maxChoosableInteger];
        return helper(maxChoosableInteger,desiredTotal,0,m_);

    }

    private boolean helper(int M,int T,int state,int[] m_){
        //0:未知，1:可以赢，-1:不能赢
        if (T <= 0)
            return false;
        //记忆化
        if (m_[state] != 0)
            return m_[state] == 1;
        for (int i=0;i < M;i++){
            if (((state >> i)&1) == 0&&(i+1 >= T||!helper(M,T-i-1,state|(1<<i),m_))){
                m_[state] =1;
                return true;
            }
        }
        m_[state] = -1;
        return false;
    }

}
