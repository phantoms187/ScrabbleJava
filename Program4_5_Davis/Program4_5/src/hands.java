/**
 * Created by trip on 8/9/16.
 */
//David Davis 978105326 Program 4/5
//Hands class derived from pieces class to be used to store a players tiles

public class hands extends pieces{//Begin hands class

    private circularList playerHand = new circularList();//Make instance of CLL for hand

    public hands()//Constructor to set hand with new hand is created
    {
        setHand();//Method to fill hand with 7 tiles
    }

    public void setHand(){//Method to set hand with 7 tiles

        for(int i = 0; i < 7; ++i)//Loop to add 7 tiles
        {
            playerHand.insert(super.pick_tile());//Using super to call pick_tile()
        }
    }

     public void showHand()//Method to call CLL display function for hand
     {
             playerHand.display();//Method call to CLL display
     }

     public void removeTile(char toRemove)//Method call to CLL for removing a tile
     {
             playerHand.removeTile(toRemove);//Remove desired tile
     }

     public void fillPlayerHand()//Method to fill hand after playing word and using tiles
     {
         playerHand.fillHand();
     }

}
