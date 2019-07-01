package array;

/**
 * @Author: Usher
 * @Date: 2019/06/30,0030
 * @Description:
 */
public class ConstructtheRectangle {
    public int[] constructRectangle(int area) {
        int[] ans = new int[]{area, 1};

        for (int i = area; i >= 1; i--) {
            for (int j = 1; j <= Math.sqrt(area); j++) {
                if (i * j > area) {
                    break;
                }
                if (i >= j && i * j == area) {
                    if (i - j <= ans[0] - ans[1]) {
                        ans[0] = i;
                        ans[1] = j;
                    }else break;
                }
            }
        }
        return ans;
    }

    public int[] constructRectangle2(int area) {
        Double root=Math.sqrt(area);
        int w=(int) Math.floor(root);
        while(area%w!=0) w--;
        return new int[]{area/w, w};
    }
}
