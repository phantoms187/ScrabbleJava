/**
 * Created by trip on 8/11/16.
 */
//David Davis 978105326 Program 4/5
//Circular Linked List class to hold hand tiles

public class circularList extends node {//Begin class

   private node head;//Private head of list
   private node tail;//Private tail of list

    public circularList()//Constructor to set head and tail to null
    {
        head = null;
        tail = null;
    }

    public void insert(char letter) //Insert Method for adding a tile to the hand
    {
        node newNode = new node(letter);//Start with new node

        if (head == null) {//If hand is empty add new node
            tail = newNode;
            head = newNode;
            tail.setNextNode(head);//Set next of tail to point back to head
        }
        else
        {//Else add after tail and move tail to end
            tail.setNextNode(newNode);
            newNode.setNextNode(head);
            tail = newNode;
        }
    }

    public void display()//Display method to show hand
    {
        if(head == null)//If no list to display return
            return;
        else
        {
            node current = head;//Use current so head is not altered
            tail.setNextNode(null);//Break CLL into LLL
            System.out.printf("\t\t");//Print indention
           recursiveDisplay(current);//Recursive call to display all tiles in hand
           tail.setNextNode(head);//Reconnect tail to head
        }
    }

    public void recursiveDisplay(node root)//Recursive display call to print all tiles in hand
    {
        if(root == null)//If no list return
            return;

        root.displayTile();//Call node display for tile char

        recursiveDisplay(root.nextNode());//Recursive call until all tiles displayed
    }

    public void removeTile(char toRemove)//Remove tile from hand
    {
        if(head == null)//If no list return
            return;

        else
        {
            node current = head;//Use current to keep head unaltered
            tail.setNextNode(null);//Break CLL into LLL
            recursiveRemoveTile(current, toRemove);//Call to recursive function
            tail.setNextNode(head);//Reconnect CLL
        }
    }

    public void recursiveRemoveTile( node root, char toRemove)//Recursive call to remove tile
    {
        if(root == null)//If no list return
            return;

        root.removeTile(toRemove);//Remove tile and replace with marker from node method
        recursiveRemoveTile(root.nextNode(), toRemove);//Recursive call
    }

    public void fillHand()//Fill hand to replace markers
    {
        if(head == null)//No list return
            return;

        else
        {
            node current = head;//Use current
            tail.setNextNode(null);//Break CLL
            recursiveFillHand(current);//Recursive method
            tail.setNextNode(head);//Reconnect
        }
    }

    public void recursiveFillHand(node root)//Recursive method
    {
        if(root == null)//No list return
            return;

        root.replaceTile();//Node replace tile function
        recursiveFillHand(root.nextNode());//Recursive call
    }
}
