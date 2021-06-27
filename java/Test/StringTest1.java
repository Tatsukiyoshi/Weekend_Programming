// https://java.keicode.com/lang/string.php
// javac -encoding utf-8 StringTestApp1.java
public class StringTest1 {
    public static void main(String[] args) {
         // 単純な String の出力
         String s1 = "Hello!";
         System.out.println( s1 );

         // char の配列から String を作る
         char[] c = { 'H', 'e', 'l', 'l', 'o', '!' };
         String s2 = new String( c );
         System.out.println( s2 );

         // 文字の結合
         String s3 = s1.concat( s2 );
         System.out.println( s3 );

         // 文字列を結合する時に + 演算子を使う
         System.out.println( s1 + " - " + s2 );

         // 長さ
         System.out.println( s1.length() );
    }
}
