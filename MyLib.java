package MyPackage;

//  Author:   Irina Golovko
//  Date:     09/17/2017
//  Homework assignment: 2
//  Objective: This program contains next 7 methods with 
//  multiple arguments: add, subt, div, mult, print, 
//  println. We can use this program multiple times
//  in others programs.
//****************************************************************


public class MyLib
{

//**********************************add()*******************************

    public static int add(int ...numbers)
    {
        int total = 0; // Accumulator
    	
    	if (numbers.length < 2 )
        	
	    {
	         System.err.println("Error: not enough arguments." +
	                         "\nIt supposed to be no less then 2.");
	         System.exit(1);
	    }
    	else
    	{
    		for (int val : numbers)
    			 total += val;		
    	}   		
    	return total;
    }
	
	
//**********************************subt()*******************************	
    
    public static int subt(int ...numbers)
    {
		if (numbers.length < 2)
	    {
	         System.err.println("Error: not enough arguments." +
	                         "\nIt supposed to be no less then 2.");
	         System.exit(1);
	    }
    	
		 int total = numbers[0];
       	 for (int i = 1; i < numbers.length; i++)
    	
		
		
		
		 {
    	      total -= numbers[i]; 	
    	 } 	
    	
		 return total;
    }
    
	
//**********************************div()*******************************	
    public static double div(int ...numbers)
    {
    	if (numbers.length < 2 )  	
	    {
	        System.err.println("Error: not enough arguments." +
	                         "\nIt supposed to be less then 2.");
	        System.exit(1);
	    }
    	
		for (int j = 0; j < numbers.length; j++)
    	{
    		if (numbers[j] == 0) 
			{
	  	        System.err.println("Error: We cannot divide by zero.");
	  	        System.exit(1);
			}
    			
    	}
		
		double total = numbers[0];		
		for (int j = 1; j < numbers.length; j++)
    	{
    		total = total / numbers[j];
    			
    	}
    	
    	return total;
    }  	    
	
	
//**********************************mult()*******************************	
    public static int mult(int ...numbers)
    {
    	int total = 1; 
    	if (numbers.length < 2 )
	    {
	        System.err.println("Error: not enough arguments." +
	                         "\nIt supposed to be no less then 2.");
	        System.exit(1);
	    }
			
		else
    	{
    		
			
			
			for (int val : numbers)
    			total *= val;		
    	}   		
    	return total;
    }  	    
    
    
//**********************************print()*******************************
    public static void print(String str)
	{
	     System.out.print(str);
	}
	
	
//**********************************println()*****************************
    public static void println(Object ... o)
	{
	     if(o.length == 0)
	     {
	          System.out.print("");
	     }
	      else if(o.length == 1)
	      {
	          System.out.print("" + o[0]);
	      }
	      else for(Object obj : o)
	      {
	          System.out.print("" + obj + "\t");
	      }
	      System.out.println("");
    }
	
	
//**********************************die()*********************************
    public static void die(String ... msg)
	{
	     if(msg.length > 0) 
	     {
	          System.err.println(msg[0]); 
	     }
	     System.exit(1);
	}
	
}	