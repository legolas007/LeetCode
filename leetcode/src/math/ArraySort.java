package math;

/**
 * @Author: Usher
 * @Description:
 */
public class ArraySort implements Runnable{
    private  String num;

    public ArraySort(int num) {
        this.num = num + "";
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Integer.valueOf(num));
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] nums = { 3, 99, 855, 56, 1989, 8,12,13,1};
        for (int num : nums) {
            new Thread(new ArraySort(num)).start();
        }
    }
}
