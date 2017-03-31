package assignment2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QueueUsingLinkedList<Item>
{
   Node first, last;
   private class Node
   {
      Item item;
      Node next;
   }
   
   public boolean isEmpty()
   {
      return first == null;
   }
   
   public void enQueue(Item item)
   {
      Node oldLast = last;
      last = new Node();
      last.item = item;
      last.next = null;
      if(isEmpty()) first = last;
      else oldLast.next = last;
   }
   
   public Item deQueue()
   {
      Item item = first.item;
      first = first.next;
      if (isEmpty()) last = first;
      return item;
   }
   public static void main(String[] args)
   {
      QueueUsingLinkedList<String> queue = new QueueUsingLinkedList<String>();
      while(!StdIn.isEmpty())
      {
         String s = StdIn.readString();
         if(s.equals("-"))
            StdOut.print(queue.deQueue());
         else
            queue.enQueue(s);;
      }
   }
   
}
