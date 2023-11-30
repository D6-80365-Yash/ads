package q1SinglyLinearLinkedList;

public class List {
    
	static class Node
	{
		private int data;
		private Node next;
	public Node(int value)
	{
		data=value;
		next=null;
	}
	
	}
	 private Node head;
	public List()
	{
	  head=null;	
	}
	public boolean isempty()
	{
		return head==null;
	}
	
	public void addFirst(int value)
	{
	   Node newnode=new Node(value);	
	   if(isempty())
	   {
		   head=newnode;
	   }
	   else
	   {
		   newnode.next=head;
		   head=newnode;
	   }
	}
	public void display()
	{
		Node trav=head;
		System.out.println("List :");
		while(trav!=null)
		{
			System.out.print("->"+trav.data);
			trav=trav.next;
		}
		System.out.println("");
		
	}
	public void addLast(int value)
	{
		Node newnode=new Node(value);
		if(isempty())
		{
		    head=newnode;	
		}
		else {
			Node trav=head;
			while(trav.next!=null)
			{
				trav=trav.next;
			
				
			}
			trav.next=newnode;
		}
	}
	public void addAtPosition(int value,int pos)
	{
		Node newnode=new Node(value);	
		   if(isempty())
		   {
			   head=newnode;
		   }
		 
		   else
		   {   Node trav=head;
			   for(int i=1;i<pos-1&& trav.next!=null;i++)
			   {
				   trav=trav.next;
			   }
			   newnode.next=trav.next;
			   trav.next=newnode;
			   
		   }
	}
	public void deleteFirst()
	{
		if(isempty())
		{
	     return;    
		}
		else
		{
			head=head.next;
		}
	}
	public void deleteLast()
	{
		Node trav=head;
		if(isempty())
		{
			head=null;
		}
		else if(head.next==null)
		{
		 	head=null;
		}
		while(trav.next.next!=null)
		{
			trav=trav.next;
		}
		trav.next=null;
	}
	public void deleteAtPosition(int pos)
	{
		if(isempty())
		{
			return;
		}
		else if(pos <= 1)
			deleteFirst();
		else
		{
			
			Node trav=head;
			for(int i=1;i<pos-1&&head.next!=null;i++)
			{
				trav=trav.next;
			}
			trav.next=trav.next.next;
		}
	}
}
