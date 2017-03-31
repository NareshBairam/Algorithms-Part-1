package assignment2;

public class Insertion 
{
   public static void sort(Comparable a[])
   {
      int N = a.length;
      
      for (int i = 0; i < N; i++)
         for (int j = i; j > 0 ; j--)
            if (less(a[j], a[j - 1]))          
               swap(a, j, j - 1);
   }
   private static boolean less(Comparable p, Comparable q)
   {
      return p.compareTo(q) < 0;
   }
   
   private static void swap(Comparable a[], int i, int j)
   {
      Comparable temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
   
   public static void main(String[] args)
   {
      Integer[] a = new Integer[10];
      int j = 10;
      for (int i = 0; i < 10; i++)
      {
         a[i] = j;
         j--;
      }
      Insertion.sort(a);
      for (int i = 0; i < 10; i++)
         System.out.println(a[i]);
   }
}
