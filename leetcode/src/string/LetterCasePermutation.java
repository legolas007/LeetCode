package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        StringBuilder  stringBuilder= new StringBuilder(S);

        dfs(stringBuilder,0, list);
        return list;
    }

    private void dfs(StringBuilder stringBuilder, int cur, List<String> list) {
        if (cur == stringBuilder.length()) {
            list.add(stringBuilder.toString());
            return;
        }

        dfs(stringBuilder,cur+1,list);
        if (!Character.isLetter(stringBuilder.charAt(cur))) {
            return;
        }


        stringBuilder.replace(cur,cur+1,String.valueOf((char)(stringBuilder.charAt(cur) ^ (1 << 5))));
        dfs(stringBuilder,cur+1,list);
        stringBuilder.replace(cur,cur+1,String.valueOf((char)(stringBuilder.charAt(cur) ^ (1 << 5))));
    }

    public List<String> letterCasePermutation_2(String S) {
        List<String> result=new ArrayList<>();
        permutation(S.toCharArray(),result,0);
        return result;
    }
    public void permutation(char []s, List<String> result,int index)
    {

        result.add(new String(s));
        for(int i=index;i<s.length;i++)
        {
            if(s[i]>='a'&&s[i]<='z')
            {
                s[i]-=32;
                permutation(s,result,i+1);
                s[i]+=32;
            }else if(s[i]>='A'&&s[i]<='Z')
            {
                s[i]+=32;
                permutation(s,result,i+1);
                s[i]-=32;
            }
        }
    }

}
