
package ali.haider;
import java.util.Scanner;

public class Question {
     String QuestionText;
     String Answer1;
     String Answer2;
     String Answer3;
     String Answer4;
     int CorrectAnswer;
    //setting the values for private data members accessor specifiers
    public final void setValues(String q, String a1, String a2, String a3, String a4, int ca)
    {
        QuestionText=q;
        Answer1 = a1;
        Answer2 = a2;
        Answer3 = a3;
        Answer4 = a4;
        CorrectAnswer = ca;
    }
    public final int GetCorrectAnswer()
    {
        return CorrectAnswer;
    }
    // function to ask questions
    public final int askQuestion()
    {

        // Print the questions
        System.out.print("\nQuestion ");
        System.out.print(QuestionText);
        System.out.print("\n");
        System.out.print("1. ");
        System.out.print(Answer1);
        System.out.print("\n");
        System.out.print("2. ");
        System.out.print(Answer2);
        System.out.print("\n");
        System.out.print("3. ");
        System.out.print(Answer3);
        System.out.print("\n");
        System.out.print("4. ");
        System.out.print(Answer4);
        System.out.print("\n");
        System.out.print("\n");

        //reseting the answered variable
        int answeredOption = 0;
        // Display the answer
        System.out.print("What is your answer?(in number)");
        System.out.print("\n");
        Scanner scan=new Scanner(System.in);

        answeredOption = scan.nextInt();
        //printing the select option
        switch (answeredOption){
            case 1:
                System.out.print("\n");
                System.out.print("You answered ");
                System.out.print(Answer1);
                System.out.print("\n");
                break;
            case 2:
                System.out.print("\n");
                System.out.print("You answered ");
                System.out.print(Answer2);
                System.out.print("\n");
                break;
            case 3:
                System.out.print("\n");
                System.out.print("You answered ");
                System.out.print(Answer3);
                System.out.print("\n");
                break;
            case 4:
                System.out.print("\n");
                System.out.print("You answered ");
                System.out.print(Answer4);
                System.out.print("\n");
                break;
        }
        return answeredOption;
    }
    //function to check answer
    public final boolean CheckAnswer(int answeredOption)
    {
        // If the answer is correct
        if (answeredOption == CorrectAnswer)
        {
            System.out.print("\n");
            System.out.print("Correct !");
            System.out.print("\n");
            return true;
        }

        // Otherwise
        else
        {
            System.out.print("\n");
            System.out.print("Wrong !");
            System.out.print("\n");
            System.out.print("\n");
            return false;

        }
    }

}
