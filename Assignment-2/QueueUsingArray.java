package assignment2;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QueueUsingArray
{
   private String [] queue;
   int N = 0;
   int head, tail;
   
   public QueueUsingArray(int size)
   {
      queue = new String[size];
      head = tail = 0;
      N = size;
   }
   
   public boolean isEmpty()
   {
      return tail == head;
   }
   
   public void enQueue(String item)
   {
      queue[tail++ % N] = item;
   }
   
   public String deQueue()
   {
      if (isEmpty()) throw new NoSuchElementException();
      
      String item = queue[head];
      queue[head++ % N] = null;
      return item;
   }
   
   public static void main(String[] args)
   {
      QueueUsingArray queue = new QueueUsingArray(7);
      while(!StdIn.isEmpty())
      {
         String s = StdIn.readString();
         if(s.equals("-"))
            StdOut.print(queue.deQueue());
         else
            queue.enQueue(s);
      }
   }
   
}















