# Tic-tac-toe

A Tic-Tac-Toe command line game for two players written in Java language using the MVC pattern. 
This is my project number zero, so there is no Maven or Gradle here to show that I know how to compile, run tests and the application using only the command line.

![Tic-tac-toe gif](https://raw.githubusercontent.com/hopetoknow/my-gifs/main/GIFs/Tic-tac-toe.gif)

[Asciinema URL](https://asciinema.org/a/zUasGLnmzfWLJfOhCSmzC6A5Q)

## Linux
To compile all source code files run this command:
```
find src -iname "*.java" | xargs javac -d out
```
To run the application:
```
java -cp out com.hopetoknow.xo.App
```
To run the tests you need to download the [Console Launcher](https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.2/junit-platform-console-standalone-1.8.2.jar) and then run these commands:
```
find src -iname "*.java" | xargs javac -d out
find test -iname "*.java" | xargs javac -d out -cp out:junit-platform-console-standalone-1.8.2.jar
java -jar junit-platform-console-standalone-1.8.2.jar --class-path out --scan-class-path
```

## Windows
To compile all source code files run this command:
```
dir /s /B src\*.java > sources.txt & javac -d out @sources.txt & del sources.txt
```
To run the application:
```
java -cp out com.hopetoknow.xo.App
```
To run the tests you need to download the [Console Launcher](https://junit.org/junit5/docs/current/user-guide/#running-tests-console-launcher) and then run these commands:
```
dir /s /B src\*.java > sources.txt & javac -d out @sources.txt & del sources.txt
dir /s /B test\*.java > sources.txt & javac -d out -cp out;junit-platform-console-standalone-1.8.2.jar @sources.txt & del sources.txt
java -jar junit-platform-console-standalone-1.8.2.jar --class-path out --scan-class-path
```
