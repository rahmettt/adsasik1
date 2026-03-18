public class ex8 {
    public static boolean func8(String s, int n) {
        if (n == s.length()) return true;
        if (!Character.isDigit(s.charAt(n)))  return false;
        return func8(s, n + 1);
    }
    public static void main(String[] args){
        System.out.println(func8("1234r56", 0) ? "Yes" : "No");
    }
}
