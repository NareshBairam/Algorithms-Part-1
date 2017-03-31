package assignment2;

public class Shellsort
{
   public static void sort(Comparable a[])
   {
      int N = a.length;
      
      int h = 1;
      
      while(h < N/3) h = 3*h + 1;
      
      while(h >= 1)
      {
         for (int i = h; i < N; i++)
            for (int j = i; j >= h; j -= h)
               if (less(a[j], a[j - h]))          
                  swap(a, j, j - h);
      }
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
      Shellsort.sort(a);
      for (int i = 0; i < 10; i++)
         System.out.println(a[i]);
   }
}
