package com.mycompany.app;

import java.io.*;
import java.util.*;
import com.github.javaparser.ast.*;
import com.github.javaparser.*;
import com.github.javaparser.ast.visitor.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.*;
import com.github.javaparser.ast.expr.*;

public class App {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("test1.java");

        CompilationUnit cu = JavaParser.parse(in);
        removeComments(cu);
        new MethodVisitor().visit(cu, "test1");
    }

    private static void removeComments(CompilationUnit cu) {
        List<Comment> commentList = cu.getComments();
        Iterator<Comment> it = commentList.iterator();
        while (it.hasNext()) {
            Comment c = it.next();
            c.remove();
        }
    }

    /**
     * Simple visitor implementation for visiting MethodDeclaration nodes.
     */
    private static class MethodVisitor extends VoidVisitorAdapter<String> {
        @Override
        public void visit(MethodDeclaration method, String filename) {

            removeAnnotations(method);
            String path = getOutputPath(method, filename);

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                                                            new FileOutputStream(path), "utf-8"))) {
                writer.write(method.toString());
            } catch (IOException e) {
                System.out.println("Got something wrong.");
            }
            System.out.println(path + " done");
            super.visit(method, filename);
        }

        private static void removeAnnotations(MethodDeclaration m) {
            m.setAnnotations(new NodeList<AnnotationExpr>());
        }

        private static String getOutputPath(MethodDeclaration method, String filename) {
            String funName = method.getName().toString();
            return "./functions/" + filename + "_" + funName;
        }
    }
}