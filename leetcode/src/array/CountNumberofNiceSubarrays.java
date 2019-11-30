package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/11/10,0010
 * @Description:
 */
public class CountNumberofNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        LinkedList<Integer> deq = new LinkedList<>();
        deq.add(-1);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 1)
                deq.add(i);

            if (deq.size() > k + 1)
                deq.pop();

            if (deq.size() == k + 1)
                res += deq.get(1) - deq.get(0);
        }

        return res;
    }

    public int numberOfSubarrays2(int[] nums, int k) {
        int i = 0, j = 0, count = 0, left, right, n = nums.length, oddCount = 0;
        while(i < n && j < n){
            right = 0;

            while(j < n && (oddCount < k || oddCount == k && nums[j]%2 == 0)){
                if (nums[j]%2 == 1)
                    oddCount++;

                if (oddCount == k)
                    right++;

                j++;
            }

            if (j == n && oddCount < k)
                break;

            left = 0;
            while(i < j && oddCount == k){
                left++;
                if(nums[i++]%2 == 1) oddCount--;
            }

            count += left*right;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "wuxiaozeng@gaosiedu.com;bianjiang@gaosiedu.com;caiyongji@gaosiedu.com;caoxiaoping@gaosiedu.com;chaocuihua@gaosiedu.com;chenbing@gaosiedu.com;chenchuxiang@gaosiedu.com;chenzhiqin@gaosiedu.com;cuimeng@gaosiedu.com;dengchao@gaosiedu.com;dingpeng@gaosiedu.com;dongguangjin@gaosiedu.com;dongshasha@gaosiedu.com;fanmingrui@gaosiedu.com;fumengmeng@gaosiedu.com;fuwanrong@gaosiedu.com;gaiyi@gaosiedu.com;gaoxinzhong@gaosiedu.com;gaoyang3@gaosiedu.com;guanchao@gaosiedu.com;guiwankai@gaosiedu.com;guoxingrong@gaosiedu.com;guozhiyuan@gaosiedu.com;hanlei@gaosiedu.com;huanghuchuan@gaosiedu.com;huangzhigang@gaosiedu.com;qiexuyang@gaosiedu.com;jiayuepeng@gaosiedu.com;kanyaoguang@gaosiedu.com;kongxiangbin@gaosiedu.com;leiguanghua@gaosiedu.com;liangxiujie@gaosiedu.com;lianlingfei@gaosiedu.com;lihong0@gaosiedu.com;limeng0@gaosiedu.com;limenglin@gaosiedu.com;liruixin@gaosiedu.com;liuchunqiang@gaosiedu.com;liumengqing@gaosiedu.com;liuqingbiao@gaosiedu.com;liushuai@gaosiedu.com;liuwei@gaosiedu.com;liuyang7@gaosiedu.com;liuyihao@gaosiedu.com;liuzhishuo@gaosiedu.com;liweixiang@gaosiedu.com;lixin1@gaosiedu.com;liying7@gaosiedu.com;liyuan0@gaosiedu.com;lizhiming@gaosiedu.com;lizhucheng@gaosiedu.com;lvqiuling@gaosiedu.com;lvxiaodong@gaosiedu.com;majingna@gaosiedu.com;mengya@gaosiedu.com;outao@gaosiedu.com;qinli@gaosiedu.com;qiyajing@gaosiedu.com;renyuechao@gaosiedu.com;shangbaoli@gaosiedu.com;songjisai@gaosiedu.com;sunainuo@gaosiedu.com;tanhanlin@gaosiedu.com;qinsirun@gaosiedu.com;tianhuiying@gaosiedu.com;tiantian@gaosiedu.com;wangao@gaosiedu.com;wangdepeng@gaosiedu.com;wangmiao@gaosiedu.com;wangqiang1@gaosiedu.com;wangshanshan@gaosiedu.com;wangshuai@gaosiedu.com;wangtiantian@gaosiedu.com;wangxing@gaosiedu.com;wangxiushuai@gaosiedu.com;wangyanling@gaosiedu.com;wangyingying0@gaosiedu.com;wuxiabing@gaosiedu.com;xiaoyanhui@gaosiedu.com;xuge@gaosiedu.com;xuyihe@gaosiedu.com;yanghaijiao@gaosiedu.com;yangtao@gaosiedu.com;yaoran@gaosiedu.com;zhaihonglian@gaosiedu.com;zhangbin@gaosiedu.com;zhangdong@gaosiedu.com;zhangjin@gaosiedu.com;zhangkai@gaosiedu.com;zhangyinhui@gaosiedu.com;zhaosongyan@gaosiedu.com;zhaoyan1@gaosiedu.com;zhouchengcheng@gaosiedu.com;zoudaifa@gaosiedu.com;";
        String[] strings = s.split(";");
        for (int i = 0; i < strings.length; i++) {
                strings[i] = "\"" + strings[i] + "\"";
        }
        List<String> list = Arrays.asList(strings);
        System.out.println(list.size());

    }
}
