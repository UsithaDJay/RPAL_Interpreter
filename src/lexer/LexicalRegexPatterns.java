package lexer;

import java.util.regex.Pattern;

/*
 LexicalRegexPatterns.java

  This file contains the regular expressions (regex) matchers that comply with RPAL's lexical grammar.
  These regex patterns are used by the scanner to tokenize the input program.

  RPAL's lexical grammar includes patterns for identifying various tokens such as identifiers, letters,
  digits, punctuation symbols, operator symbols, spaces, strings, and comments.

  The file defines a class named LexicalRegexPatterns, which contains public static final Pattern objects
  representing the different regex patterns for each token category.

 */

public class LexicalRegexPatterns{

  // Character classes for regular expressions
  private static final String letterRegexString = "a-zA-Z";
  private static final String digitRegexString = "\\d";
  private static final String spaceRegexString = "[\\s\\t\\n]";
  private static final String punctuationRegexString = "();,";
  private static final String opSymbolRegexString = "+-/~:=|!#%_{}\"*<>.&$^\\[\\]?@";
  private static final String opSymbolToEscapeString = "([*<>.&$^?])";


  // Regex patterns for various token categories
  public static final Pattern LetterPattern = Pattern.compile("["+letterRegexString+"]");
  public static final Pattern IdentifierPattern = Pattern.compile("["+letterRegexString+digitRegexString+"_]");
  public static final Pattern DigitPattern = Pattern.compile(digitRegexString);
  public static final Pattern PunctuationPattern = Pattern.compile("["+punctuationRegexString+"]");

  // Create a regex pattern for operator symbols
  public static final String opSymbolRegex = "[" + escapeMetaChars(opSymbolRegexString, opSymbolToEscapeString) + "]";
  public static final Pattern OpSymbolPattern = Pattern.compile(opSymbolRegex);
  
  // Regex pattern for strings
  public static final Pattern StringPattern = Pattern.compile("[ \\t\\n\\\\"+punctuationRegexString+letterRegexString+digitRegexString+escapeMetaChars(opSymbolRegexString, opSymbolToEscapeString) +"]");
  
  // Regex pattern for spaces
  public static final Pattern SpacePattern = Pattern.compile(spaceRegexString);
  
  // Regex pattern for comments
  public static final Pattern CommentPattern = Pattern.compile("[ \\t\\'\\\\ \\r"+punctuationRegexString+letterRegexString+digitRegexString+escapeMetaChars(opSymbolRegexString, opSymbolToEscapeString)+"]"); //the \\r is for Windows LF; not really required since we're targeting *nix systems
  
  // Utility method to escape meta characters in a regex string
  private static String escapeMetaChars(String inputString, String charsToEscape){
    return inputString.replaceAll(charsToEscape,"\\\\\\\\$1");
  }
}