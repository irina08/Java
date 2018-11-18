import java.util.*;

/* Author:   Irina Golovko
Date  :   11/12/2017
Homework assignment : extra credit #2
Objective : This is Driver program for IPAddress class.
We have to create array consists of 1000 unique and 
sorted IPAddresses. Then we have to print first 10 IPAddresses
and last 10 IPAddresses.     
/*****************************************************************/

public class IPAddressDriver
{
	public static void main(String[] args)
	{	
		SortedSet<IPAddress> set = new TreeSet<IPAddress>();
		while(set.size() !=1000)
		{
			IPAddress ip = new IPAddress();
			set.add(ip);
		}
		
		IPAddress[] arrayIpAddresses = set.toArray(new IPAddress[set.size()]);
		System.out.println("Print first 10 IPAddresses:");
		for (int i = 0; i < 10; i++)
			System.out.println(arrayIpAddresses[i]);
		System.out.println("***********************************");
		System.out.println("Print last 10 IPAddresses:");
		for (int i = set.size() - 10; i < set.size(); i++)
			System.out.println(arrayIpAddresses[i]);
		System.out.println("***********************************");
	}
}