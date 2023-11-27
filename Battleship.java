/*

Following program creates a playable battleship game in which players have to sink their opponent's ship.
Players are also given a board which tracks their move and is continously updated.
The player that is first to sink all of opponent's ships wins.

*/


import java.util.*;

public class Battleship
{
    public static void main(String[] args)
    {
        //Create Scanner object
        Scanner sc = new Scanner(System.in); 

        //Greet players
        System.out.println("\nWelcome to Battleship!\n");


        //Initialize 2D Arrays
        char[][] Player1Coordinates = new char[6][6];
        char[][] Player2Coordinates = new char[6][6];
        char[][] Player1Target = new char[6][6];
        char[][] Player2Target = new char[6][6];



        //Fill Arrays with Default
        Player1Coordinates = fillArray(Player1Coordinates);
        Player2Coordinates = fillArray(Player2Coordinates);
        Player1Target = fillArray(Player1Target);
        Player2Target = fillArray(Player2Target);





        //Get Ship Coordinates from Players
        System.out.println("PLAYER 1 ENTER SHIP COORDINATES(x y)/(row column)");
        for(int i = 0; i < 5; i++)
        {
            System.out.print("Enter coordinates for ship " + (i+1) + ": ");
            int row = sc.nextInt();
            int column = sc.nextInt();
            if(row < 1)
            {
                while(row < 1)
                {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.print("Enter coordinates for ship " + (i+1) + ": ");
                    row = sc.nextInt();
                }
            }
            else if(row > 5)
            {
                while(row > 5)
                {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.print("Enter coordinates for ship " + (i+1) + ": ");
                    row = sc.nextInt();
                }
            }
            else if(column < 1)
            {
                while(column < 1)
                {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.print("Enter coordinates for ship " + (i+1) + ": ");
                    column = sc.nextInt();
                }
            }
            else if(column > 5)
            {
                while(column > 5)
                {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.print("Enter coordinates for ship " + (i+1) + ": ");
                    column = sc.nextInt();
                }
            }
            if(Player1Coordinates[row][column] == '@')
            {
                while(Player1Coordinates[row][column] == '@')
                {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                    System.out.print("Enter coordinates for ship " + (i+1) + ": ");
                    row = sc.nextInt();
                    column = sc.nextInt();
                }
            }
            Player1Coordinates[row][column] = '@';
        }







        //Get Ship Coordinates from Player
        System.out.println("\n\nPLAYER 2 ENTER SHIP COORDINATES(x y)/(row column)");
        for(int i = 0; i < 5; i++)
        {
            System.out.print("Enter coordinates for ship " + (i+1) + ": ");
            int row = sc.nextInt();
            int column = sc.nextInt();
            if(row < 1)
            {
                while(row < 1)
                {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.print("Enter coordinates for ship " + (i+1) + ": ");
                    row = sc.nextInt();
                }
            }
            else if(row > 5)
            {
                while(row > 5)
                {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.print("Enter coordinates for ship " + (i+1) + ": ");
                    row = sc.nextInt();
                }
            }
            else if(column < 1)
            {
                while(column < 1)
                {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.print("Enter coordinates for ship " + (i+1) + ": ");
                    column = sc.nextInt();
                }
            }
            else if(column > 5)
            {
                while(column > 5)
                {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.print("Enter coordinates for ship " + (i+1) + ": ");
                    column = sc.nextInt();
                }
            }
            else if(Player2Coordinates[row][column] == '@')
            {
                while(Player2Coordinates[row][column] == '@')
                {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                    System.out.print("Enter coordinates for ship " + (i+1) + ": ");
                    row = sc.nextInt();
                    column = sc.nextInt();
                }
            }
            Player2Coordinates[row][column] = '@';
        }



        //Print out battleship boards
        System.out.println("\n");

        printBattleShip(Player1Coordinates);

        for(int i = 0; i < 100; i++)
        {
            System.out.println();
        }

        printBattleShip(Player2Coordinates);

        System.out.println("\n");

        for(int i = 0; i < 100; i++)
        {
            System.out.println();
        }

        //Following loop continues game and checks after every move if a player has sunk all ships of the opponent
        do
        {

            //Get hits from Player 1
            int row, column;
            System.out.print("Player 1, enter hit(x y)/(row column): ");
            row = sc.nextInt();
            column = sc.nextInt();

            //Following conditionals check to see if move is valid
            if(row < 1)
            {
                    while(row < 1)
                    {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        System.out.print("Player 1, enter hit(x y)/(row column): ");
                        row = sc.nextInt();
                    }
            }
            else if(row > 5)
            {
                    while(row > 5)
                    {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        System.out.print("Player 1, enter hit(x y)/(row column): ");
                        row = sc.nextInt();
                    }
            }
            else if(column < 1)
            {
                    while(column < 1)
                    {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        System.out.print("Player 1, enter hit(x y)/(row column): ");
                        column = sc.nextInt();
                    }
            }
            else if(column > 5)
            {
                    while(column > 5)
                    {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        System.out.print("Player 1, enter hit(x y)/(row column): ");
                        column = sc.nextInt();
                    }
            }
            else if(Player1Target[row][column] == 'X' || Player1Target[row][column] == 'O')
            {
                    while(Player1Target[row][column] == 'X' || Player1Target[row][column] == 'O')
                    {
                        System.out.println("You already fired on this spot. Choose different coordinates.");
                        System.out.print("Player 1, enter hit(x y)/(row column): ");
                        row = sc.nextInt();
                        column = sc.nextInt();
                    }
            }

            //Checks to see if player has sunk opponent's ship
            if(Player2Coordinates[row][column] == '@')
            {
                Player2Coordinates[row][column] = 'X';
                Player1Target[row][column] = 'X';
                System.out.println("Player 1 hit Player 2's ship!");
                printBattleShip(Player1Target);
            }
            else
            {
                Player1Target[row][column] = 'O';
                System.out.println("Player 1 Missed!");
                printBattleShip(Player1Target);
            }

            //Checks to see if player sunk all of opponent's ships
            if(isVictory(Player2Coordinates) == true)
            {
                System.out.println("Player 1 wins! Player 1 sunk all of Player 2's ships!");
                printBattleShip(Player1Target);
                System.out.println("\n");
                printBattleShip(Player2Target);
                break;
            }




            //Get hits from Player 2
            System.out.print("Player 2, enter hit(x y)/(row column): ");
            row = sc.nextInt();
            column = sc.nextInt();

            //Following conditionals check to see if move is valid
            if(row < 1)
            {
                    while(row < 1)
                    {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        System.out.print("Player 2, enter hit(x y)/(row column): ");
                        row = sc.nextInt();
                    }
            }
            else if(row > 5)
            {
                    while(row > 5)
                    {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        System.out.print("Player 2, enter hit(x y)/(row column): ");
                        row = sc.nextInt();
                    }
            }
            else if(column < 1)
            {
                    while(column < 1)
                    {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        System.out.print("Player 2, enter hit(x y)/(row column): ");
                        column = sc.nextInt();
                    }
            }
            else if(column > 5)
            {
                    while(column > 5)
                    {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        System.out.print("Player 2, enter hit(x y)/(row column): ");
                        column = sc.nextInt();
                    }
            }
            else if(Player2Target[row][column] == 'X' || Player2Target[row][column] == 'O')
            {
                    while(Player2Target[row][column] == 'X' || Player2Target[row][column] == 'O')
                    {
                        System.out.println("You already fired on this spot. Choose different coordinates.");
                        System.out.print("Player 2, enter hit(x y)/(row column): ");
                        row = sc.nextInt();
                        column = sc.nextInt();
                    }
            }
            
            //Checks to see if player has sunk opponent's ship
            if(Player1Coordinates[row][column] == '@')
            {
                Player1Coordinates[row][column] = 'X';
                Player2Target[row][column] = 'X';
                System.out.println("Player 2 hit Player 1's ship!");
                printBattleShip(Player2Target);
            }
            else
            {
                Player2Target[row][column] = 'O';
                System.out.println("Player 2 Missed!");
                printBattleShip(Player2Target);
            }


            //Checks to see if player has sunk all of opponent's ship
            if(isVictory(Player1Coordinates) == true)
            {
                System.out.println("Player 2 wins! Player 2 sunk all of Player 1's ships!");
                printBattleShip(Player1Target);
                System.out.println("\n");
                printBattleShip(Player2Target);
                break;
            }

            
        }while(true);








    }

    //Method fills given array with default empty space
    public static char[][] fillArray(char[][] playerArray)
    {
        for(int i = 1; i <= 5; i++)
        {
            for(int j = 1; j <= 5; j++)
            {
                playerArray[i][j] = '-';
            }
        }
        return playerArray;
    }

    //Method prints out beginning board based on player inputs
    public static void printBattleShip(char[][] PlayerBoard)
    {
        System.out.println("  1 2 3 4 5");
        for(int i = 1; i <= 5; i++)
        {
            System.out.print(i + " ");
            for(int j = 1; j <= 5; j++)
            {
                System.out.print(PlayerBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Method checks to see if any ships are remaining on a player's board
    public static boolean isVictory(char[][] PlayerBoard)
    {
        for (int i = 1; i <= 5; i++)
        {
            for (int j = 1; j <= 5; j++)
            {
                if (PlayerBoard[i][j] == '@')
                {
                    return false;
                }
            }
        }
        return true;
    }


}