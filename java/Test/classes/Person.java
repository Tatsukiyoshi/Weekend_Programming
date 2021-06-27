// https://java.keicode.com/lang/classes-objects.php
// javac -encoding utf-8 Person.java
package classes;

public class Person {
     // フィールド
     private int age;
     private String name;
     
     // コンストラクタ
     public Person( int a, String n ) {
          age = a;
          name = n;
     }
     
     public void setAge( int a ) {
          age = a;
     }
     
     public void setName( String n ) {
          name = n;
     }
     
     public int getAge() {
          return age;
     }
     
     public String getName() {
          return name;
     }
}
