package assignment2;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QueueUsingResizableArray<Item>
{
   private Item [] queue;
   int N = 0;
   int head, tail;
   
   public QueueUsingResizableArray()
   {
      queue = (Item[]) new Object[1];
      head = tail = 0;
   }
    
   public boolean isEmpty()
   {
      return tail == head;
   }
   
   public int size()
   {
      return queue.length;
   }
   
   public void enQueue(Item item)
   {
      if(N == queue.length) resize(2*queue.length);
      queue[tail++ % queue.length] = item;
      N++;
   }
   
   private void resize(int n)
   {
      Item[] copy = (Item[]) new Object[n];
      int i = 0;
      while(head != tail)
      {
         copy[i] = queue[head];
         head++;
         i++;
      }
      queue = copy;
      head = 0;
      tail = i;
   }
   
   
   public Item deQueue()
   {
      if (isEmpty()) throw new NoSuchElementException();
      
      Item item = queue[head];
      queue[head++ % queue.length] = null;
      N--;
      if(N > 0 && N == queue.length/4) resize(queue.length/2);
      return item;
   }
   
   public static void main(String[] args)
   {
      QueueUsingResizableArray<String> queue = new QueueUsingResizableArray<String>();
      while(!StdIn.isEmpty())
      {
         String s = StdIn.readString();
         if(s.equals("-"))
            StdOut.print(queue.deQueue());
         else
            queue.enQueue(s);
         StdOut.print("Size" + queue.size());
      }
   }
   
}















