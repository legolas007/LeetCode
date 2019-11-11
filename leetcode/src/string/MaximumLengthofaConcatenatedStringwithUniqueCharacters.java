package string;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/11/3,0003
 * @Description:
 */
public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {

    private List<List<String>> res = new ArrayList<>();

    public int maxLength(List<String> arr) {
        int max = Integer.MIN_VALUE;
        subsets(arr);

        for (List<String> list : res){
            Set<Character> set = new HashSet<>();

            boolean flag = true;
            for (String s : list){
                for (int i = 0; i < s.length(); i++) {
                    if (!set.add(s.charAt(i))) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                max = Math.max(set.size(), max);
            }
        }

        return max;
    }

    private void subsets(List<String> arr){
        List<String> list = new ArrayList<>();
        for (int i = 0;i <= arr.size();i++){
            backtracking(arr,i,0,list);
        }
    }
    public void backtracking(List<String> arr,int k,int s,List<String> list){

        if (k == 0)//已经找到了k个数字的组合，加入全局res
            res.add(new ArrayList<>(list));
        else {
            for (int j = s;j < arr.size();j++){
                //[1]->[1,2]
                list.add(arr.get(j));//尝试加入
                //寻找[1,2]开头的集合，开始回溯，下次要找的数字减少一个k-1
                backtracking(arr,k-1,j+1,list);
                /**
                 * 每次找到了1,2这一对答案以后，下一次希望2退出然后让3进来，
                 * 1 3就是我们要找的下一个组合。如果不回退，找到了2 ，3又进来，找到了3，4又进来，所以就出现了错误答案
                 *
                 */
                //回退，每次清除一个空位 让后续元素加入。寻找成功，最后一个元素要退位，寻找不到，
                // 方法不可行，那么我们回退，也要移除最后一个元素
                //[1,2]->[1]
                list.remove(list.size()-1);
            }
        }
    }
}
