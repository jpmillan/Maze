# Maze
maze code challenge
--------------------------------
Problem:

Given a maze with the following structure

Please write a program that can solve the maze. The blank characters
represent empty space and the hash character (#) represents a wall.
The cursor is unable to travel through a wall, but is able to travel
in blank space.
The cursor must start on the S character and is not finished until
it
lands on the F character.
The program should take one parameter, the maze in text format and
should print the solved maze upon completion and exit.

Instructions:

- $ git clone https://github.com/jpmillan/Maze.git
- $ cd Maze
- to build and generate reports
- $ mvn clean install site

- to execute main class and use mazefile.txt for input (you may enter your own maze)
- $ mvn exec:java -Dexec.mainClass=com.jpmillan.maze.Main -Dexec.args="mazefile.txt"

- to execute main class and use 2 sample mazes in the main method to be solved
- $ mvn exec:java -Dexec.mainClass=com.jpmillan.maze.Main


Deliverables:

- coded in java 8 with best practices
- unit test using junit 5
- code coverage using jacoco (found in /target/site/jacoco/)
- code quality using spotbugs (found in /target/site/spotbugs.html)
