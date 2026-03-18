//ex1
public class Main {
    public static void fun1(int n){
        if(n<10){
            IO.println(n);
            return;
        }
        fun1(n/10);
        fun1(n%10);

    }
    public static void main(String[] args) {
        fun1(5481);
    }
}