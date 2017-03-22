// package assignment1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
   private boolean[][] openedSites;
   private int topSite;
   private int bottomSite;
   private int gridLength;
   private WeightedQuickUnionUF wQF1;
   private WeightedQuickUnionUF wQF2;
   private int openedSitesNo;

   public Percolation(int n)
   {
      if (n <= 0)
      {
         throw new IllegalArgumentException("Please supply proper Integer arguments such that n > 0");
      }

      openedSites = new boolean[n][n];        
      topSite 	= n*n;
      bottomSite 	= n*n + 1;	
      gridLength  = n;		
      wQF1 = new WeightedQuickUnionUF(n*n + 2);
      wQF2 = new WeightedQuickUnionUF(n*n + 1);
   }

   public void open(int row, int col)
   {
      if (indexCheck(row, col))
      {			
         openedSitesNo += 1;
         int gridIndex =  gridIndex(row, col);
         openedSites[row - 1][col -1] = true;

         if (row == 1)
         {
            wQF1.union(topSite, gridIndex);
            wQF2.union(topSite, gridIndex);
         }

         if (row == gridLength)
         {
            wQF1.union(bottomSite, gridIndex);
         }

         if (row > 1)
         {
            connectIfOpenedSite(gridIndex, row - 1, col);
         }
         if (row < gridLength)
         {
            connectIfOpenedSite(gridIndex, row + 1, col);
         }
         if (col > 1)
         {
            connectIfOpenedSite(gridIndex, row, col - 1);
         }
         if (col < gridLength)
         {
            connectIfOpenedSite(gridIndex, row, col + 1);	
         }		


      }
      else
         throw new IndexOutOfBoundsException();
   }


   public boolean isOpen(int row, int col)
   {
      if (indexCheck(row, col))
         return openedSites[row - 1][col - 1];

      throw new IndexOutOfBoundsException();
   }

   public boolean percolates()
   {
      return wQF1.connected(topSite, bottomSite);
   }

   public int numberOfOpenSites()
   {   
      return openedSitesNo;
   }
   public boolean isFull(int row, int col)
   {
      if (indexCheck(row, col))
      {
         int gridIndex = gridIndex(row, col);
         return wQF2.connected(gridIndex, topSite);
      }
      throw new IndexOutOfBoundsException();
   }

   private void connectIfOpenedSite(int gridIndex, int row, int col)
   {
      if (isOpen(row, col))
      {
         int sideGridIndex = gridIndex(row, col);
         wQF1.union(sideGridIndex, gridIndex);
         wQF2.union(sideGridIndex, gridIndex);
      }
   }

   private boolean indexCheck(int row, int col)
   {
      if (row < 1 || row > gridLength || col < 1 || col > gridLength)
         return false;
      return true;
   }

   private int gridIndex(int row, int col)
   {
      return (row - 1)*gridLength + col - 1;
   }
}