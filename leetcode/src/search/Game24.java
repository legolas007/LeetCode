package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/1/13/0013
 * @Description:
 */
public class Game24 {
    boolean res = false;
    final double eps = 0.001;

    public boolean judgePoint24(int[] nums) {
        List<Double> arr = new ArrayList<>();

        for (int n : nums)
            arr.add((double) n);

        helper(arr);
        return res;
    }

    void helper(List<Double> arr) {
        if (res)
            return;

        if (arr.size() == 1) {
            if (Math.abs(arr.get(0) - 24.0) < eps) {
                res = true;
            }
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < i; i++) {
                List<Double> next = new ArrayList<>();
                Double p1 = arr.get(i), p2 = arr.get(j);
                next.addAll(Arrays.asList(p1 + p2, p1 - p2, p2 - p1, p1 * p2));

                if (Math.abs(p2) > eps)
                    next.add(p1 / p2);

                if (Math.abs(p1) > eps)
                    next.add(p2 / p1);

                arr.remove(i);
                arr.remove(j);

                for (Double n : next) {
                    arr.add(n);
                    helper(arr);
                    arr.remove(arr.size() - 1);
                }

                arr.add(j, p2);
                arr.add(i, p1);
            }
        }

    }

    public boolean judgePoint24_2(int[] nums) {
        boolean[] vis = new boolean[4];
        double[] arr = new double[4];
        for (int i=0; i<4; i++) arr[i] = 1.0 * nums[i];
        return f(arr, vis, 4);
    }

    boolean f(double[] arr, boolean[] vis, int available) {
        double prev = 0;
        if (available==1) {
            for (int i=0; i<arr.length; i++)
                if (!vis[i]) return Math.abs(arr[i] - 24) < 0.000001;
        }
        for (int i=0; i<arr.length; i++) {
            if (vis[i]) continue;
            // prev is for backtracking
            prev = arr[i];
            for (int j=i+1; j<arr.length; j++) {
                // calculate i & j
                if (vis[j]) continue;
                vis[j] = true;

                // add
                arr[i] = prev + arr[j];
                if (f(arr, vis, available-1)) return true;

                // minus
                arr[i] = prev - arr[j];
                if (f(arr, vis, available-1)) return true;
                arr[i] = -prev + arr[j];
                if (f(arr, vis, available-1)) return true;

                // multiply
                arr[i] = prev * arr[j];
                if (f(arr, vis, available-1)) return true;

                // division
                arr[i] = prev / arr[j];
                if (f(arr, vis, available-1)) return true;
                arr[i] = arr[j] / prev;
                if (f(arr, vis, available-1)) return true;

                vis[j] = false;
            }
            arr[i] = prev;
        }
        return false;
    }
}
