package Alg1;

public class manePartition 
{

	public static void qSort(int[] a, int p, int r)
    {
        if(p<r)
        {
            int q = Partition(a, p,r);
            System.out.println("Lomuto-Partition zwraca: "+q);
            int z = Hoere(a,p,r);
            System.out.println("Hoare-Partition zwraca: "+z);
            //qSort(a, p, q-1);
            //qSort(a, q+1, r);
        }
     }
	
	/*static int Hoere (int a[],int p, int r) 
	{
	    int x=a[p],i=p-1,j=r+1;
	    while (true) 
	    {
	        while (a[j] <= x) j--; 
	        while (a[i] >= x) i++;
	        if  (i < j) 
	        {
	        	int temp = a[i];
	        	a[i] = a[j];
	        	a[j] = temp;
	        }
	        else return j;
	    }
	}*/
	private static int Hoere(int[] A, int p, int r)
    {
            int x = A[p];
            int i = p - 1;
            int j = r + 1 ;

            int exchange;

            while (true)
            {
                    do
                    {
                            j--;
                    }
                    while (A[j] > x);

                    do
                    {
                            i++;
                    }
                    while (A[i] < x);

                    if (i < j)
                    {
                            exchange = A[i];
                            A[i] = A[j];
                            A[j] = exchange;
                    }
                    else
                            return j;
            }
    }


     private static int Partition(int[] a, int p, int r)
     {
         int x = a[r];

         int i = p-1;
         int temp=0;

         for(int j=p; j<r; j++)
         {
             if(a[j]<=x)
             {
                 i++;
                 temp = a[i];
                 a[i] = a[j];
                 a[j] = temp;
             }
         }

         temp = a[i+1];
         a[i+1] = a[r];
         a[r] = temp;
         return a[i+1];
     }



     public static void main(String[] args)
     {
         
    	 int[] array = {50, 67, 89, 33, 73, 31, 63, 69, 92, 33, 19, 99, 68, 17, 40, 29, 1, 10, 70, 32, 72, 66, 98, 33, 4, 50, 53, 78, 39, 8, 26, 90, 75, 15, 24, 49, 47, 87, 18, 40, 21, 37, 39, 89, 54, 80, 18, 56, 91, 89};

         int length = array.length;

         qSort(array.clone(), 0, length-1);
     }

}
