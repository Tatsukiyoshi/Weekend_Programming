// javac -encoding utf-8 DataType.java

public class DataType {
    public static void main(String[] args) {
        String str = "Hello"; // String型
        int i = 1; // int型
        float f = 1e-1f; // 1×10^-1 float型
        double d = 1.0; // double型
        boolean b = true; // boolean型
 
        System.out.println("変数str は " + str + " です");
        System.out.println("変数i は " + i + " です");
        System.out.println("変数f は " + f + " です");
        System.out.println("変数d は " + d + " です");
        System.out.println("変数b は " + b + " です");
    }
}