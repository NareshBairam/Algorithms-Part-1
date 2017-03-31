package assignment2;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackUsingArray<Item>
{
   private String[] stack;
   private int N = 0;
   
   public StackUsingArray(int size)
   {
      stack = new String[size];
   }
   
   public boolean isEmpty()
   {
      return N == 0;
   }
   
   public void push(String item)
   {
      stack[N++] = item;
   }
   
   public String pop()
   {
      if (isEmpty()) throw new NoSuchElementException();
      String item = stack[--N];
      stack[N] = null;
      return item;
   }
   public static void main(String[] args)
   {
      StackUsingArray stack = new StackUsingArray(7);
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
