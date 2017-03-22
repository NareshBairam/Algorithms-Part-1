// package assignment1;


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats 
{   
   private double[] stats;
   private int trails;

   public PercolationStats(int n, int t)
   {
      trails = t;
      stats = new double[trails];	

      if (n <= 0 || t <= 0)
         throw new IllegalArgumentException("Please supply proper Integer arguments such that n > 0 &&  t > 0");

      for (int temp = 0; temp < trails; temp++) 
      {
         int numOfOpenSites = 0;
         Percolation p = new Percolation(n);
         while (!p.percolates())
         {
            int i = StdRandom.uniform(1, n + 1);
            int j = StdRandom.uniform(1, n + 1);
            if (!p.isOpen(i, j) && !p.isFull(i, j))
            {
               p.open(i, j);
               numOfOpenSites += 1;
            }
         }
         stats[temp] = (double) numOfOpenSites/(n*n);
      }

   }

   public double mean()
   {
      return StdStats.mean(stats);
   }

   public double stddev()
   {		
      return StdStats.stddev(stats);
   }

   public double confidenceLo()  
   {
      return mean() - ((1.96 * stddev()) / Math.sqrt(trails));
   }

   public double confidenceHi()
   {
      return mean() + ((1.96 * stddev()) / Math.sqrt(trails));
   }


   public static void main(String[] args)        // test client (described below)
   {
      int n, t;
      n = Integer.parseInt(args[0]);
      t = Integer.parseInt(args[1]);

      PercolationStats ps = new PercolationStats(n, t);

      System.out.println("mean                    = " + ps.mean());	
      System.out.println("stddev                  = " + ps.stddev());
      System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");

   }
}