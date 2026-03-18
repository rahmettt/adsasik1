public class ex6 {
    public static int func6(int n,int m){
        if (m<=1) return n;
        return n*func6(n,m-1);
    }
    public static void main(String[] args){
        IO.println(func6(2,10));
    }
}
