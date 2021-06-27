// https://java.keicode.com/lang/classes-objects.php
// javac -encoding utf-8 Employee.java
package classes;

public class Employee extends Person {
     private int employeeID;

     public Employee( int a, String n, int eid ) {
          super( a, n );
          employeeID = eid;
     }

     public void setEmployeeID( int eid ) {
          employeeID = eid;
     }

     public int getEmployeeID() {
          return employeeID;
     }
}
