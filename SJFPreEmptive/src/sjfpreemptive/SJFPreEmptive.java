/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sjfpreemptive;

/**
 *
 * @author  Miguela, Melchie
 *          Sagarino, Beth Dianne
 *          Sandoval, Maryvil
 *          Tajanlangit, Earl Francis
 *          Turtoga, Christine Joy
 */
import java.util.Scanner;
public class SJFPreEmptive 
{ 
    Scanner input = new Scanner(System.in);
    //Global declarations of variables
    int numberOfProcess,value;
    int[] bTime, aTime, duplicateBTime, wTime;
    int complete = 0, t = 0, minm = Integer.MAX_VALUE,shortest = 0, finish_time, totalWTime =0; 
    double averageWTime = 0; 
    boolean check = false;

    public void SJFSched()
    {
        System.out.println("||--Shortest Job First Scheduling (Pre-emptive)--||");

        System.out.print("Enter Number of processes: ");
        numberOfProcess = input.nextInt();
        bTime = new int[numberOfProcess];
        aTime = new int[numberOfProcess];
        wTime = new int[numberOfProcess];
        duplicateBTime = new int[numberOfProcess];
        for(int x = 0; x < numberOfProcess; x++)
        {
            System.out.print("Enter the burst time of P" + (x+1) + " >>");
            value= input.nextInt();
            bTime[x] = value;
        }
        for(int x = 0; x < numberOfProcess; x++)
        {
            System.out.print("Enter the arrival time of P" + (x+1)+ " >>");
            value = input.nextInt();
            aTime[x] = value;
        }  
        System.arraycopy(bTime, 0, duplicateBTime, 0, numberOfProcess);  
        validateSJF();
        calculateTotalWaitingTime();
        calculateAverageWaitingTime();
        
        System.out.println("Total Waiting Time  "+ totalWTime + " ms");
        System.out.println("Average Waiting Time " + averageWTime + " ms");
    }
    
    //To find shortest job first
    public void validateSJF()
    {
         while(complete != numberOfProcess) {
            for(int x = 0; x<numberOfProcess; x++){
                if((aTime[x] <= t) && (duplicateBTime[x] < minm) && duplicateBTime[x] > 0){
                    minm = duplicateBTime[x];
                    shortest = x;
                    check = true;
                }
            }
            if(check == false){
                t++;
                continue;
            }
            duplicateBTime[shortest]--;
            
            minm = duplicateBTime[shortest]; 
            
            if (minm == 0) 
            {
                minm = Integer.MAX_VALUE; 
            }
            
            if(duplicateBTime[shortest] == 0){
                complete++;
                check = false;
                finish_time = t + 1; 
                
                wTime[shortest] = finish_time - bTime[shortest] - aTime[shortest];
                
                if(wTime[shortest] < 0 ){
                    wTime[shortest] = 0;
                }
            }
            t++;    
        }
    }
    
    //To calculate Total Waiting Time
    public void calculateTotalWaitingTime()
    {
        for(int x = 0 ; x< numberOfProcess; x++)
        {
            totalWTime += wTime[x];
        }
    }
    
    //To calculate Average Waiting Time
    public void calculateAverageWaitingTime()
    {         
        averageWTime = totalWTime;
        averageWTime /= numberOfProcess;
        System.out.println("PROCESS \tBURST TIME\t ARRIVAL TIME");
        for(int x = 0; x < numberOfProcess; x++)
        {
            System.out.println((x+1)+ "\t\t" + bTime[x] + "\t\t" + aTime[x]);
        }
    }
    
    public static void main(String[] args) 
    {
      SJFPreEmptive sjfPreEmp = new SJFPreEmptive();
      sjfPreEmp.SJFSched();
    }
}
