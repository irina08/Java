
import static MyPackage.MyLib.*;

/**  Author:   Irina Golovko
     Date:     09/17/2017
     Homework assignment: 2
     Objective: This is Demo program which show us
     how the library MyLib.java works.
*/
//****************************************************************

public class DemoMyLib
{
	public static void main(String ... args)
	{
		System.out.println("Sum 3 and 12 = " + add(3, 12));
		System.out.println("Sum(3,10,101,14,18) = " + 
			                add(3, 10, 101, 14,18));
		System.out.println("*********************************");
		
		/* Method add with 1 argument.*/
		//System.out.println("Add with one argument 3 = "); 
		//System.out.println(add(3));
		
		/* Method add without any arguments.*/
		//System.out.println("Add without any arguments = "); 
		//System.out.println(add());
       
		System.out.println("Substract 15 and 10 = " + subt(15, 10));
		System.out.println("Substract (100, 13, 25, 17) = " + 
			                subt(100, 13, 25, 17));
		System.out.println("*********************************");
		
		/* Subtract with one argument.*/
		//System.out.println("Substruct with one argument 10 = ");
		//System.out.println(subt(10));
		
		/* Subtract without any arguments.*/
		//System.out.println("Substruct without argument = ");
		//System.out.println(subt());
		
		System.out.println("Divide 100/2/25 = " + div(100, 2, 25));
		System.out.println("*********************************");
		
		System.out.println("Divide 1000/5/10/1/4/2 = " + 
			                div(1000, 5, 10, 1, 4, 2));
		System.out.println("*********************************");
		
		/* Divide with one argument.*/
		//System.out.println("Divide with one argument 10 = ");
		//System.out.println(div(10));
		
		
		
		
		/* Divide without any arguments.*/
		//System.out.println("Divide without any arguments = ");
		//System.out.println(div());
		
		/* Divide by zero. */
		//System.out.println("Divide 100/10/0 = ");
		//System.out.println(div(100, 10, 0));
		
		System.out.println("Multiple (1,10,9,100) = " + 
			                mult(1, 10, 9, 100));
		System.out.println("*********************************");
		
		System.out.println("Multiple (12, 15) = " + mult(12, 15));
		System.out.println("*********************************");
		
		/* Multiple with one argument. */
		//System.out.println("Multiple with one argument 10 = ");
		//System.out.println(mult(10));
		
		/* Multiple without argument. */
		//System.out.println("Multiple without argument = ");
		//System.out.println(mult());
		
		System.out.println("Print 'banana' with print method: ");
		print("banana");
		System.out.println();
		System.out.println("*********************************");
		
		System.out.println("Print 'banana', 'apple', 'banana' "
			                + "with 'println': ");
		println("banana", "apple", "banana");
	    System.out.println("*********************************");
		
		System.out.println("Print 'cat' with 'println': ");
		println("cat");
		System.out.println("*********************************");
		
		System.out.println("Print with 'println' without parameters: ");
		println();
		System.out.println("*********************************");
		
		System.out.println("Print output of 'die method': ");
		die("Invalid argument");
	}
}