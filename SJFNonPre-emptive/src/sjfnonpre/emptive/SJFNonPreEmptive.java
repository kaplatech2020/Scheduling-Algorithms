/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sjfnonpre.emptive;

/**
 *
 * @author  Miguela, Melchie
 *          Sagarino, Beth Dianne
 *          Sandoval, Maryvil
 *          Tajanlangit, Earl Francis
 *          Turtoga, Christine Joy
 */
import java.util.Scanner;
public class SJFNonPreEmptive 
{
    public static void main(String[] args) 
    {
        
        System.out.println("||--Shortest Job First Scheduling (Non Pre-emptive)--||"); 
        Scanner console = new Scanner(System.in); 
        
        //Global declaration of variables
        int num, temp,totalWT = 0;
        float AWT=0;
        
        System.out.print("Enter Number of Process/es >> "); 
        num=console.nextInt(); 
        
        int[] burstTime = new int[num+1]; 
        int[] waitingTime =new int[num+1]; 
        int[] turnTime = new int[num+1];
        int[] outTime = new int[num+1];

        for(int i=0;i<num;i++) 
        { 
            System.out.print("Enter Burst Time for Process "+(i+1) + " >> "); 
            burstTime[i]=console.nextInt(); 
            outTime[i]=i+1;
        }
        
        for(int i=0;i<num;i++) 
        {
            waitingTime[i]=0; 
            turnTime[i]=0; 
        } 
        
        for(int i=0;i<num-1;i++) 
        {
            for(int j=0;j<num-1;j++) 
            { 
                if(burstTime[j]>burstTime[j+1])    
                {
                    temp=burstTime[j]; 
                    burstTime[j]=burstTime[j+1]; 
                    burstTime[j+1]=temp; 
                    temp=outTime[j]; 
                    outTime[j]=outTime[j+1]; 
                    outTime[j+1]=temp; 
                }
            }
        } 
            
        for(int i=0;i<num;i++) 
        {
            turnTime[i]=burstTime[i]+waitingTime[i]; 
            waitingTime[i+1]=turnTime[i]; 
        } 
            turnTime[num]=waitingTime[num]+burstTime[num]; 
            
        for(int j=0;j<num;j++) 
        {
            turnTime[j]=waitingTime[j]+burstTime[j];
            AWT+=waitingTime[j]; 
        }
        
        System.out.println("Process\t\tBurst Time\tWaiting Time"); 
        for(int i=0;i<num;i++)
        {
        System.out.println("   " + outTime[i] +"\t\t"+burstTime[i]+"\t\t"+waitingTime[i]); 
        }
        
        float totalWaitTime =  calcTotalWT(waitingTime,num,totalWT);
        float averageWT = calcAverageWT(num,totalWaitTime,AWT);
        
        System.out.println("Total Waiting Time : " + totalWaitTime + " ms"); 
        System.out.println("Average Waiting Time : "+averageWT +" ms");
    }
    
        //To calculate Total Waiting Time
	public static int calcTotalWT(int[]waitingTime,int num, int totalWT)
	{
	    for(int i=0;i<num;i++)
        {
	     totalWT+=waitingTime[i]; 
        }
	     return totalWT;
	}
	
	//To calculate Average Waiting Time
	public static float calcAverageWT(int num, float totalWaitTime, float AWT)
	{
	     AWT=totalWaitTime/num; 
	     return AWT;
	}
}
