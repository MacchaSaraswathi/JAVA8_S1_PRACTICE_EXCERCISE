package problemStatement_3;

//TestCalculator class
public class TestCalculator extends Calculator {

public static void main(String[] args) {
   Calculator calculator = new Calculator();

   // Using Lambda Expressions for addition, subtraction, multiplication, and division
   IntegerMath addition = (a, b) -> {
       System.out.println("Addition is: " + (a + b));
       return a + b;
   };

   IntegerMath subtraction = (a, b) -> {
       System.out.println("Subtraction is: " + (a - b));
       return a - b;
   };

   IntegerMath multiplication = (a, b) -> {
       System.out.println("Multiplication is: " + (a * b));
       return a * b;
   };

   IntegerMath division = (a, b) -> {
       System.out.println("Division is: " + (a / b));
       return a / b;
   };

   // Testing each operation
   calculator.operationBinary(20, 10, addition);
   calculator.operationBinary(30, 20, subtraction);
   calculator.operationBinary(10, 20, multiplication);
   calculator.operationBinary(20, 10, division);
}
}


