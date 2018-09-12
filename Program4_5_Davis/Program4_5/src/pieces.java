/**
 * Created by trip on 8/11/16.
 */
//David Davis 978105326 Program 4/5
//Pieces class for the individual tiles of a Scrabble game

import java.util.Random;//Import random utility to use for tile picking


public class pieces {//Begin pieces class

    Random rand = new Random();//Make instance of random utility
    private char [] total_tiles = new char [98];//Array to hold all tiles
    private int number = 0;//Number to store array location

    public pieces()//Constructor to initialize array with all tiles
    {
        allocate_tiles();//Call to allocation function
    }

    public char pick_tile()//Function to pick random tile and return a char to represent that tile
    {
        char pick;//Char to store tile picked
        int random = (Math.abs(rand.nextInt()));//Random number to be used for pick
        number = random % 98;//Make random number between 0-97
        pick = total_tiles[number];//Find tile from array

        total_tiles[number] = '@';//Set that array location so the tile can not be pulled again

        while(pick == '@')//If tile is pulled twice, pick again
        {
            random = (Math.abs(rand.nextInt()));
            number = random % 98;
            pick = total_tiles[number];
        }
        return pick;//Return tile picked
        
    }

    private void allocate_tiles() {//Allocate all tiles to be used in game
         int i = 0;//Int to be used for all loops
        for(i = 0; i < 9; ++i)//Each loop sets the correct amount of each tile letter
            total_tiles[i] = 'A';
         for(i = 9; i < 11; ++i)
            total_tiles[i] = 'B';
         for(i = 11; i < 13; ++i)
            total_tiles[i] = 'C';
         for(i = 13; i < 17; ++i)
            total_tiles[i] = 'D';
         for(i = 17; i < 29; ++i)
            total_tiles[i] = 'E';
         for(i = 29; i < 31; ++i)
            total_tiles[i] = 'F';
         for(i = 31; i < 34; ++i)
            total_tiles[i] = 'G';
         for(i = 34; i < 36; ++i)
            total_tiles[i] = 'H';
         for(i = 36; i < 45; ++i)
            total_tiles[i] = 'I';
            total_tiles[45] = 'J';
            total_tiles[46] = 'K';
         for(i = 47; i < 51; ++i)
            total_tiles[i] = 'L';
         for(i = 51; i < 53; ++i)
            total_tiles[i] = 'M';
         for(i = 53; i < 59; ++i)
            total_tiles[i] = 'N';
        for(i = 59; i < 67; ++i)
            total_tiles[i] = 'O';
        for(i = 67; i < 69; ++i)
            total_tiles[i] = 'P';
            total_tiles[69] = 'Q';
        for(i = 70; i < 76; ++i)
            total_tiles[i] = 'R';
        for(i = 76; i < 80; ++i)
            total_tiles[i] = 'S';
        for(i = 80; i < 86; ++i)
            total_tiles[i] = 'T';
        for(i = 86; i < 90; ++i)
            total_tiles[i] = 'U';
        for(i = 90; i < 92; ++i)
            total_tiles[i] = 'V';
        for(i = 92; i < 94; ++i)
            total_tiles[i] = 'W';
            total_tiles[94] = 'X';
        for(i = 95; i < 97; ++i)
            total_tiles[i] = 'Y';
            total_tiles[97] = 'Z';
    }
}
