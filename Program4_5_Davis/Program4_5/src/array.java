/**
 * Created by trip on 8/9/16.
 */
//David Davis 978105326 Program 4/5
//Array class to build 2-d array for Scrabble board

public class array {//Begin class

    private  char [][] board = new char[16][16];//Private member 2-d array
    private   char [] rowNumbers = new char[16];//Private member array for top locations

    public array()//Build board with class constructor
    {
        numberBoardX();//Build numberBoardx for the top column location
        fillFirstColumn();//Fill the first column for row locations
        fillBoard();//Fill rest of board
    }

   public void numberBoardX()
    {
        for(int i = 0; i < 16; ++i)//Set each column location to lower case letter
            rowNumbers[i] = (char) ( 96 + i);
    }

    public void fillFirstColumn()
    {
        for(int i = 1; i < 16; ++i)
        {
            board[i][0] = (char) (96 + i);//Set first column of array for row locations
        }
    }
    public void fillBoard()//Fill board with empty spaces as '-'
    {
        fillFirstColumn();
        for(int i = 1; i < 16; ++i)//Set from second column to last
        {
            for(int j = 1; j < 16; ++j)//Set from second row to last
            {
                if(i == 1 || i == 8 || i == 15) {//Set triple word special spaces
                    if (j == 1 || j == 8 || j == 15)//Set to corners and middle of sides
                    {
                        if (i == 8 && j == 8)//Set middle square to be starting square
                           board[i][j] = '#';
                        else
                           board[i][j] = '$';//Set special spaces to '$'
                    }
                    else
                        board[i][j] = '-';//Set all others to '-'

                }
                else
                    board[i][j] = '-';//Set all missed spaces to '-'
            }
        }
    }

    public void printBoard()//Show board
    {

        for (int i = 0; i < 16; ++i)//Print location markers
            System.out.print("  " + rowNumbers[i]);
        for(int i = 0; i < 16; ++i)
        {
            for(int j = 0; j < 16; ++j)
            {
                System.out.print("  " + board[i][j]);//Print board spaces
            }
            System.out.println();//Print to new line after each row printer
        }
    }

    public void printBoard(Player displayScore)//Display board and desired players score
    {
        for (int i = 0; i < 16; ++i)//Same as printBoard
            System.out.print("  " + rowNumbers[i]);
        for(int i = 0; i < 16; ++i)
        {
            for(int j = 0; j < 16; ++j)
            {
                System.out.print("  " + board[i][j]);
            }
            System.out.println();
        }

        int score = displayScore.returnScore();//Added player score Display
        System.out.println("\n\t\t" + displayScore.name() + "'s score is: " + score + "\n");
    }

    public int charToInt(char toConvert)//Convert char location to int location for array lookup
    {
        int location = 0;//Start with location 0

        if(toConvert == 'a')//Set to int based on letter
            location = 1;
        else if(toConvert == 'b')
            location = 2;
        else if(toConvert == 'c')
            location = 3;
        else if(toConvert == 'd')
            location = 4;
        else if(toConvert == 'e')
            location = 5;
        else if(toConvert == 'f')
            location = 6;
        else if(toConvert == 'g')
            location = 7;
        else if(toConvert == 'h')
            location = 8;
        else if(toConvert == 'i')
            location = 9;
        else if(toConvert == 'j')
            location = 10;
        else if(toConvert == 'k')
            location = 11;
        else if(toConvert == 'l')
            location = 12;
        else if(toConvert == 'm')
            location = 13;
        else if(toConvert == 'n')
            location = 14;
        else if(toConvert == 'o')
            location = 15;
        else
            System.out.println("\n\tPlease enter a valid location");//If not a good location print error

        return location;//Return int location
    }

    public boolean placeWord(char toPlay[], int x, int y, boolean down, Player user) //Place word on board
    {//Takes in word, x and y location, down or right flag, and player to display score as arguments

        int bonus = 0;//set bonus variable in case special space is used

        if (down)//If word is to be played downwards, down flag will be true
        {
            if (x + toPlay.length > 15) //Check if word will fit on board in desired location
            {//Print error if not fitting
                System.out.println("Word to long to play in this position. Please select new position.");
                return false;//Return from function as false
            }
            else
            {//Otherwise check for bonus space in placement
                for (int j = 0; j < toPlay.length; ++j) {
                    if (board[x + j][y] == '$')
                        ++bonus;//Increase bonus variable in case multiple special spaces covered
                }
                if(bonus > 0)//If bonus is played
                        user.addToScore(toPlay, 3*bonus);//Triple the score for word added to total
                else
                        user.addToScore(toPlay);//Regular score is added to total

                for (int i = 0; i < toPlay.length; i++)//Place word on board
                    board[x + i][y] = toPlay[i];
            }
        } else {//If word is to be played to the right. Same functions just with y location looped
            if (y + toPlay.length > 15) {
                System.out.println("Word to long to play in this position. Please select new position.");
                return false;
            } else {
                for (int j = 0; j < toPlay.length; ++j) {
                    if (board[x][y + j] == '$')
                        ++bonus;
                }
                if(bonus > 0)
                        user.addToScore(toPlay, 3*bonus);
                else
                        user.addToScore(toPlay);

                for(int i = 0; i < toPlay.length; i++)
                    board[x][y + i] = toPlay[i];
            }
        }

        return true;
    }
}
