package array;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.println;

/**
 * Np,检查一个数组里是否存在m个数的和等于某个值
 * @author usher
 *
 */
public class SomeKOfArray {
	private static int k = 0;
	private static int[] res = new int[100];
	private static int total = 0;
	static void CalSum(int[] a,int n, int sum) {
		if (k > 0) {
			if (sum == a[n-1]) {
				for (int i = k-1; i >= 0; --i) {
					System.out.print(res[i] + "+");
					total = res[i] + a[n-1];
				}
				System.out.println(a[n-1]);
			}
		}
		
		res[k++] = a[n-1];
		CalSum(a, n-1, sum-a[n-1]);
		k--;
		CalSum(a, n-1, sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n1 = scanner.nextInt();
		int n2 = scanner.nextInt();
		int[] arr = new int[n1];
		for (int i = 0; i < n1; i++) {
			arr[i] = scanner.nextInt();
		}
		CalSum(arr, n1,n2);

		List<String> strings = Arrays.asList("a", "a", "b", "c");
		strings.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		strings.sort(String::compareToIgnoreCase);

		System.out.println(total);
	}

}
