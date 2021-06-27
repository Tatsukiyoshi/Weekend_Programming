// https://java.keicode.com/lang/flow.php
// javac -encoding utf-8 EmployeeTestApp1.java
package classes;

public class EmployeeTestApp1 {
     public static void main(String[] args) {
          Employee p = new Employee( 20, "Ichiro Suzuki", 100 );

          System.out.println( p.getAge() );
          System.out.println( p.getName() );
          System.out.println( p.getEmployeeID() );
     }
}
