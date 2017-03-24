package com.mycompany.app;
import java.io.*;
import com.github.javaparser.ast.*;
import com.github.javaparser.*;
/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("test.java");

        // parse the file
        CompilationUnit cu = JavaParser.parse(in);

        // prints the resulting compilation unit to default system output
        System.out.println(cu.toString());
    }
}
