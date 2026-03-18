public class ex7 {
    public static void func7(int[] arr, int n) {
        IO.println(arr[n-1]);
        if(n==1) return;
        func7(arr,n-1);
    }
    public static void main(String[] args) {
        int l=4;
        int[] arr = {1,3,3,4,8,5};
        func7(arr, arr.length);
    }
}
