public class ex4 {
    public static int fun4(int n){
        if (n==0) return 1;
        return n*fun4(n-1);
    }
    public static void main(String[] args){
        IO.println(fun4(5));
    }
}
