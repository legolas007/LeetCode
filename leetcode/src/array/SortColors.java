package array;

/**
 * @Author: Usher
 * @Description:
 */
public class SortColors {
    public void sortColors(int[] nums) {
        quick_sort(nums,0,nums.length-1);
    }

    private void quick_sort(int[] a, int l, int r) {
        if(l>=r)
            return;
        int i=l,j=r;
        int tmp=a[i];
        while(i<j)
        {
            while(i<j && a[j]>=tmp)// 从右向左找小于x的数来填a[i]
                --j;
            a[i] = a[j];//将a[j]填到a[i]中，a[j]就形成了一个新的坑
            while(i<j && a[i]<=tmp)// 从左向右找大于或等于x的数来填a[j]
                ++i;
            a[j] = a[i];//将a[i]填到a[j]中，a[i]就形成了一个新的坑
        }
        a[i] = tmp;//退出时，i等于j。将x填到这个坑中

        quick_sort(a,l,i-1);
        quick_sort(a, j + 1, r);
    }
}
