REM Compile Kotlin Source and Make Jar File
call kotlinc-jvm.bat .\Hero.kt -include-runtime -d .\Hero.jar -cp .\

REM Compile Java Source
javac -encoding UTF-8 .\Jhava.java

REM Append Java Class to Jar File
jar uvf .\Hero.jar .\Jhava.class

REM Exceute Jar File
java -jar .\Hero.jar
