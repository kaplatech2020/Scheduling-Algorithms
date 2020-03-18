/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roundrobin;

/**
 *
 * @author  Miguela, Melchie
 *          Sagarino, Beth Dianne
 *          Sandoval, Maryvil
 *          Tajanlangit, Earl Francis
 *          Turtoga, Christine Joy
 */
import java.util.Scanner;
public class RoundRobin 
{
    public static void main(String[] args) 
    {
        System.out.println("||-- Round Robin Scheduling --||");
        
        Scanner console = new Scanner(System.in);
        
        //Global declarations of variables
        int quantumT ,sum=0, totalWT = 0;
        float totalWaitTime, averageWT;
        
        System.out.print("Enter Number of Process/es >> ");
        int num =console.nextInt();
        
        int burstTime[]=new int[num];
        int waitingTime[]=new int[num];
        int arr[]=new int[num];

        //To let the user input burst time for each process/es
        burstTime(num, burstTime);
        
        System.out.print("Enter Quantum Time >> ");
        quantumT = console.nextInt();
        
        for(int i=0;i<num;i++)
        arr[i]=burstTime[i];
        
        for(int i=0;i<num;i++)
        waitingTime[i]=0;
      
        do
        {
            for(int i=0;i<num;i++)
            {
                if(burstTime[i]>quantumT)
                {
                    burstTime[i]-=quantumT;
                    for(int x=0;x<num;x++)
                    {
                        if((x!=i)&&(burstTime[x]!=0))
                        waitingTime[x]+=quantumT;
                    }
                }
                else
                {
                    for(int j=0;j<num;j++)
                    {
                        if((j!=i)&&(burstTime[j]!=0))
                        waitingTime[j]+=burstTime[i];
                    }
                    burstTime[i]=0;
                }
            }
            sum=0;
            for(int k=0;k<num;k++)
            sum=sum+burstTime[k];
        }
        while(sum!=0);
        
        System.out.println("Process\tBurst Time\tWaiting Time");
        for(int i=0;i<num;i++)
        {
            System.out.println("P"+(i+1)+"\t"+arr[i]+"\t\t"+waitingTime[i]);
        }
      
        totalWaitTime = calcTotalWT(waitingTime,num,totalWT);
        System.out.println("Total waiting time : "+ totalWaitTime +" ms");
        
        averageWT = calcAverageWT(num,totalWaitTime);
        System.out.println("Average waiting time : "+ averageWT +" ms");
    }
    
     //Method for letting the user input burst time for a specific process
     public static int[] burstTime(int num, int[] burstTime)
    {
        Scanner console = new Scanner(System.in);
        for(int i=0;i<num;i++)
        {
            System.out.print("Enter Burst Time for "+(i+1) + " >> ");
            burstTime[i]=console.nextInt();
        }
        return burstTime;
    }
	
    //To calculate Total Waiting Time
    public static int calcTotalWT(int[] waitingTime,int num, int totalWT)
    {
	for(int j=0;j<num;j++)
        {
            totalWT +=waitingTime[j];
        }
	return totalWT;
    }
    //To calculate Average Waiting Time
    public static float calcAverageWT(int num, float totalWaitTime)
    {
	float AWT = 0;
	AWT=totalWaitTime/num; 
	return AWT;
    }
}
