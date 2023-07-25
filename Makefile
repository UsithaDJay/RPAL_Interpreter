SRCDIR = src
ROOTDIR = .

# Define the Java compiler and flags
JAVAC = javac
JFLAGS = -d $(ROOTDIR)/ -sourcepath src

# List all your Java source files here
SOURCES = $(wildcard $(SRCDIR)/*.java)

# Define the main class
MAIN_CLASS = rpal20

# Default target to compile all .java files
all: $(SOURCES:$(SRCDIR)/%.java=$(ROOTDIR)/%.class)

# Rule for compiling each .java file to .class
$(ROOTDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) $(JFLAGS) $<

# Target for cleaning the generated .class files
clean:
	del /q .\*.class

.PHONY: all clean