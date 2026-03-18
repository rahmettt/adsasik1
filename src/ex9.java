public class ex9 {
    public static int func9(String s){
        if (s.isEmpty()) return 0;
        return 1+func9(s.substring(1));
    }
    public static void main(String[] args){
        IO.println(func9("Hello"));
    }
}
