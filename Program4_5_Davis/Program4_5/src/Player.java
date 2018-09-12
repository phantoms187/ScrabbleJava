/**
 * Created by trip on 8/9/16.
 */
//David Davis 978105326 Program 4/5
//Player class to keep name and score of each player

public class Player extends hands {//Player class is an extension of the hands class

    private int score = 0;//int for score and initialized to 0;
    private String name;//String for player name


    public void setName(String toAdd)//Method to set name of player
    {
        name = toAdd;
    }

    public String name()//Method to return name of player
    {
        return name;
    }

    public int returnScore()//Method to return score for player
    {
        return score;
    }

    public int tileValue(char toValue)//Determine point value of desired char
    {
        int value = 0;//Value initialized to 0

        char [] singles = {'A', 'E', 'I', 'L', 'N', 'O', 'R', 'S', 'T', 'U'};//Group chars of same point value
        char [] triples = {'B', 'C', 'M', 'P'};
        char [] quads = {'F', 'H', 'V', 'W', 'Y'};

        if(toValue == 'D' || toValue == 'G')//Set each set to required value
            value = 2;
        else if(toValue == 'K')
            value = 5;
        else if(toValue == 'J' || toValue == 'X')
            value = 8;
        else if(toValue == 'Q' || toValue == 'Z')
            value = 10;

        else
            for(int i = 0; i < 10; ++i)//Loop to set larger char groups
            {
                if(toValue == singles[i])
                    value = 1;
            }
            for(int i = 0; i < 4; ++i)
            {
                if(toValue == triples[i])
                    value = 3;
            }
            for(int i = 0; i < 5; ++i)
            {
                if(toValue == quads[i])
                    value = 4;
            }

            return value;//Return point value of tile
    }
    public int calcScore(char wordPlayed[])//Method to calculate total word score
    {
        int wordScore = 0;//Word score initialized to 0

        for(int i = 0; i < wordPlayed.length; ++i )//Loop to each letter in word
        {
            wordScore += tileValue(wordPlayed[i]);//Add each letter point value to total
        }
        return wordScore;//Return total
    }

    public void addToScore( char wordPlayed[])//Method to add word score to player total
    {
        score += calcScore(wordPlayed);
    }

    public void addToScore( char wordPlayed[], int special)//Method to add word score * special space value
    {
        score += (calcScore(wordPlayed) * special);
    }
}
