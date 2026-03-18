import java.util.Scanner;

public class ex2 {
    public static int fun2(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + fun2(arr, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,3,3,4};
        double avg = (double) fun2(arr, arr.length) / arr.length;
        System.out.println("Average: " + avg);
    }
}
