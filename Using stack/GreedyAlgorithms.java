//   2019/E/054

import java.util.Scanner;
import java.util.Stack;

public class GreedyAlgorithms
{
//Method for find maximum numbers of bottles that can filled
static int greedyApproach(Stack<Integer> stackArr, int amount) 
{
    //If the container amount reaches to 0, return 0
    if(amount <= 0)
    {
        return 0;
    }
/* Check the capacities of the bottles one by one and 
find the maximum number of bottles that can be filled the container */  
    for(int i = 0; i < stackArr.size() ; i++)
    {
        if(amount > stackArr.peek())
        {  
            amount = amount - stackArr.peek();
            stackArr.pop();   

            return 1 + greedyApproach(stackArr, amount);
        }
    }
return 0;
}

// Method for sort (Using Bubble Sort)
void sort(int[] arr)
{
    while(true)
    {
        boolean swapped = false;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]>arr[i+1])
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
}	
	
	public static void main(String args[] )
	{
    
		 Scanner sc = new Scanner(System.in);       //Create a object in scanner class
         GreedyAlgorithms g = new GreedyAlgorithms();     //Create a object in GreedyAlgorithms class

        System.out.print("\tFind maximum number of bottles that can be filled from container ");
        System.out.print("\nInput the number of bottles and capacity of the container by using spaces : ");

        //Get user inputs for number of bottles and capacity of the container
        int N = sc.nextInt();      
        int X = sc.nextInt();

        System.out.print("\nInput the capacity of bottles one by one using spaces : ");

        //Get user inputs for capacity of bottles
        int[] bottleArr = new int[N];
        for(int i=0;i<N;i++)
        {
            bottleArr[i] = sc.nextInt();
        }          

        //Sort the array using bubble sort
        g.sort(bottleArr);  

        //Create new stack
        Stack<Integer> stack = new Stack<>(); 

        //Push the sorted capacities of bottles into stack
        for(int k= bottleArr.length - 1;k>=0;k--)
        {
            stack.push(bottleArr[k]);
        }    
        
        //Calculate the maximum number of bottles that can be filled and user display the result
        System.out.println("\nMaximum number of bottles that can filled : " + g.greedyApproach(stack, X));      
        
   }

}