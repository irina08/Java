import java.util.*;
import java.io.*;
import java.util.jar.*;

/* Author:   Irina Golovko
*  Date  :   16/10/2017
*  Homework assignment : 4
*  Objective: This program Mrs.java will restore files
*  from the archive .ResycleBin.jar in the current directory. 
*  If file exist program will ask user to rename old 
*  version of file in order to restore the newest one. 
*  You should to imput absolute name of files.
*  The copy of file will stay in the jar archive.
* ****************************************************************
*/
public class Mrs
{
/***************************renameOld()*************************************/	
	public static void renameOld(File f)
	{
		Scanner ans = new Scanner(System.in);
		String fname = f.getName();
		System.out.println(fname + " already exist in this location.");
	 	System.out.println("Please rename old version of file for restoring"
		                 + " new one.");
	 	String answer = ans.nextLine();
	 	System.out.println("Now old version of file is: " + answer);
		File ff = new File(answer);
		f.renameTo(ff);	
	}
/***************************restoreFile()*************************************/	
	public static void restoreFile(String fname)
	{
		ArrayList<String> commands = new ArrayList<String>();
 		commands.add("jar");
 		commands.add("-xvf");
 		commands.add("/Users/irinagolovko/Desktop/CS211S/.ResycleBin.jar");
		commands.add(fname);

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
		
		
		
		
		
		System.out.println("File " + fname + " successfully restored.");
	}

/***************************main()*************************************/			
    public static void main(String ... args) 
	{
		File[] files=new File[args.length];
		try
		{
			for(int i=0;i<args.length;i++) 
			{
				String argument=args[i];
				File f = new File(argument);
				String fname = f.getName();
				JarFile jar = 
				new JarFile("/Users/irinagolovko/Desktop/CS211S/.ResycleBin.jar");
				JarEntry entry = jar.getJarEntry(fname);
	 	
				if (entry != null)
				{
		    		if (f.exists()) // on your PC
					{
						renameOld(f);
						restoreFile(fname);
					}
					else
					{
						restoreFile(fname);
					}		
				}	
				else
				{
					System.err.println("Jar archive doesn't have file " + fname);
				}		
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
