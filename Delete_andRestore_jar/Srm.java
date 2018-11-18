import java.util.*;
import java.io.*;
import java.util.jar.*;

/* Author:   Irina Golovko
*  Date  :   016/10/2017
*  Homework assignment : 4
*  Objective: This program delete files putting the user
*  in the command line. Copy of the deleted files 
*  adds to the archive - .ResycleBin.jar. 
*  If archive doesn't exist program will create it, 
*  if exist - just add new items.
*  You can use option 'i', which will ask you to 
*  confirmation for deleting files.
*  You should to use absolute name of files.
*  If file already exist in the archive it will ask you 
*  about overwritten file in the archive.
* **************************************************************** */

public class Srm
{
     public static void main(String ... args) throws IOException
	 {
		  File[] files=new File[args.length];
		  Scanner sc = new Scanner(System.in);
		  if(args[0].equalsIgnoreCase("-i"))
		  {
		      for(int i=1;i<args.length;i++) 
			  {
			       String argument=args[i];
				   File f = new File(argument);
				   String fname = f.getName();
				
				   if (f.exists())
		 	       {
				   		if(f.isFile() && f.canWrite() && f.canRead())
		 		   	    {  
					  		 System.out.println("Do you want to delete " + 
									                 fname + "?");
					   	     String answer = sc.nextLine();
		 			   		 if(answer.equalsIgnoreCase("yes"))
		 			   		 {
						   		   createBucket(f);
								   f.delete();
						           System.out.println("File " + fname + 
										                 " successfully deleted");
					   		  }
		 			   		  else
					   		  {
						  		   System.out.println("Skipped file "+ fname);
					   		  }
				    	 
						 
						 
						 
						 }
						 else
						 {
							  System.err.println("We cannot delete file " + fname  
							                 + ". Check the permission of file.");
						 }
			    	}
					else
						 System.err.println("File " + fname + " doesn't exist.");
		    	 }
		    }
		    else
		    {
			     for(int i=0;i<args.length;i++) 
			     {
					  String argument=args[i];
					  File f = new File(argument);
					  String fname = f.getName();
					  if (f.exists())
				      {
					       if(f.isFile() && f.canWrite() && f.canRead())
						   {
					           createBucket(f);
							   f.delete();   
							   System.out.println("File " + fname + 
								                  " successfully deleted");
						   }
					       else
					       { 
						        System.err.println("We cannot delete file " +  
							                    fname + ". Check the permission.");
					       }
				       }
				       else
					   {
					       System.err.println("File " + fname + " doesn't exist.");
					   }
			     }
		   }	  
	 }
/*****************************createBucket()***********************************/	 
	 public static void createBucket(File f) throws IOException
	 {
		 File fb = new File("/Users/irinagolovko/Desktop/CS211S/.ResycleBin.jar");
		 String fname = f.getName();
		 if(!fb.exists())
		 {
		     ArrayList<String> commands = new ArrayList<String>();
			 commands.add("jar");
			 
			 
			 
			 commands.add("-cvf");
			 commands.add("/Users/irinagolovko/Desktop/CS211S/.ResycleBin.jar");
			 commands.add(fname);
			 builder(commands);
			 System.out.println("Bucket " + 
				     "/Users/irinagolovko/Desktop/CS211S/.ResycleBin.jar"
				                + " created.");
			 System.out.println("file " + fname + " added to Bucket.");
		 } 
		 else
		 {
	 		 JarFile jar = 
				 new JarFile("/Users/irinagolovko/Desktop/CS211S/.ResycleBin.jar");
	 		 JarEntry entry = jar.getJarEntry(fname);	
			 ArrayList<String> commands1 = new ArrayList<String>();	 
		 	 commands1.add("jar");
		 	 commands1.add("-uf");
		 	 commands1.add("/Users/irinagolovko/Desktop/CS211S/.ResycleBin.jar");
		 	 commands1.add(fname);
 			 if (entry != null)
 			 {
		 		 Scanner ans = new Scanner(System.in);
		 		 System.out.println(fname + " already exist in the archive.");
		 	 	 System.out.println("Do you want to overwritte " + fname +
					                " in the archive?");
				 String aa = ans.nextLine();
			     if(aa.equalsIgnoreCase("yes"))
			     {
	   			 	 builder(commands1);
	   			 	 System.out.println("File " + fname + " were overwritten "
						                 + "in the archive.");
			     }
			     else
			     {
				     System.out.println("Before deleting file " + fname + 
					                  " you should rename it."); 
			     }	              
		     }
			 else
			 {
			 	builder(commands1);
				System.out.println("file " + fname + " added to Bucket.");	
			 }
		}	 
	} 

/*****************************builder()***********************************/	
	public static void builder(ArrayList<String> commands)
	{
		ProcessBuilder pb = new ProcessBuilder(commands);
		try 
 	    {
      	     
			 
			 
			 Process prs = pb.start();
	         Scanner sc = new Scanner(prs.getInputStream());
	 		 while (sc.hasNextLine())
		  	     System.out.println(sc.nextLine());
 		} 
 	    catch (IOException e) 
 	    {
     	    e.printStackTrace();
 	     } 
	 }
}