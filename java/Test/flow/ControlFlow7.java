package flow;

// https://java.keicode.com/lang/flow.php
// javac -encoding utf-8 ControlFlow7.java
public class ControlFlow7 {
     public static void main(String[] args) {
          int[] a = { 10, 20, 150, 300 };

          for( int i : a ) { 
               if( i < 100 ) {
                    continue;
               }          
               System.out.println( i );
          }
     }
}
