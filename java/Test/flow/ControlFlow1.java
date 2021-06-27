package flow;

// https://java.keicode.com/lang/flow.php
// javac -encoding utf-8 ControlFlow1.java
public class ControlFlow1 {
    public static void main(String[] args) {
         int i = 68;
         
         if( 80 < i ) {
              System.out.println( "A" );
         } else if( 60 < i ) {
              System.out.println( "B" );
         } else {
              System.out.println( "C" );
         }
    }
}
