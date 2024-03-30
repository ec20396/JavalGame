package ali.haider;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Test {
    public Boolean value;
  
    Test(Boolean value)
    {
  
        // Using wrapper class
        // so as to wrap integer value
        // in mutable object
        // which can be changed or modified
        this.value = value;
    }
}
class Test2 {
    public int value;
  
    Test2(int value)
    {
  
        // Using wrapper class
        // so as to wrap integer value
        // in mutable object
        // which can be changed or modified
        this.value = value;
    }
}

public class Main {
 
    public static void modification1(Test x)
    {
        x.value = true;
    }
    public static void modification2(Test x)
    {
        x.value = false;
    }  
    public static void modification(Test2 x, int value)
    {
        x.value = value;
    }
    public static void QuestionReadingFromFile(Question[] str, Test2 size) throws IOException
    {

        //Opening Question FILE
        int ch;
  
        // check if File exists or not
         Scanner read = new Scanner (new File("output.txt"));
             
        if(read==null)
        {   
            System.out.println("File not found");
        }
        else
        {
            //taking total number of Question in int
//C++ TO JAVA CONVERTER WARNING: The right shift operator was not replaced by Java's logical right shift operator since the left operand was not confirmed to be of an unsigned type, but you should review whether the logical right shift operator (>>>) is more appropriate:
            int size2;
            String str5;
         read.useDelimiter("[\\r\\n]+");   
            str5=read.next();
            size2 = Integer.parseInt(str5);
            modification(size,size2);
            int i = 0;
            //reading Each questions and Populate the Question class data members
            while (i != size.value)
            {
                String question;
                String ans1;
                String ans2;
                String ans3;
                String ans4;
                int correct;
                read.useDelimiter("/");   
                question=read.next();
                ans1=read.next();
                ans2=read.next();
                ans3=read.next();
                ans4=read.next();
               // str5=read.next();
               read.reset();
              // String strn=read.next();
               read.useDelimiter("[\\r\\n]+");   
                //char [] ch3=new char[2];
                String strn=read.next();
                //System.out.println(str5);
                char ch3[] = strn.toCharArray();
                correct=ch3[1] - '0';
//C++ TO JAVA CONVERTER WARNING: The right shift operator was not replaced by Java's logical right shift operator since the left operand was not confirmed to be of an unsigned type, but you should review whether the logical right shift operator (>>>) is more appropriate:
  
                //setting the member of question class and increamenting i
                str[i++].setValues(question,ans1,ans2,ans3,ans4,correct);
            }
        read.close();
        
        }
        // read from FileReader till the end of file
        
        // close the file
        //fstream file = new fstream();
        //file.open("Questions.txt");
        //Checking file not open then show error
        //file opened
        


    }
    public static int diceRoll()
    {
        int min=1;
        int max=6;
        double index2 = Math.random()*(max - min + 1) + min;  
        int value=(int) index2;
        System.out.print("\n\nDice rolled: ");
        System.out.print(value);
        System.out.print("\n");
        System.out.print("\n");
        return value;
    }

    public static void askQuestionAndTakeAnswers(Question[] questionArray, Test2 n, Player[] players)
    {
        //get random number within range
        int min=1;
        int max=6;
        double index2 = Math.random()*(max - min + 1) + min;  
        int index=(int) index2;
//tangible.RandomNumbers.seed(time(0));
        //int index = (tangible.RandomNumbers.nextNumber() % n);
        //reseting Answered boolan
        for (int i = 0; i < 4; i++)
        {
            players[i].isCorrect = false;
        }
        //samme question asked to each player
        for (int i = 0; i < 4; i++)
        {
            System.out.print("\n");
            System.out.print(players[i].name);
            System.out.print("'s Turn ");
            int answer = questionArray[index].askQuestion(); // it returns option selected number
            boolean isRight = questionArray[index].CheckAnswer(answer); // it uses the option number and check the answer
            players[i].isCorrect = isRight;

        }
    }

    public static void CheckingPlayersAnswers(Player[] players, int diceValue, int[] TrapsAndPass, Test isWin)
    {
        for (int i = 0; i < 4; i++)
        {
            if (players[i].isCorrect == true)
            {
                //if player new postion is no trap then minus one
                if (TrapsAndPass[players[i].position + diceValue] == -1)
                {
                    System.out.print("\n");
                    System.out.print("\n");
                    System.out.print(players[i].name);
                    System.out.print(" got traped and got one step back \n");
                    if (players[i].position != 0)
                    {
                        players[i].position -= 1;
                    }

                }
                else if (TrapsAndPass[players[i].position + diceValue] != 0)
                {
                    if (players[i].position + diceValue < 100)
                    {
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print(players[i].name);
                        System.out.print(" found secret passage and adds ");
                        System.out.print(TrapsAndPass[players[i].position + diceValue]);
                        System.out.print("\n");
                        players[i].position += diceValue + TrapsAndPass[players[i].position + diceValue];
                    }
                    else
                    {
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print(players[i].name);
                        System.out.print(" found secret passage");
                        System.out.print("\n");
                        players[i].position = 101;

                    }
                }
                else
                {
                    players[i].position += diceValue;
                }

                if (players[i].position > 99)
                {
                    System.out.print(players[i].name);
                    System.out.print("  Winsssss");
                    modification1(isWin);
                    break;
                }
            }
            else
            {

                if (players[i].position == 0)
                {
                    continue;
                }
                else
                {
                    players[i].position -= 1;
                    if (TrapsAndPass[players[i].position] == -1)
                    {
                        System.out.print("\n");
                        System.out.print(players[i].name);
                        System.out.print(" found the trap and got one more step back\n");
                        if (players[i].position != 0)
                        {
                            players[i].position -= 1;
                        }
                    }

                }

            }
        }
    }

    public static void bubbleSort(Player[] players)
    {
        for (int i = 0; i < 4 - 1; i++)
        {
            // Last i elements are already in place
            for (int j = 0; j < 4 - i - 1; j++)
            {
                if (players[j].position < players[j + 1].position)
                {
                    Player temp = new Player();
                    temp.isCorrect = players[j].isCorrect;
                    temp.name = players[j].name;
                    temp.position = players[j].position;
                    players[j].isCorrect = players[j + 1].isCorrect;
                    players[j].name = players[j + 1].name;
                    players[j].position = players[j + 1].position;
                    players[j + 1].isCorrect = temp.isCorrect;
                    players[j + 1].name = temp.name;
                    players[j + 1].position = temp.position;

                }
            }
        }
    }
    //taking player name from user
    public static void inputPlayersName(Player[] players)
    {
       
        for (int i = 0; i < 4; i++)
        {
            System.out.print("Enter Player ");
            System.out.print(i + 1);
            System.out.print(" Name: ");

            players[i].name = new Scanner(System.in).nextLine();
            players[i].position = 0;
        }
    }
    //print positoin and player name on console
    public static void ShowPlayersPosition(Player[] players)
    {
        bubbleSort(players); //it sorts then below code displays
        for (int i = 0; i < 4; i++)
        {
            System.out.print(players[i].name);
            System.out.print(" is at position ");
            System.out.print(players[i].position);
            System.out.print("\n");
        }
    }

    //seting traps and seceret passages randomly and set all other places to zero
    public static void SetTrapsAndPassage(int[] arr)
    {
        
        //seting all blocks to simple
        for (int i = 0; i < 100; i++)
        {
            arr[i] = 0;
        }
        //seting the traps
        for (int i = 0; i < 40; i++)
        {
            double ind= Math.random()*((100-1+1)+1);
            int index=(int) ind;
            arr[index] = -1;
        }
        //passagge that store add up in dice value for example it has 5 in it so it add to dice value and jump to that value
        
        for (int i = 0; i < 40; i++)
        {
            double ind= Math.random()*((80-1+1)+1);
            int index=(int) ind;
            double val= Math.random()*((7-1+1)+1);
            int value=(int) ind;
        
            arr[index] = 1 + value; //it randomly add the number
        }



    }
    //it prints all the posiotion of traps and passages
    public static void PrintTrapsAndPassage(int[] arr)
    {
        int c = 0;

        System.out.print("Traps are at Position: ");
        for (int i = 0; i < 100; i++)
        {
            if (arr[i] == -1)
            {
                System.out.print(i);
                System.out.print("   ");
            }
        }
        System.out.print("\n");
        System.out.print("Passages are at position:  ");
        for (int i = 0; i < 100; i++)
        {
            if (arr[i] == -1)
            {
                continue;
            }
            else if (arr[i] != 0)
            {
                System.out.print(i);
                System.out.print("   ");
            }
        }
        System.out.print("\n");
    }

    public static void SaveGame(Player[] players, int[] trapAndPassages) throws IOException
    {
		/*cout << "Enter the Save File name plz..(fileName.txt) \n";
		string str;
		getline(cin, str);
		*/
        
        File file = new File("saveFile.txt");
        
        if (file == null)
        {
            System.out.print("unable to open");
        }
        else
        {    //fout.write(str.charAt(i));
                            FileOutputStream fos = new FileOutputStream(file);
                
                BufferedOutputStream bos = new BufferedOutputStream(fos);
            char data='/';
            for (int i = 0; i < 4; i++)
            {

            //convert string to byte array

                byte[] bytes2 = players[i].name.getBytes();
                 
                 //write byte array to file
                 bos.write(bytes2);
                 bos.write(data);
                bos.write(players[i].position);
                bos.write(data);
           
            }

           bos.write(data);
           
            for (int i = 0; i < 100; i++)
            {
                bos.write(trapAndPassages[i]);
                bos.write(data);
            }
             bos.close();
            fos.close();
  
        }
  
    }

    public static void LoadGame(Player[] players, int[] TrapAndPassages) throws FileNotFoundException
    {
      Scanner read = new Scanner (new File("output.txt"));
        
        // read from FileReader till the end of file
       
            for (int i = 0; i < 4; i++)
            {
                read.useDelimiter("/");
                players[i].name=read.next();

                //C++ TO JAVA CONVERTER WARNING: The right shift operator was not replaced by Java's logical right shift operator since the left operand was not confirmed to be of an unsigned type, but you should review whether the logical right shift operator (>>>) is more appropriate:
                read.useDelimiter("[\\r\\n]+");
                players[i].position=read.nextInt();
               
               
                read.next();

            }

            for (int i = 0; i < 100; i++)
            {
                read.next();
//C++ TO JAVA CONVERTER WARNING: The right shift operator was not replaced by Java's logical right shift operator since the left operand was not confirmed to be of an unsigned type, but you should review whether the logical right shift operator (>>>) is more appropriate:
                
                TrapAndPassages[i]=read.nextInt();
            }
        
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {

        Player[] players =new Player[4];
        for(int i = 0; i < 4 ; i++)
        {
            players[i] = new Player();
        }
                
        int[] TrapsAndPassages = new int[110]; //trap and passage array
        Question[] QuestionsArray = new Question[110];
        for(int i = 0; i < 110 ; i++)
        {
           QuestionsArray[i]= new Question();
        }
        
        //int numOfQuestions = 0; //questions array

        System.out.print("Do you want to \n1) Load Game from saveFile \n2)New Game   \n");
        int select;
        Scanner s= new Scanner(System.in);
        select = s.nextInt();
        if (select == 1)
        {
            LoadGame(players, TrapsAndPassages);
        }
        else
        {
            SetTrapsAndPassage(TrapsAndPassages); //set traps and passages
            inputPlayersName(players); //taking input from user

        }
        Test2 noOfQuestions=new Test2(0);
        
        QuestionReadingFromFile(QuestionsArray,noOfQuestions); //read from file and populate the array
        Test isWin= new Test(false);
        
        while (!isWin.value)
        {
            PrintTrapsAndPassage(TrapsAndPassages);
            int diceValue = diceRoll(); //get dice value
            ShowPlayersPosition(players); //shows all sorted players positions
            System.out.println(QuestionsArray[0].QuestionText);
            askQuestionAndTakeAnswers(QuestionsArray, noOfQuestions,players); //it ask questions and check with correct answer and store the result in player struct

            CheckingPlayersAnswers(players, diceValue,TrapsAndPassages,isWin); //it chekc and do  arithmatic in position of the player and return isWin by refrence
            if (isWin.value == true)
            {
                System.out.print("\n Thank you for playing\n");
            }
            SaveGame(players, TrapsAndPassages);

        }






    }


}
