

public class Equilibrium {

    public static void main(String[] args) {

        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        int n = arr.length;

        System.out.print( equi(arr, n) + "\n" );
        System.out.print( equi2(arr, n) + "\n" );

    }

    private static int equi(int arr[], int n) {
        int k, m, l_sum, r_sum;
        for (k = 0; k < n; ++k) {
            l_sum = 0; r_sum = 0;
            for (m = 0; m < k; ++m) l_sum += arr[m];
            for (m = k + 1; m < n; ++m) r_sum += arr[m];
            if (l_sum == r_sum) return k; //equilibrium point found at element k
        }
        return -1; //no equilibrium point found
    }


    //this routine is preferred as it decreases the time complexity and can handle large numbers
    private static int equi2(int arr[], int n) {
        if (n == 0) return -1;
        long sum = 0;
        for (int i = 0; i < n; i++) sum += (long) arr[i]; //pass through array and get sum

        long sum_left = 0;
        for (int i = 0; i < n; i++) {
            long sum_right = sum - sum_left - (long) arr[i];
            if (sum_left == sum_right) return i;
            sum_left += (long) arr[i];
        }
        return -1; //no equilibrium point found
    }


} // end class
