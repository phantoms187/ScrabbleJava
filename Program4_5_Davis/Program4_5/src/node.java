/**
 * Created by trip on 8/11/16.
 */
//David Davis 978105326 Program 4/5
//Node class to make individual nodes in CLL

public class node extends pieces{//Begin node class extended from pieces to use pieces methods

    private  char tile;//Node has a char to represent a tile
    private node next;//Next point to traverse to next node in list

    public node()//Constructor
    {
        tile = '-';//Initialize to black space
        next = null;//Next to null
    }
    public node(char letter)//Constructor with argument to set tile value at creation
    {
        tile = letter;//Set to desired pick
        next = null;//Next still null
    }

    public node nextNode()//Method to get next node
    {
        return this.next;//Return the next of this node
    }

    public void setNextNode(node toSet)//Method to set next of node
    {
        this.next = toSet;//Set next of this node
    }

    public void displayTile()//Display the tile for displaying player hand
    {
        System.out.print(tile + " ");//Display tile char and space
    }

    public void removeTile(char to_remove)//Method to remove a tile and replace with marker
    {
        if(to_remove == tile)//If desired tile is present
            tile = '%';//Replace with marker
    }

    public void replaceTile()//Set marked tiles to new value
    {
        if('%' == tile)//If marker found pick new tile
            tile = super.pick_tile();
    }

}
