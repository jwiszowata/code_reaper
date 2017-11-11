package com.mycompany.app;

import java.io.*;
import java.util.*;
import org.apache.commons.io.FilenameUtils;
import com.github.javaparser.ast.*;
import com.github.javaparser.*;
import com.github.javaparser.ast.visitor.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.*;
import com.github.javaparser.ast.expr.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class App {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < args.length; i++) {
            String path = args[i];
            if (!isTestFile(path)) {
                FileInputStream in = new FileInputStream(path);

                CompilationUnit cu = JavaParser.parse(in);
                removeComments(cu);
                new MethodVisitor().visit(cu, getFilenameWithoutExtension(path));
            }
        }
    }

    private static boolean isTestFile(String pathStr) {
        String test = "Test";
        String fileName = getFilenameWithoutExtension(pathStr);
        int length = fileName.length();
        String firstChars = fileName.substring(Math.max(length - test.length(), 0), length);
        System.out.println(firstChars);
        return firstChars.equals(test);
    }

    private static void removeComments(CompilationUnit cu) {
        List<Comment> commentList = cu.getComments();
        Iterator<Comment> it = commentList.iterator();
        while (it.hasNext()) {
            Comment c = it.next();
            c.remove();
        }
    }

    private static String getFilenameWithoutExtension(String pathStr) {
        Path path = Paths.get(pathStr);
        String filename = path.getFileName().toString();
        return FilenameUtils.removeExtension(filename);
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
            //System.out.println(path + " done");
            super.visit(method, filename);
        }

        private static void removeAnnotations(MethodDeclaration m) {
            m.setAnnotations(new NodeList<AnnotationExpr>());
        }

        private static String getOutputPath(MethodDeclaration method, String filename) {
            String funName = method.getNameAsString();
            int lines = countLines(method.toString());
            String dirPath = "./functions/" + lines + "/";
            (new File(dirPath)).mkdirs();
            String path = dirPath + funName + "_" + filename + ".java";
            return path;
        }

        private static int countLines(String s) {
            int counter = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '\n') {
                    counter++;
                } 
            }
            return counter + 1;
        }
    }
}