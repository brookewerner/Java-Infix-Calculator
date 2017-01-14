# Java-Infix-Calculator
Java code converts infix expressions to postfix then evaluates the expressions as postfix, utilizing stacks and queues

Project for CSC 172 The Science of Data Structures with Professor Ted Pawlicki.

-----

BRIEF DESCRIPTION OF THIS PROJECT

UseInfixCalc.java asks the user for the name of the file to be read from and the name of the file to save the answers to. UseInfixCalc.java then takes in each line from the file being read and places the individual operands and operators into arrays. The infix equations are then converted to postfix and evaluated in the InfixCalc.java file. In addition to the requirements of the project, I included the ability to handle modulus and exponent as well as handling the error when there is division by zero in the equation. In the files infix_expr_short.txt and answers.txt in my submission, lines 26-28 display the use of exponents, lines 29-32 display the use of modulus, and lines 33-34 display the handling of the error when dividing by zero.

-----

HOW TO COMPILE AND RUN THE CODE 

javac UseInfixCalc.java

java UseInfixCalc

-----

SAMPLE OUTPUT 

Enter the name of the destination you would like to read from followed by the name of the destination you would like the answers saved to.

infix_expr_short.txt answers.txt

-----

CONTENTS

InfixCalc.java
  
UseInfixCalc.java
	
Queue Folder - 
	a package containing the following files, to be imported in class InfixCalc.java used for the output queue in this project

 > DoublyLinkedList.java
      
 > MyDoubleNode.java
      
 > MyDoublyLinkedList.java

 > MyQueue.java

 > Queue.java
      
Stack Folder -
		a package containing the following files, to be imported in class InfixCalc.java and used for the operator stack in this project		
		
 > MyStack.java

> MyList.java
      
 > MyNode.java
  
 > SimpleLinkedList.java
  
 > Stack.java

answers.txt - 
		a sample of the resulting answers from when the file infix_expr_short.txt is used, as shown in the sample output in the OUTPUT.txt file

infix_expr_short.txt - 
		the sample file used to generate answers.txt, as provided by Prof. Ted Pawlicki with additional tests included
