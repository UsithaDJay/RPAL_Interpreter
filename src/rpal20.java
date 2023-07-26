import java.io.*;

import cseMachine.CSEMachine;
import parser.ParseException;
import parser.Parser;
import treeGenerator.AST;
import lexer.Scanner;

public class rpal20 {

    public static String fileName;

    public static void main(String[] args) {
       if (args.length != 1) {
           System.err.println("Usage: java rpal20 <input_file>");
           return;
       }

       String fileName = args[0];
        // String fileName = "test.txt";
        AST ast = null;

        ast = buildAST(fileName);
        ast.standardize();
        evaluateST(ast);
    }


    private static void evaluateST(AST ast){
        CSEMachine csem = new CSEMachine(ast);
        csem.evaluateProgram();
        System.out.println();
    }

    private static AST buildAST(String fileName){
        AST ast = null;
        try{
            Scanner scanner = new Scanner(fileName);
            Parser parser = new Parser(scanner);
            ast = parser.buildAST();
        }catch(IOException e){
            throw new ParseException("ERROR: Could not read from file: " + fileName);
        }
        return ast;
    }

}
