package lexer;

/*
 TokenType.java

  This file contains the definition of the TokenType enum, which represents the type of tokens
  constructed by the scanner. Each token in the input program is classified into one of the token
  types defined in this enum.

 */

// Enumerated type for token types
public enum TokenType{
  IDENTIFIER,
  INTEGER,
  STRING,
  OPERATOR,
  DELETE,
  L_PAREN,
  R_PAREN,
  SEMICOLON,
  COMMA,
  RESERVED; // Represents a token for reserved RPAL keywords (e.g., let, in, fn, rec, etc.)
            // It is used to distinguish reserved keywords from other identifiers
            // to simplify the parser logic.
}
