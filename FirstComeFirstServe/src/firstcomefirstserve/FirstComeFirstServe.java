/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package firstcomefirstserve;

/**
 *
 * @author  Miguela, Melchie
 *          Sagarino, Beth Dianne
 *          Sandoval, Maryvil
 *          Tajanlangit, Earl Francis
 *          Turtoga, Christine Joy
 */
import java.util.Scanner;
public class FirstComeFirstServe 
{
    public static void main(String[] args)
    {
        System.out.println("||--First Come First Serve--||"); 
        Scanner console =new Scanner(System.in);
        
	 //Global declarations of variables	
        int process, burstTimeArr[], waitingTimeArr[];
        float totalWaitingTime=0,average = 0;

        System.out.print("Enter number of processes >> ");
        process=console.nextInt();
        
        burstTimeArr = new int[process];
        waitingTimeArr = new int[process];
        waitingTimeArr[0] = 0;
        
        //Method for letting the user input burst time for a specific process
        burstTime(process, burstTimeArr);
       
        for(int i=1;i<process;i++)
        {
           waitingTimeArr[i]= burstTimeArr[i-1]+ waitingTimeArr[i-1];
           totalWaitingTime += waitingTimeArr[i];//To calculate Total Waiting Time
        }
        
        //To display First Come First Serve Scheduling Result
        System.out.println("Process\tBurst time\tWaiting time");
        for(int i=0;i<process;i++)
        {
            System.out.println("P"+(i+1)+"\t\t"+ burstTimeArr[i]+"\t\t"+waitingTimeArr[i]);
        }
        //To display Total Waiting Time
        System.out.println("\nTotal Waiting time = " + totalWaitingTime + " ms");
        
        //To calculate Average Waiting Time
        average = totalWaitingTime / process ;
        String output = String.format(" %.2f",average);
        //To display Average Waiting Time
        System.out.println("Average Waiting time =" + output + " ms");
    }
    
     //Method for letting the user input burst time for a specific process
    public static int[] burstTime(int process, int[] burstTimeArr)
    {
	Scanner console =new Scanner(System.in);
	for(int i=0;i<process;i++)
        {
            System.out.print("Enter Burst time for P"+(i+1)+" >> ");
            burstTimeArr[i]=console.nextInt();
        }
        return burstTimeArr;
    }
}
