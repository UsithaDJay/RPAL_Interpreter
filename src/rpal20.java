/*
  rpal20.java

  This file contains the main class for the RPAL interpreter, which executes RPAL functional programs.

  The main class reads an RPAL program from the command-line argument (provided as <input_file>),
  constructs an abstract syntax tree (AST) for the program, standardizes the AST, and finally executes
  the standardized tree (ST) using the CSEMachine.

  Usage: java rpal20 <input_file>
*/

import java.io.*;

import cseMachine.CSEMachine;
import parser.ParseException;
import parser.Parser;
import treeGenerator.AST;
import lexer.Scanner;

public class rpal20 {

    public static String fileName;

    public static void main(String[] args) {

        // Check if the correct number of command-line arguments is provided
       if (args.length != 1) {
           System.err.println("Usage: java rpal20 <input_file>");
           return;
       }

       // Get the input RPAL program file name from the command line argument
       String fileName = args[0];
        // String fileName = "test.txt";
        AST ast = null;

        // Build the AST for the input program
        ast = buildAST(fileName);

        // Standardize the AST
        ast.standardize();

        // Evaluate the standardized AST using the CSEMachine
        evaluateST(ast);
    }


    // Build the AST for the input program
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

    // Evaluate the standardized AST using the CSEMachine
    private static void evaluateST(AST ast){
        CSEMachine csem = new CSEMachine(ast);
        csem.evaluateProgram();
        System.out.println();
    }

}
