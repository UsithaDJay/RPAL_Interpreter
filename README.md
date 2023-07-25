RPAL Interpreter
=======
This is an interpreter designed for the RPAL functional language, which stands for *Right-reference Pedagogic Algorithmic Language*. RPAL adheres to pure functional programming principles, meaning it does not involve concepts like assignment or memory. Instead of loops, RPAL relies solely on recursion for repetition. In RPAL, a program is expressed as a single expression, consisting primarily of function definitions and function applications.

RPAL functions can be partially applied, which aligns with typical functional programming practices. Moreover, in RPAL, functions are treated as first-class citizens, enabling them to be named, passed as arguments, returned from other functions, and used extensively throughout the program.

This system implements the following features (the modules responsible are given in parentheses):

| Features | Module |
| --------------|------------|
|Recursive-Descent parse a source file in accordance with RPAL's phrase structure grammar | Scanner |
|Create an abstract syntax tree | Parser |
|Standardize the abstract syntax tree | Parser |
|Execute the program by processing the standardized syntax tree in a Control-Stack-Execution Machine (CSEM). The CSEM manages the overhead of creating lambda closures including managing nested environments for those closures, providing basic functionality such as arithmetic or logical operations on RPAL data types etc. | Control Stack Execution Machine |

##### Scanner + Parser + Control-Stack Execution Machine == Interpeter!


How to use this RPAL Intepreter: (Two methods)
 
* *Method 1*
  
  Run the Makefile in the root directory
  <pre>make</pre>
  Then run rpal20 file giving rpal program file name as below(being in the root directory)
  ```sh
  java rpal20 <filename>
  ```
  or
  ```sh
  java rpal20 <filename with path>
  ```
  
* *Method 2*
  
  First Compile the java files in src package
  (If you are currently in the root directory you need to change your directory to "src" to compile its java files)
  <pre>cd src</pre>
  Now compile
  <pre>javac -d ../ rpal20.java</pre>
  (Compiled class files will be created in root directory if there are no erros in java files)

  Then change directory to root directory
  <pre>cd ../ </pre>

  After compiling and Assuming you are currently in the root directory, run rpal20 file giving rpal program file name as below
  ```sh
  java rpal20 <filename>
  ```
  or
  ```sh
  java rpal20 <filename with path>
  ```


* *To clean the compiled class files Run*
  <pre>make clean</pre>
