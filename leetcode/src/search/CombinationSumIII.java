package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * 从 1-9 数字中选出 k 个数，使得它们的和为 n。
 */
public class CombinationSumIII {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k,int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1;i <= 9;i++){
            list.add(i);
            backtracking(k-1,n-i,list,i);
            list.remove(0);
        }
        return res;
    }
    public void backtracking(int k,int n,List<Integer> list,int s){
        if (k == 0&&n == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (k == 0|| n == 0)
            return;
        for (int i = s+1;i <= 9;i++){// 只能访问下一个元素，防止遍历的结果重复
            list.add(i);
            backtracking(k-1,n-i,list,i);
            list.remove(list.size()-1);
        }
    }
}
