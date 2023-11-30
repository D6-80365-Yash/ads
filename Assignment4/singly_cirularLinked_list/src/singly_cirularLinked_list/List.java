package singly_cirularLinked_list;



public class List {
  static class Node{
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
	   Node newnode= new Node(value);
	   if(isempty())
	   {
		head=newnode;   
		
	   }
	   else {
	   newnode.next=head;
	   head=newnode;
	   }
   }
   public void display()
   {
	   if(isempty())
	   {
		   return;
	   }
	   else
	   {
		   Node trav=head;
		  
			do
		   {
			   System.out.print(trav.data+"->");
			   trav=trav.next;
		   }
		   while(trav!=head);
			   
		   System.out.println("");
	   }
	   
   }
}
