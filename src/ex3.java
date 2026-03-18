import java.util.Scanner;
public class ex3 {
    public static boolean fun3(int n, int i) {
        if(n==2) return true;
        if (n % i == 0) return false;
        if (i * i >= n) return true;
        return fun3(n, i + 1);
    }
    public static void main(String[] args) {
        IO.println(fun3(127, 2) ? "Prime" : "Composite");
    }

}