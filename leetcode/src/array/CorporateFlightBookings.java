package array;

/**
 * @Author: Usher
 * @Date: 2019/7/20,0020
 * @Description:
 */
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        for (int[] book : bookings) {
            for (int i = book[0]; i <= book[1]; i++) {
                res[i] += book[2];
            }
        }
        return res;
    }
}
