# Marienbad
Work on S1.01 as part of the first year of BUT Informatique.

This program represents a version of the game Marienbad.

# Language
* Java

# Setup
After downloading and unzipping the file, run the program "MarienbadJvsJ" for a 1-on-1 game or run the program "MariendadJvsO" for a game against the computer.

# Commands
All commands are to be executed from the root folder containing the "src" folder.  
Compilation:
* javac -Xlint:deprecation -cp ./class -d ./class ./src/*.java

Execution:
* java -cp ./class Start MarienbadJvsJ
* java -cp ./class Start MarienbadJvsO

# Warning
* At compile time, the program will create a "class" folder to store the .classes.
* This program was realized at the beginning of the first year, hence the presence of the files "Start.java" and "SimpleInput.java", files that were coded by the professors.
* The program has been coded in French (comments and display).
