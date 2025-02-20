package Games;

import java.util.Random;
import java.util.Scanner;

import static Utility.Utility.*;

public class Number_Guessing_Game {

    static Random random = new Random();

    static int Total_Wins = 0, Total_Lose = 0;

    public record Number_Game_Engine(int Min_Num, int Max_Num, int MaxGuesses) { }

    public static void main(String... args) {Controller();}
    
    public static void welcome() {

        System.out.println();
        System.out.println("+----------------------------------------+");
        System.out.println("|          Number Guessing Game          |");
        System.out.println("|----------------------------------------|");
        System.out.println("|                                        |");
        System.out.printf ("| Player Score:  Total Wins[ %02d ]        |\n", Total_Wins);
        System.out.printf ("|                Total Lose[ %02d ]        |\n", Total_Lose);
        System.out.println("|                                        |");
        System.out.println("|---------------- Levels ----------------|");
        System.out.println("|                                        |");
        System.out.println("|    Mode         Range    Total Guesses |");
        System.out.println("|                                        |");
        System.out.println("| 1. Easy        1 To 10         5       |");
        System.out.println("| 2. Normal      1 To 100        8       |");
        System.out.println("| 3. Hard        1 To 1000       5       |");
        System.out.println("| 4. Extreme     ? To ?          4       |");
        System.out.println("| 5. Custom                              |");
        System.out.println("+----------------------------------------+");
        System.out.println();

    }

    public static void Game(Number_Game_Engine Engine) {

        Scanner input = new Scanner(System.in);

        int random_num = RandomNum(Engine.Min_Num() , Engine.Max_Num());

        var Guess = 0;
        var user_num = 0;
        var RMax = Engine.Max_Num();
        var RMin = Engine.Min_Num();


        while(true) {

            if(Guess == Engine.MaxGuesses()) {
                System.out.println();
                System.out.println("+---------------Result----------------+");
                System.out.printf (" Guesses used: %d : %d\n", Guess, Engine.MaxGuesses());
                System.out.println(" Game Status: Lose");
                System.out.printf (" Random number is: %d\n", random_num);
                System.out.println("+-------------------------------------+");
                Total_Lose++;
                break;

            }

            if(user_num == random_num) {
                System.out.println();
                System.out.println("+---------------Result----------------+");
                System.out.printf (" Guesses used: %d : %d\n", Guess, Engine.MaxGuesses());
                System.out.println(" Game Status: Win ");
                System.out.println("+--------------------------------------+");
                Total_Wins++;
                break;

            }

            System.out.println();
            System.out.printf("Range %d : %d\n", RMin, RMax);
            System.out.printf("Current Guess: %d / %d\n", Guess, Engine.MaxGuesses());
            System.out.print ("Enter your Guess: ");

            user_num = input.nextInt();

            if (user_num < random_num && user_num > RMin)

                 RMin = user_num;

            else if (user_num > random_num && user_num < RMax)

                 RMax = user_num;

            Guess++;

        }

        System.out.print("\n Continue Game(Y/N): ");
        char cont = input.next().charAt(0);
        if(Character.toLowerCase(cont) == 'y') Controller();

        System.out.println("\nExiting.....");
        StopProgram();
    }

    public static Number_Game_Engine Modes() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your mode: ");

        int mode = input.nextInt();

         switch (mode) {

            case 1 -> {
                 return new Number_Game_Engine(1, 10, 5);
             }
            case 2 -> {
                 return new Number_Game_Engine(1, 100, 8);
             }
            case 3 -> {
                 return new Number_Game_Engine(1, 1000, 5);
             }
            case 4 -> {
                 return new Number_Game_Engine(RandomNum(1,100), RandomNum(1,100000) ,4);
             }

            case 5 -> {
                System.out.print("\nSet Custom Game: ");
                String GameInfo = input.nextLine();
                String[] part = GameInfo.split(",");

                int Min_Num = Integer.parseInt(part[0].trim());
                int Max_Num = Integer.parseInt(part[1].trim());
                int MaxGuesses = Integer.parseInt(part[2].trim());

                try {
                    return new Number_Game_Engine(Min_Num, Max_Num, MaxGuesses);

                }catch(Exception e){
                    HandleException(e);
                    StopProgram();
                }

            }

            default -> {
                System.out.println("System error-----------------invalid mode");
                System.exit(0);
            }
        }

        return null;

    }

    public static void Controller(){

        welcome();
        Number_Game_Engine Engine = Modes();
        System.out.println();
        Creating_Game();
        System.out.println();
        Game(Engine);

    }

    public static void Creating_Game(){
        for(int i = 0; i <= 100; i+= 5){

            System.out.printf("\rSystem Creating Game [ %02d %% ]", i);
            delay(1000);

        }
    }
}
