package singly_cirularLinked_list;

import java.util.Scanner;



public class TestetingcircularLinkedList {

	
	public static int menu()
    {   Scanner sc=new Scanner(System.in);
    	int choice;
    	System.out.println("1-addfirst");
    	System.out.println("2-display");
    	
    	System.out.println("Enter choice");
    	choice=sc.nextInt();
    	return choice;
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice;
	    List st=new List();
		while((choice=menu())!=0)
		{
		  switch (choice) {
		case 1:
			
			System.out.println("enter element");
			int ele=sc.nextInt();
			st.addFirst(ele);
            break;
		case 2:
			st.display();
			break;
	     }

         }
	}
}