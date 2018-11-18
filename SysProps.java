import java.util.Enumeration;
import java.util.Properties;

//  Author:   Irina Golovko
//  Date  :   09/09/2017
//  Homework assignment : 1
//  Objective : This program check if entered command line options 
//  are valid (it should be n (how many properties your OS has), 
//  l (list of OS properties), h (help), p with argument (all 
//  properties belong to argument)) and produce appropriate outputs.
//****************************************************************


public class SysProps 
{
    public static void main(String ... args)
	{
	    // check if we have any arguments in command line
		if (args.length == 0)
	    {
	      System.err.println("You didn't put any options in the command line.");
	      errorMessage();	
	      System.exit(1);
	    }
	    
    GetOpt g = new GetOpt(args, "nlp:h");
    int c;
    
   g.opterr(false);  // suppress display error messages 

    while( (c = g.getopt()) != -1)
    {
        switch(c)
        {
        case 'n': System.out.println("For option 'n' number of all properties "
			                          + "belonging to your OS:");
                  countProperties(); 
				  break; 
				  
        case 'l': System.out.println("For option 'l' list all "
			                         + "properties of your OS: ");
		          listProperties(); break;
				  
        case 'p': String propName = g.getvalue(c); 
		          if (propName != null && !propName.equals(""))
				  {
				     System.out.println("For option 'p' with argument " + "'" 
						  				+ propName + "'" 
										+ " list of all properties of argument:");
				     listProperties(propName);
				  }
				  else
				  {
					  System.err.println("You need an argument for an option 'p'");
					  System.exit(1);
				  }					  
		          break;
				  
        case 'h': help(); break;
		
        case '?': System.err.println("Invalid option: " + g.optopt()); 
                  errorMessage();
                  System.exit(1);
        }
    }
}
//*****************************countProperties()**************************
    public static void countProperties()
    {
        Properties p = System.getProperties();
        Enumeration keys = p.keys();
        int count = 0;
        
		while (keys.hasMoreElements()) 
		{
			String key = (String) keys.nextElement();
			count += 1;
			String value =(String) p.getProperty(key);
			
		}
		System.out.println("Your OS has " + count + " properties");
		System.out.println("*********************************************");
        
    }
   
//*****************************listProperties()**************************  
    public static void listProperties()
    {
		Properties p = System.getProperties();
        Enumeration keys = p.keys();
        
		while (keys.hasMoreElements()) 
		{
			String key = (String) keys.nextElement();
			String value =(String) p.getProperty(key);
			System.out.println(key + ": " + value);
		}	
		System.out.println("**********************************************");
    }	
    
//*****************************help()**************************************** 
    public static void help()
    {
      System.out.println("You should to put in the command line any "
		                 + "of the next valid options: "
		                 + "\nn - let you know how many properties your OS has"
	                     + "\nl - will produce list of all properties belonging "
						 + "to your OS"
		                 + "\nh - help: will explain how to use this program"
	                     + "\np with argument - will produce list of all "
						 + "properties " + "\nbelonging to the argument."
	                     + "\nIf you put invalid options, you will see"
						 + "\nerror message, the program will terminate"
						 + "\nand you should to start again.");
	  System.out.println("**********************************************");
    }
    
//*****************************errorMessage()**************************************   
    public static void errorMessage()
    {
      System.err.println("You should to put any of the next options: "
      		             + "\nn - how many properties your OS has"
    		             + "\nl - to list properties belonging to your OS"
      		             + "\nh - help: explain how to use this program"
    		             + "\np with argument - to list all properties "
						 + "belonging to the argument");
    }
	
   
//*****************************listProperties()**************************  
    public static void listProperties(String propName)
	{
		Properties p = System.getProperties();
	    Enumeration keys = p.keys();
		int count = 0;
        
		while (keys.hasMoreElements()) 
		{
			String key = (String) keys.nextElement();
			if (key.startsWith(propName))
			{
				count++;
				String value =(String) p.getProperty(key);
				System.out.println(key + ": " + value);
			}
				
		}	
		
		if (count == 0)
			System.out.println("Your argument " + "'" + propName + "'" 
				               + " doesn't have any property.");	
		System.out.println("**********************************************");
	    
	}		
	      
}   	

	      
