import java.util.*;

public class GreedyAlgorithms
{

int greedyApproach(int[] arr, int amount)
{
    if(amount <= 0)
    {
        return 0;
    }

    for(int i = arr.length - 1; i >= 0; i--)
    {
        if(amount > arr[i])
        {           
            return 1 + greedyApproach(Arrays.copyOf(arr, arr.length - 1), amount - arr[i]);
        }
    }
return 0;
}


void sort(int[] arr)
{
    while(true)
    {
        boolean swapped = false;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]<arr[i+1])
            {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                swapped = true;
            }
        }
        if(!swapped)
            break;
    }
   /*for(int j=0;j<arr.length;j++)
    {
      System.out.print(arr[j] + " ");  
    }
    */
    
}	
	
	public static void main(String args[] )
	{
    
		 Scanner sc = new Scanner(System.in);
         GreedyAlgorithms g = new GreedyAlgorithms();

        System.out.print("\nInput the number of bottles and capacity of the container by using spaces : ");
        int N = sc.nextInt();
        int X = sc.nextInt();

        System.out.print("\nInput the capacity of bottles one by one using spaces : ");

        int[] bottleArr = new int[N];
        for(int i=0;i<N;i++)
        {
            bottleArr[i] = sc.nextInt();
        }



        g.sort(bottleArr);      
        
        System.out.println("\nMaximum number of bottles that can filled : " + g.greedyApproach(bottleArr, X));      
        
   }

}