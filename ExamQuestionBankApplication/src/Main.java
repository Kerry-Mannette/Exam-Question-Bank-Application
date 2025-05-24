import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static int t = 0;
    static int a = 0;
    public static void main(String[] args) {

        //Creation question banks
        LinkedList bankOne = new LinkedList();
        LinkedList bankTwo = new LinkedList();


        //Adding questions to question bank
        bankOne.addQuestion(new NodeData("What is Java1?", new String[]{"A programming language1", "A coffee brand", "A type of snake", "None of the above"}, "A programming language"));
        bankOne.addQuestion(new NodeData("What is Java2?", new String[]{"A programming language2", "A coffee brand", "A type of snake", "None of the above"}, "A programming language"));
        bankOne.addQuestion(new NodeData("What is Java3?", new String[]{"A programming language3", "A coffee brand", "A type of snake", "None of the above"}, "A programming language"));
        bankOne.shuffleQuestions();
        //Saving to file
        bankOne.saveToFile("Questions/multiple_choice.txt");

        //Adding questions to question bank
        bankTwo.addQuestion(new NodeData("What is Java1?", new String[]{"True1","False"}, "True"));
        bankTwo.addQuestion(new NodeData("What is Java2?", new String[]{"True2","False"}, "False"));
        bankTwo.addQuestion(new NodeData("What is Java3?", new String[]{"True3","False"}, "False"));
        bankTwo.shuffleQuestions();
        //Saving to files
        bankTwo.saveToFile("Questions/true_and_false.txt");



        //Menu
        System.out.println("1. Multiple Choice\n" +
                           "2. True and False\n");
        t = input.nextInt();


        if(t==1){
            System.out.println("Enter amount of questions.");
            a = input.nextInt();
            int c = 0;
            try {
                File myObj = new File("Questions/multiple_choice.txt");
                Scanner myReader = new Scanner(myObj);
                while (c<a*6) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                    c++;
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }else {
            System.out.println("Enter amount of questions.");
            a = input.nextInt();
            int c = 0;
            try {
                File myObj = new File("Questions/true_and_false.txt");
                Scanner myReader = new Scanner(myObj);
                while (c<a*4) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                    c++;
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }



    }
}