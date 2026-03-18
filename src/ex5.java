public class ex5 {
    public static int fun5(int n){
        if (n==0) return 0;
        else if (n==1) return 1;
        return fun5(n-1)+fun5(n-2);
    }
    public static void main(String[] args){
        IO.println(fun5(5));
    }
}
