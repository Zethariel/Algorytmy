package Alg1;

import java.util.Random;
import java.util.Scanner;

public class mane {

	
	static int[] matrix;
	static int[] matrixsort;
	static int[] matrixinverse;
	
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
	       matrixsort = x;
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
	 
	 
	public static void main(String[] args) 
	{
		generateMatrix(100);
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
		System.out.println("3) Bubble sort sorted table");
		System.out.println("4) Smart Bubble sort sorted table");
		System.out.println("5) Bubble sort reverse sorted table");
		System.out.println("6) Smart Bubble sort reverse sorted table");
		System.out.println("7) Le Quit");	
		choice=reader.nextInt();
		if (choice == 0)
		{
			System.out.println("Please select a table size: ");
			generateMatrix(reader.nextInt());
			continue;
		}
		
		switch (choice)
		{
		case 1:	bubbleSort(matrix.clone());
				break;
		
		case 2: bubbleSortSmart(matrix.clone());
				break;
		case 3: bubbleSort(matrixsort.clone());
			break;
		case 4: bubbleSortSmart(matrixsort.clone());
			break;
		case 5: bubbleSort(matrixinverse.clone());
			break;
		case 6: bubbleSortSmart(matrixinverse.clone());
			break;
		}
		} while (choice != 7);
		reader.close();

	}

	static void generateMatrix(int i) {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		int[] x = new int[i];
		for (int y = 0; y < i; y++)
			x[y] = rnd.nextInt();
		matrix = x;
		bubbleSort(matrix.clone());
		matrixinverse = new int[i];
		for (int z = 0; z<matrix.length;z++)
			matrixinverse[matrixinverse.length-1-z] = matrixsort[z];
	}

}
