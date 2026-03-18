public class ex10 {
    public static int func10(int n,int m,int ans){
        if (n%ans==0 && m%ans==0) return ans;
        return func10(n,m,ans-1);
    }
    public static void main(String[] args){
        int n=12;
        int m=8;
        if (n>m)IO.println(func10(n,m,m));
        else IO.println(func10(m,n,n));
    }
}
