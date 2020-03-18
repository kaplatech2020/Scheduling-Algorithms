/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package priority;

/**
 *
 * @author  Miguela, Melchie
 *          Sagarino, Beth Dianne
 *          Sandoval, Maryvil
 *          Tajanlangit, Earl Francis
 *          Turtoga, Christine Joy
 */
import java.util.Scanner;
public class Priority 
{
    public static void main(String[] args) 
    {
        System.out.println("||-- Priority Scheduling --||");
        
        Scanner console=new Scanner(System.in);
        
        //Global declaration of variables
	int x=0,i,temp;
	float totalWT = 0, averageWT;
	    
        System.out.print("Enter the Number of Processes: "); 
        int process=console.nextInt();

         int[] proc=new int[process];
         int[] burstTime=new int[process];
         int[] prior=new int[process];
         int[] waitingTime=new int[process];
         
         for(i=0;i<process;i++)
         {
            System.out.print("Enter Burst Time for Process "+(i+1) + " >> "); 
             proc[i]=i+1;
             burstTime[i]=console.nextInt();
         }
         
        //To let the user input priority time for each process/es
        priorTime(process, prior);
        
        for(i=0;i<process;i++)
        {
            x=i;
          for(int j=i+1;j<process;j++)
           {
            if(prior[j]<prior[x])
            x=j;
           }
           
             temp=prior[x];
             prior[x]=prior[i];
             prior[i]=temp;
             temp=proc[x];
             proc[x]=proc[i];
             proc[i]=temp;
             temp=burstTime[x];
             burstTime[x]=burstTime[i];
             burstTime[i]=temp;
         }
        waitingTime[0]=0;
        
        for(i=1;i<process;i++)
        {
         waitingTime[i]=0;
            for(int j=0;j<i;j++)
            {
             waitingTime[i]+=burstTime[j];
            }
             totalWT += waitingTime[i]; //To calculate total waiting time
        }
        
        System.out.println("Process\tBurst Time \tPriority Time");
        for(i=0;i<process;i++)
        {
            System.out.println(proc[i]+"\t"+burstTime[i]+"\t\t"+prior[i]);
        }
        System.out.println("\nTotal Waiting Time: "+ totalWT + " ms");
       
        averageWT = calcAverageWT(process,totalWT);
        System.out.print("Total Average Time: "+ averageWT + " ms");
        }
        
        //To let the user input priority time for each process/es
        public static int[] priorTime(int process, int[] prior)
        {
            Scanner console = new Scanner(System.in);
            for(int i=0; i<process; i++)
            {
                 System.out.print("Enter Priority Time for Process "+(i+1) + " >> "); 
                prior[i]=console.nextInt();
            }
            return prior;
        }
        
        //To calculate Average Waiting Time
	public static float calcAverageWT(int process, float totalWT)
	{
	     float AWT = 0;
	     AWT = totalWT/process; 
	     return AWT;
	}
}
