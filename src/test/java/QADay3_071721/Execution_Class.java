package QADay3_071721;

public class Execution_Class {

    public static void main(String[] args) {
        //process of calling a static method to another class is known as inheritance
        //adding two numbers
        //Reusable_Methods.addTwoNumbers(20,20);

        //subtracting two numbers
        Reusable_Methodssss.subtractTwoNumber(50,20);

        int result = Reusable_Methodssss.addTwoNumbersForReturn(10,20);
        int newResult = result + 5;
        System.out.println("New result is " +  newResult);

    }//end of main method
}//end of java class
