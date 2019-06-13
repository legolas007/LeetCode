package math;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/6/11/0011
 * @Description:
 */
public class LetterTilePossibilities {

    Set<List<Character>> res = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        boolean[] visited = new boolean[chars.length];
        List<Character> list = new ArrayList<>();
        Arrays.sort(chars);
        backtracking(chars,list,visited);
        return res.size();
    }
    public void backtracking(char[] nums,List<Character> list,boolean[] visited){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i < nums.length;i++){
            if (i!=0&&nums[i] == nums[i-1]&&!visited[i-1])
                continue;
            if (visited[i])
                continue;
            visited[i] = true;
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            backtracking(nums,list,visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
