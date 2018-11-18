import java.io.*;
import java.util.*;

/* Author:   Irina Golovko
   Date  :   25/10/2017
   Homework assignment : extra credit
   Objective : This program read and load lines of 
   a given text file according to the lineRange,
   which can be like: ^ - fist line,
   $ - last line, 
   ^-$ - from beggining to the end
   1-5 - from 1 to 5, 
   5-1 - from 5 to 1,
   -5 - from beggining to 5,
   5- - from 5 to the end of file,
   - - the whole file, 
   5-7, 2, 4 , - with spaces
   and produce appropriate outputs.
   For demo we will use text.txt file 
/**************************************************************** */

public class FileLoader
{
	static ArrayList<String> fileLines = new ArrayList<String>();
	static ArrayList<String> resultLines;
	
	public static void main(String[] args) 
	{
        String[] result1 = loadFile("text.txt","-6,5-1,10-13,$,^,-, 5-7 , 2 - 4");
		System.out.println("Print lineRange: -6,5-1,10-13,$,^,-, 5-7 , 2 - 4");
        for(String s : result1)
		{
            System.out.println(s);
        }
		System.out.println();
		
        String[] result2 = loadFile("text.txt","^-$,7,7,7,-$");
        System.out.println("Print lineRange: ^-$,7,7,7,-$");
		for(String t : result2)
		{
            System.out.println(t);
        }
		System.out.println();
		
		// for unexisting file 1.txt
        String[] result4 = loadFile("1.txt","^-$");
		System.out.println();
    }

/*****************************readFile()***********************************/	
    public static void readFile(String fname)
	
	
	
	
	{
		File f = new File(fname);
		try
		{
			Scanner sc = new Scanner(new File(fname)); //Opening file to read
			while(sc.hasNext())
			{
				fileLines.add(sc.nextLine()); //Reading all lines
			}
			sc.close();
		}
		catch (IOException e)
		{
			if (!f.exists())
			{
			 System.err.println("File " + fname + " doesn't exist.");
      	     System.exit(1);
			}
			else if (!f.canRead())
			{
				System.err.println("File " + fname + " doesn't have "
				   					 + "permission for reading");
				System.exit(1);
			}
			else
				e.printStackTrace();
		}
	}
	
/*****************************loadFile()***********************************/	
    public static String[] loadFile(String fname,String lineRange)
	{
        resultLines = new ArrayList<String>();
		readFile(fname);
        String[] parts = lineRange.split(",");
        if(parts.length>0)
		{
            for(int i = 0;i<parts.length;i++)
			{
                parts[i] = parts[i].trim();
				if(parts[i].contains("-"))
				{
                    parseDash(parts[i]);
                }
				else if(parts[i].equals("^"))
				{
                    resultLines.add(fileLines.get(0));
                }
				else if(parts[i].equals("$"))
				{
				    resultLines.add(fileLines.get(fileLines.size()-1));
					
					
					
					
                }
				else 
				{
                    resultLines.add(fileLines.get(Integer.parseInt(parts[i])-1));
                }
            }
        }
		String[] result = new String[resultLines.size()];	
		resultLines.toArray(result);
        return result;
    }

/*****************************parseDash()***********************************/	
    public static void parseDash(String lineRange)
	{
        String start;
		String end;
        int startIndex;
		int endIndex;
        String[] indexs = lineRange.split("-");
        if(indexs.length>0)
		{
            start = indexs[0].trim();
            end = indexs[1].trim();
            if(start.isEmpty())
			{
                startIndex = 0;
            }
			else 
			{
                if(start.equals("^"))
                    startIndex = 0;
                else
				{ 
 				    startIndex = Integer.parseInt(start)-1;
				}
            }
			if(end.isEmpty())
			{
				endIndex = fileLines.size()-1;
			}
			else
			{    
				if(end.equals("$"))
               	 	endIndex = fileLines.size()-1;
            	else
				{ 
                	endIndex = Integer.parseInt(end)-1;	
				}
			}
			
			
			
			
        }
		else 
		{
            startIndex = 0;
            endIndex = fileLines.size()-1;
        }
        if(endIndex < startIndex)
		{
            for(int i = startIndex; i >= endIndex; i--)
			{
                resultLines.add(fileLines.get(i));
            }
        }
		else 
		{
            for(int i = startIndex; i <= endIndex; i++)
			{
                resultLines.add(fileLines.get(i));
            }
        }
    }
}
