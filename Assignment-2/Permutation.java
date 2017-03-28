// package assignment2;

import edu.princeton.cs.algs4.StdIn;

public class Permutation
{
   public static void main(String[] args)
   {
      RandomizedQueue<String> strings = new RandomizedQueue<String>();
      
      while (!StdIn.isEmpty())
      {
         strings.enqueue(StdIn.readString());
      }
      
      int k = Integer.parseInt(args[0]);
      for (int i = 0; i < k; i++)
      {
         System.out.println(strings.dequeue());
      }
   }
}
