package assignment2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackUsingLinkedList<Item>
{
   
   private class Node
   {
      Item item;
      Node next;
   }
   
   Node first = null;
   
   public boolean isEmpty()
   {
      return first == null;
   }
   
   public void push(Item item)
   {
      Node oldFirst = first;
      first = new Node();
      first.item = item;
      first.next = oldFirst;
   }

   public Item pop()
   {
      Item item = first.item;
      first = first.next;
      return item;
   }
   public static void main(String[] args)
   {
      StackUsingLinkedList<String> stack = new StackUsingLinkedList<String>();
      while(!StdIn.isEmpty())
      {
         String s = StdIn.readString();
         if(s.equals("-"))
            StdOut.print(stack.pop());
         else
            stack.push(s);
      }
   }
}
