import java.util.*;

/* Author:   Irina Golovko
Date  :   11/12/2017
Homework assignment : extra credit #2
Objective : This is stand-alone java class IPAddress,
which randomly generate IPAddress V4.
We have to implements Comparable interface 
and override CompareTo() method in order to 
sort our container with IPAddresses in driver
program.    
/*****************************************************************/
public class IPAddress implements Comparable<IPAddress>
{
	private String ipAddress;
	private int v1;
	private int v2;
	private int v3;
	private int v4;
	
	IPAddress()
	{
		// iPAdddress V4 starts from 0.0.0.0
		// to 255.255.255.255
		Random rand = new Random();
		v1 = rand.nextInt(256);
		v2 = rand.nextInt(256);
		v3 = rand.nextInt(256);
		v4 = rand.nextInt(256);
		ipAddress= v1 + "." + v2 + "." + v3 + "." + v4;
	}	
/****************getIpAddress()***********************/	
	public String getIpAddress()
	{
		return ipAddress;
	}	
/******************compareTo()*************************/			
	@Override
	public int compareTo(IPAddress o) 
	{
		int comp = 101;
		if(this.v1==o.v1 && this.v2==o.v2 &&
			this.v3==o.v3 && this.v4==o.v4)
			comp = 0;
		else if (this.v1>o.v1 || 
				 this.v1==o.v1 && this.v2>o.v2 ||
				 this.v1==o.v1 && this.v2==o.v2 
				 && this.v3>o.v3 ||	 
				 this.v1==o.v1 && this.v2==o.v2 
				 && this.v3==o.v3 && this.v4>o.v4)			 
			comp = 1;
		
		
		
		
		
		
		else if (this.v1<o.v1 || 
				 this.v1==o.v1 && this.v2<o.v2 ||
				 this.v1==o.v1 && this.v2==o.v2 
				 && this.v3<o.v3 ||
				 this.v1==o.v1 && this.v2==o.v2 
				 && this.v3==o.v3 && this.v4<o.v4)	 
			comp = -1;
		return comp;
	}	
/******************toString()*************************/	
	@Override
	public String toString()
	{
		return ipAddress.toString();
	}
}

