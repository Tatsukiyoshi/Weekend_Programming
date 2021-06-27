// https://java.keicode.com/lang/anonymous-inner-class.php
// javac -encoding utf-8 AnonClassTest1.java
public class AnonClassTest1 {
     public static void main(String[] args) {
       
          MyInterface1 mi = new MyInterface1(){
               public void foo() {
                    System.out.println("Hello, anon class!");
               }
          };
       
          MyClass1 mc = new MyClass1(){
               public void bar(){
                    super.bar();
                    System.out.println("ANON: Hello, bar()!");
               }
          };
       
          mi.foo();
          mc.bar();
     }
}
