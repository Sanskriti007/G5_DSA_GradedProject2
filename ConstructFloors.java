package com.gradedproject.groupb5;

import java.util.*;



class MyComparator implements Comparator

{

	public int compare(Object obj1,Object obj2)

	{

		Integer i1=(Integer)obj1;

		Integer i2=(Integer)obj2;

		return i2.compareTo(i1);

	}

}

public class ConstructFloors 

{

	public static void main(String[] args)  

	{

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter total number of floors:");
		int n=sc.nextInt();

		int max=n;

		Queue<Integer> queue=new PriorityQueue<Integer>(new MyComparator());

		int disks[]=new int[n];

		for(int i=0;i<n;i++)

		{
			System.out.println("Day:"+(i+1));
			disks[i]=sc.nextInt();

			queue.add(disks[i]);

			while(!queue.isEmpty() && queue.peek()==max)

			{



				System.out.print(queue.poll() + " ");


				max--;

			}

			System.out.println();

		}



		sc.close();
	}



}


