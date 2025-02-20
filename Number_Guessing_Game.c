#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <stdbool.h>
#include <conio.h>
#include <time.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
#include <limits.h>

void numberGuessingGame();
char *Modes(int *, int *, int *, int);
void Clear_Screen();
void Build_Game();
void Two_Player_Mode(int);
void Float_Mode();

void Duration(int time)
{
  int Minutes = 0, Seconds = 0;
  char Duration[100];
  do
  {
    if (time < 60)
    {
      Seconds = time;
      break;
    }

    time -= 60;
    Minutes++;
  } while (time != 0);

  sprintf(Duration, "%d : %d", Minutes, Seconds);
  printf("Total Duration = %s\n", Duration);
}

int Player_score = 0;

int main()
{
  Clear_Screen();
  numberGuessingGame();
}

void numberGuessingGame()
{

  int randNum, Guesses = 0, num, Time, MaxGuesses = 0, Max = 0, Min = 0, RMax, RMin;

  char *ModeType = Modes(&Max, &Min, &MaxGuesses, Player_score);

  RMax = Max;
  RMin = Min;

  srand(time(0));

  randNum = (rand() % Max + 1 - Min) + Min;
  // Build_Game();
  time_t start, end;
  time(&start);

  while (true)
  {
    if (strcasecmp(ModeType, "Float (1.0 to 200.0 : 18 Guesses)"))
    {
      Float_Mode();
      break;
    }

    Clear_Screen();
    printf("+---------------------------------------+\n");
    printf(" Guesses: %d / %d\n", Guesses, MaxGuesses);
    printf(" Range: %d : %d\n", RMin, RMax);
    printf(" Mode: %s\n", ModeType);
    printf("+---------------------------------------+\n");

    if (Guesses == MaxGuesses)
    {
      time(&end);
      Clear_Screen();
      Time = difftime(end, start);
      printf("+==================Result=================+\n ");
      Duration(Time);
      printf("\n Game Mode: %s\n", ModeType);
      printf("\n You lose the game, The random number = %d\n", randNum);
      printf("+=========================================+\n\n");
      Player_score--;

      if (Player_score < 0)
      {
        Player_score = 0;
      }
      break;
    }

    printf("\nEnter your number: ");
    scanf("%d", &num);

    Guesses++;

    if (num == randNum)
    {
      time(&end);
      Clear_Screen();
      Time = difftime(end, start);

      printf("+================= Result =================+\n ");
      Duration(Time);
      printf("\n Game Mode: %s\n", ModeType);
      printf("\n Total Attemps: %d / %d  ", Guesses, MaxGuesses);
      printf("\n\n You won the game\n");
      printf("+==========================================+\n\n");
      Player_score++;
      break;
    }

    else if (num < randNum && num > RMin)
    {
      RMin = num;
    }
    else if (num > randNum && num < RMax)
    {
      RMax = num;
    }

    Clear_Screen();
  }

  char Cont;
  printf("\nContinue Game(Y/N): ");
  scanf(" %c", &Cont);

  if (tolower(Cont) == 'y')
  {
    Clear_Screen();
    numberGuessingGame();
  }
}
char *Modes(int *Max, int *Min, int *Guesses, int Player_score)
{

  int choice;

  printf("+=========================================+\n");
  printf("|     Welcome To Number Guessing Game     |\n");
  printf("|=========================================|\n");
  printf("|                                         |\n");
  if (Player_score < 10)

    printf("| Player Score: 0%d                        |\n", Player_score);

  else if (Player_score >= 10)

    printf("| Player Score: %d                        |\n", Player_score);

  printf("|                                         |\n");
  printf("| Levels:                                 |\n");
  printf("|                                         |\n");
  printf("| 1. Easy     (1 to 100 : 16 Guesses)     |\n");
  printf("|                                         |\n");
  printf("| 2. Medium   (1 to 500 : 8 Guess)        |\n");
  printf("|                                         |\n");
  printf("| 3. Hard     (1 to 1000 : 6 Guesses)     |\n");
  printf("|                                         |\n");
  printf("| 4. Extreme  (1 to 100 : 2 Guesses)      |\n");
  printf("|                                         |\n");
  printf("| 5. Custom                               |\n");
  printf("|                                         |\n");
  printf("| 6. Float    (1.0 to 200.0 : 18 Guesses) |\n");
  printf("|                                         |\n");
  printf("| 7. 2 Player (Coming soon)               |\n");
  printf("+=========================================+\n\n");
  printf("Enter your choice: ");
  scanf("%d", &choice);

  Clear_Screen();

  if (choice == 1)
  {
    *Min = 1;
    *Max = 100;
    *Guesses = 16;
    return "Easy (1 to 100 : 16 Guesses)";
  }
  else if (choice == 2)
  {
    *Min = 1;
    *Max = 500;
    *Guesses = 8;
    return "Medium (1 to 500 : 8 Guesses)";
  }
  else if (choice == 3)
  {
    *Min = 1;
    *Max = 1000;
    *Guesses = 6;
    return "Hard (1 to 1000 : 6 Guesses)";
  }
  else if (choice == 4)
  {
    *Min = 1;
    *Max = 100;
    *Guesses = 2;
    return "Extreme (1 to 100 : 2 Guesses)";
  }
  else if (choice == 5)
  {
    printf("Enter Range and Max Guesses: ");
    scanf("%d, %d, %d", Min, Max, Guesses);
    return "Custom";
  }
  else if (choice == 6)
  {
    Float_Mode();
    return "Float (1.0 to 200.0 : 18 Guesses)";
  }

  else if (choice == 7)
  {

    sleep(1);
    printf("2 Player Mode is Coming Soon");
    exit(1);
  }
  else
  {
    exit(1);
  }
}

void Clear_Screen()
{
#if _WIN32
  system("cls");
#else
#endif
}

void Build_Game()
{
  Clear_Screen();
  int num = 0;

  for (int i = 0; i < 20; i++)
  {
    if (num <= 2)
    {
      num += 5;
      printf("System Builded 0%d %% Game", num);
    }
    else
    {
      num += 5;
      printf("System Builded %d %% Game", num);
    }

    sleep(1);
    Clear_Screen();
  }

  printf("System Builded Game ");
  sleep(2);
  Clear_Screen();

  printf("System Starting Game");
  sleep(2);
  Clear_Screen();
}

void Float_Mode()
{
#define MAXLIMIT 100
  int Guesses = 0, MaxGuesses = 18;
  float num, randNum;
  int INum, IRandNum;
  int Time;
  float RMax = 200.0, RMin = 1.0;

  char *ModeType = "Float (1.0 to 200.0 : 10 Guesses)";
  srand(time(0));

  randNum = ((float)rand() / RAND_MAX) * (200.0 - 1.0);
  IRandNum = round(randNum * MAXLIMIT);

  // Build_Game();
  time_t start, end;
  time(&start);

  while (true)
  {
    Clear_Screen();
    printf("+---------------------------------------+\n");
    printf(" Guesses: %d / %d\n", Guesses, MaxGuesses);
    printf(" Range: %.2f : %.2f\n", RMin, RMax);
    printf(" Mode: %s\n", ModeType);
    printf("+---------------------------------------+\n");

    if (Guesses == MaxGuesses)
    {
      time(&end);
      Clear_Screen();
      Time = difftime(end, start);
      printf("+====================Result===================+\n ");
      Duration(Time);
      printf("\n Game Mode: %s\n", ModeType);
      printf("\n You lose the game, The random number = %.2f\n", randNum);
      printf("+=============================================+\n\n");
      Player_score--;

      if (Player_score < 0)
      {
        Player_score = 0;
      }
      break;
    }

    printf("\nEnter your number: ");
    scanf("%f", &num);

    INum = round(num * 100);

    Guesses++;

    if (INum == IRandNum)
    {
      time(&end);
      Clear_Screen();
      Time = difftime(end, start);

      printf("+================= Result =================+\n ");
      Duration(Time);
      printf("\n Game Mode: %s\n", ModeType);
      printf("\n Total Attemps: %d / %d  ", Guesses, MaxGuesses);
      printf("\n\n You won the game\n");
      printf("+==========================================+\n\n");
      Player_score++;
      break;
    }

    else if (num < randNum && num > RMin)
    {
      RMin = num;
    }
    else if (num > randNum && num < RMax)
    {
      RMax = num;
    }
  }

  char Cont;
  printf("\nContinue Game(Y/N): ");
  scanf(" %c", &Cont);

  if (tolower(Cont) == 'y')
  {
    Clear_Screen();
    numberGuessingGame(Player_score);
  }
}
