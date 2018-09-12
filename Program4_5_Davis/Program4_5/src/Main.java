//David Davis 978105326 Program 4/5 Scrabble Board Game
//This Program is designed to be like our first and second program Scrabble game
//The game plays well but needs development with the board accepting valid words and a check
//to see if the chars are in a player's hand. For noe the game has trust the players will
//play fairly.

//Import Scanner utility to get user input
import java.util.Scanner;

public class Main {//Begin main function

    public static void main(String[] args) {//Begin static main function

        implementingClass test = new implementingClass();//Call to derived class of abstract class.
        // I didn't use it as part of the game but did include it in the program to show dynamic binding.
        test.printToProve();//Function call derived class

        Scanner getUser = new Scanner(System.in);//Make instance of Scanner input variable
        System.out.println("\n\t\tWelcome to a game of Scrabble!");//Greet players
        System.out.println("\n\t\tThis will be a two player game.");

        System.out.printf("\n\tPlease enter the first player's name: ");//Get name for first player
        Player firstPlayer = new Player();//Create instance of first player
        hands firstPlayerHand = new hands();//Create first player hand
        firstPlayer.setName(getUser.next());//Set name from user to first player name

        System.out.printf("\n\tPlease enter the second player's name: ");//Get name for second player
        Player secondPlayer = new Player();//Make new player
        hands secondPlayerHand = new hands();//Make new hand for second player
        secondPlayer.setName(getUser.next());//Set name from user for second player

        System.out.println();//Print new line
        array gameBoard = new array();//Create board from array instance
        gameBoard.printBoard();//Print first blank board

        System.out.println("\n\tThis will be a quick game, each player only gets 10 turns.");//Explain 10 turns structure
        System.out.println("\tThe Player with the most points after 10 turns wins!");

        for(int i = 0; i < 10; ++i)//Loop for 10 turns
        {
            System.out.println("\nIt is " + firstPlayer.name() + "'s turn. Your hand is: ");//Show first player hand
            firstPlayerHand.showHand();//Function to show hand
            System.out.println("\nWhich word would you like to play: ");//Get word to play from user
            String word = getUser.next();//Get word
            char[] wordToPlay = word.toCharArray();//Make word an array to use
            for(int j = 0; j < wordToPlay.length; ++j)//Loop to take tiles out of hand
             firstPlayerHand.removeTile(wordToPlay[j]);//Remove tiles
            firstPlayerHand.fillPlayerHand();//Fill hand for missing tiles

            char repeatLocation;//Repeat variable if word placement won't fit
            do {
                repeatLocation = 'n';//Set repeat to no each time through
                System.out.println("\nWhich space will you place the first letter, row location: ");//Get row location
                String xString = getUser.next();//Get string from user
                xString = xString.toLowerCase();//Set string to all lower case
                char[] xArray = xString.toCharArray();//Make String into an array
                char x = xArray[0];//Set location to single char
                System.out.println("\nColumn location: ");//Get column location
                String yString = getUser.next();//Get String from user
                yString = yString.toLowerCase();//Make string into lower case
                char[] yArray = yString.toCharArray();//Convert to array
                char y = yArray[0];//Set column location to single char
                int xNum = gameBoard.charToInt(x);//Convert char space to int location
                int yNum = gameBoard.charToInt(y);//Convert to int location
                System.out.println("\nWill the word play down or to the right?: ");//Play is either to the right or down
                String downString = getUser.next();//Get user decision
                downString = downString.toLowerCase();//Set string to lower case
                char[] downArray = downString.toCharArray();//Set to single char
                if (downArray[0] == 'd') {//If word is to be played down
                    if (!gameBoard.placeWord(wordToPlay, xNum, yNum, true, firstPlayer))//Place word with down flag true
                        repeatLocation = 'y';//Set repeat if placeWord is unable to preform
                } else {
                    if (!gameBoard.placeWord(wordToPlay, xNum, yNum, false, firstPlayer))//Place word down flag false
                    {
                        repeatLocation = 'y';//Set repeat if word can not be placed
                    }
                }
            } while (repeatLocation == 'y');//Repeat location portion until word can be placed

            gameBoard.printBoard(firstPlayer);//Show board with word placed and first player score;

            //Repeat same sequence for second player
            System.out.println("\nIt is " + secondPlayer.name() + "'s turn. Your hand is: ");//Second player turn
            secondPlayerHand.showHand();
            System.out.println("\nWhich word would you like to play: ");
            String word2 = getUser.next();
            char[] wordToPlay2 = word2.toCharArray();
            for(int j = 0; j < wordToPlay2.length; ++j)
             secondPlayerHand.removeTile(wordToPlay2[j]);
            secondPlayerHand.fillPlayerHand();

            char repeatLocation2;
            do {
                repeatLocation2 = 'n';
                System.out.println("\nWhich space will you place the first letter, row location: ");
                String xString2 = getUser.next();
                xString2 = xString2.toLowerCase();
                char[] xArray2 = xString2.toCharArray();
                char x2 = xArray2[0];
                System.out.println("\ncolumn location: ");
                String yString2 = getUser.next();
                yString2 = yString2.toLowerCase();
                char[] yArray2 = yString2.toCharArray();
                char y2 = yArray2[0];
                int xNum2 = gameBoard.charToInt(x2);
                int yNum2 = gameBoard.charToInt(y2);
                System.out.println("\nWill the word play down or to the right?: ");
                String downString2 = getUser.next();
                downString2 = downString2.toLowerCase();
                char[] downArray2 = downString2.toCharArray();
                if (downArray2[0] == 'd') {
                    if (!gameBoard.placeWord(wordToPlay2, xNum2, yNum2, true, secondPlayer))
                        repeatLocation2 = 'y';
                } else {
                    if (!gameBoard.placeWord(wordToPlay2, xNum2, yNum2, false, secondPlayer))
                        repeatLocation2 = 'y';
                }
            } while (repeatLocation2 == 'y');

            gameBoard.printBoard(secondPlayer);
        }

        System.out.println("\tAfter 10 rounds let's check the scores!");//After 10 turns check score
        System.out.println("\t" + firstPlayer.name() + "'s score is: " + firstPlayer.returnScore());//Show first player
        System.out.println("\t" + secondPlayer.name() + "'s score is: " + secondPlayer.returnScore());//Show second

        if(firstPlayer.returnScore() > secondPlayer.returnScore())//Check for game winner
            System.out.println("\t" + firstPlayer.name() + " Wins the Game!");//Print if first player wins
        else if(firstPlayer.returnScore() < secondPlayer.returnScore())
            System.out.println("\t" + secondPlayer.name() + " Wins the Game!");//Print if second player wins
        else
            System.out.println("\tIt appears we have a draw...\n\n");//Print for Draw

//Game over.
}}
