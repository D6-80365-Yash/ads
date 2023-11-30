package q1SinglyLinearLinkedList;

import java.util.Scanner;

public class TesterLinkedList {
   
	public static int menu()
    {   Scanner sc=new Scanner(System.in);
    	int choice;
    	System.out.println("1-addfirst");
    	System.out.println("2-display");
    	System.out.println("3-addlast");
    	System.out.println("4-add at postion");
    	System.out.println("5-delete first element");
    	System.out.println("6-delete last element");
    	System.out.println("7-delete at posion");
    	System.out.println("Enter choice");
    	choice=sc.nextInt();
    	return choice;
    }
	public static void main(String[] args) 
	{
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
		case 3:
			System.out.println("enter element");
			 ele=sc.nextInt();
			st.addLast(ele);
			break;
		case 4:
			System.out.println("enter element");
			ele=sc.nextInt();
			System.out.println("enter position");
			int position=sc.nextInt();
			st.addAtPosition(ele, position);
			break;
		case 5:
			st.deleteFirst();
			break;
		case 6:
	        st.deleteLast();
	        break;
		case 7:
			System.out.println("enter position");
			 position=sc.nextInt();
			st.deleteAtPosition(position);
		default:
			break;
		}	
		}
	}

}
