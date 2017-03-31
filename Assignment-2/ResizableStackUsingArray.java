package assignment2;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizableStackUsingArray<Item>
{
   private Item[] stack;
   private int N = 0;
   
   public ResizableStackUsingArray()
   {
      stack = (Item[])new Object[1];
   }
   
   
   public boolean isEmpty()
   {
      return N == 0;
   }

   private int size()
   {
      return stack.length;
   }
   
   public void push(Item item)
   {
      if (N == stack.length) resize(2*stack.length);
      stack[N++] = item;
   }
   
   private void resize(int n)
   {
      Item[] copy = (Item [])new Object[n];
      for (int i = 0; i < N; i++)
      {
         copy[i] = stack[i];
      }
      stack = copy;
   }
   
   public Item pop()
   {
      if (isEmpty()) throw new NoSuchElementException();
      Item item = stack[--N];
      stack[N] = null;
      
      if (N > 0 && N == stack.length/4) resize(stack.length/2);
      return item;
   }
   
   public static void main(String[] args)
   {
      ResizableStackUsingArray<String> stack = new ResizableStackUsingArray<String>();
      while(!StdIn.isEmpty())
      {
         String s = StdIn.readString();
         if(s.equals("-"))
            StdOut.print(stack.pop());
         else
            stack.push(s);
         StdOut.print("Size" + stack.size());
      }
   }


}
