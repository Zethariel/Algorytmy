package Alg1;

import java.util.Random;
import java.util.Scanner;

public class mane {

	
	static int[] matrix;
	static int[] matrixcopy;
	static int[] merged;
	
	 static void bubbleSort(int[] x) 
	 {
		 long startTime = System.currentTimeMillis();
	        int size = x.length - 1;
	        for (int i = 0; i < x.length - 1; i++) 
	        {
	            for (int j = 0; j < size; j++) 
	            {
	                if (x[j] > x[j + 1])
	                {	
	                    int temp = x[j];
	                    x[j] = x[j + 1];
	                    x[j + 1] = temp;
	                }
	            }
	            size--;
	        }
	       System.out.println("Operation complete! Time taken: "+(System.currentTimeMillis() - startTime)+" miliseconds.");
	 }
	 
	 static void bubbleSortSmart(int[] x) 
	 {
		 long startTime = System.currentTimeMillis();
	        int size = x.length - 1;
	        for (int i = 0; i < x.length - 1; i++) 
	        {
	        	boolean end = true;
	            for (int j = 0; j < size; j++) 
	            {
	            	
	                if (x[j] > x[j + 1])
	                {	
	                    int temp = x[j];
	                    x[j] = x[j + 1];
	                    x[j + 1] = temp;
	                    end = false;
	                }
	            }
	            size--;
	            if (end == true)
	            	break;
	        }
	       System.out.println("Operation complete! Time taken: "+(System.currentTimeMillis() - startTime)+" miliseconds.");
	 }
	 
	 static void selectionSortMinimum(int[] x) 
	 {
		 long startTime = System.currentTimeMillis();
		    for (int i=0; i<x.length-1; i++) 
		    {
		        for (int j=i+1; j<x.length; j++) 
		        {
		            if (x[i] > x[j]) 
		            {
		                int temp = x[i];
		                x[i] = x[j];
		                x[j] = temp;
		            }
		        }
		    }
		    System.out.println("Operation complete! Time taken: "+(System.currentTimeMillis() - startTime)+" miliseconds.");
		}
	 
	 static void selectionSortMaximum(int[] x) 
	 {
		 long startTime = System.currentTimeMillis();
		    for (int i=0; i<x.length-1; i++) 
		    {
		        for (int j=i+1; j<x.length; j++) 
		        {
		            if (x[i] < x[j]) 
		            {
		                int temp = x[i];
		                x[i] = x[j];
		                x[j] = temp;
		            }
		        }
		    }
		    System.out.println("Operation complete! Time taken: "+(System.currentTimeMillis() - startTime)+" miliseconds.");
		}
	 
	 private static void merge(int pocz, int sr, int kon)
	 {
		 int i,j,q;
		 for (i=pocz; i<=kon; i++)
			 merged[i]=matrixcopy[i];  // Skopiowanie danych do tablicy pomocniczej
		 i=pocz; j=sr+1; q=pocz;                 // Ustawienie wskaŸników tablic
		 while (i<=sr && j<=kon) {         // Przenoszenie danych z sortowaniem ze zbiorów pomocniczych do tablicy g³ównej
		 if (merged[i]<merged[j])
		 matrixcopy[q++]=matrixcopy[i++];
		 else
		 matrixcopy[q++]=merged[j++];
	 }
	 while (i<=sr) matrixcopy[q++]=merged[i++]; // Przeniesienie nie skopiowanych danych ze zbioru pierwszego w przypadku, gdy drugi zbiór siê skoñczy³
	 }
	  
	 /* Procedura sortowania tab[pocz...kon] */
	 public static void mergesort(int pocz, int kon)
	 {
		 int sr;
		 if (pocz<kon) 
		 {
			 sr=(pocz+kon)/2;
			 mergesort(pocz, sr);    // Dzielenie lewej czêœci
			 mergesort(sr+1, kon);   // Dzielenie prawej czêœci
			 merge(pocz, sr, kon);   // £¹czenie czêœci lewej i prawej
		 }
	 }  
	 
	 public static void insertionSort(int a[])
	 {
		 long startTime = System.currentTimeMillis();
		 for (int i = 1; i < a.length; i++)
		 {
			  int j = i;
			  int temp = a[i];
			  while ((j > 0) && (a[j-1] > temp))
			  {
				  a[j] = a[j-1];
				  j--;
			  }
			  a[j] = temp;
		}
		 System.out.println("Operation complete! Time taken: "+(System.currentTimeMillis() - startTime)+" miliseconds."); 
	}
	 
	public static void main(String[] args) 
	{
		matrix = generateMatrix(100);
		int choice;
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to the sorting algorithm tester! Please select an option:");
		do
		{
		System.out.println("");
		System.out.println("");
		System.out.println("0) Reconfigure base table");
		System.out.println("1) Bubble sort");
		System.out.println("2) Smart Bubble sort");
		System.out.println("3) Maximum selection sort");
		System.out.println("4) Minimum selection sort");
		System.out.println("5) Insert sort");
		System.out.println("6) Merging sort");
		System.out.println("7) Le Quit");	
		choice=reader.nextInt();
		if (choice == 0)
		{
			System.out.println("Please select a table size: ");
			matrix = generateMatrix(reader.nextInt());
			continue;
		}
		
		switch (choice)
		{
		case 1:	bubbleSort(matrix.clone());
				break;
		
		case 2: bubbleSortSmart(matrix.clone());
				break;
		case 6:	
			merged = matrix.clone();
			matrixcopy = matrix.clone();
			long start = System.currentTimeMillis();
			mergesort(0,matrix.length-1);
			 System.out.println("Operation complete! Time taken: "+(System.currentTimeMillis() - start)+" miliseconds.");
			
		break;
		case 3: selectionSortMaximum(matrix.clone());
		break;
		case 4: selectionSortMinimum(matrix.clone());
		break;
		case 5: insertionSort(matrix.clone());
		break;
		}
		} while (choice != 7);
		reader.close();

	}

	static int[] generateMatrix(int i) {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		int[] x = new int[i];
		for (int y = 0; y < i; y++)
			x[y] = rnd.nextInt();
		merged = x;
		return x;
	}

}
