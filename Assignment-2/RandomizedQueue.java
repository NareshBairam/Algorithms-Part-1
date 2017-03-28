// package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> 
{
   private int size;
   private Item[] randomizedQueue;
   
   public RandomizedQueue()    
   {
      size = 0;
      randomizedQueue = (Item[]) new Object[1];
   }
   
   public Iterator<Item> iterator()  
   {
      return new RandomizedQueueIterator();
   }
   
   private class RandomizedQueueIterator implements Iterator<Item> 
   {
    
      private int s = size;
      private int[] order;
      
      public RandomizedQueueIterator()
      {
         order = new int[s];
         for (int i = 0; i < s; i++)
         {
            order[i] = i;
         }
         StdRandom.shuffle(order);
      }
            
      @Override
      public boolean hasNext()
      {
         return s > 0;
      }

      @Override
      public Item next()
      {
         if (!hasNext()) throw new java.util.NoSuchElementException();
         return randomizedQueue[order[--s]];
      }
      public void remove()
      {
         throw new java.lang.UnsupportedOperationException();
      }
      
   }
   
   public boolean isEmpty()  
   {
      return size == 0;
   }
   public int size()   
   {
      return size;
   }
   public void enqueue(Item item)    
   {
      if (item == null) throw new NullPointerException();
      randomizedQueue[size++] = item;
      if (size == randomizedQueue.length) 
      {
         resize(2*randomizedQueue.length);
      }
   }
   
   
   
   private void resize(int s)
   {
      Item[] copy = (Item[]) new Object[s];
      for (int i = 0; i < size; i++)
      {
         copy[i] = randomizedQueue[i];
      }
      randomizedQueue = copy;
    
   }

   public Item dequeue()    
   {
      if (size == 0) throw new NoSuchElementException();
      int randomNumber = StdRandom.uniform(size);
      Item item = randomizedQueue[randomNumber];
      randomizedQueue[randomNumber] = randomizedQueue[size -1];
      randomizedQueue[--size] = null;
      
      if (size > 0 && size == randomizedQueue.length/4)
      {
         resize(randomizedQueue.length/2);
      }
      return item;
   }
   public Item sample() 
   {
      if (size == 0) throw new NoSuchElementException();
      int randomNumber = StdRandom.uniform(size);
      return randomizedQueue[randomNumber];
   }
         
   public static void main(String[] args)  
   {
      
   }
}
