package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	
	class Node{
		int key;
		Node left,right;
		Node(){
			key=0;
			left=right=null;
		}
		Node(int item){
			key=item;
			left=right=null;
		}
	}
	Node root;
	
	BST()
	{
		root=null;
	}
	BST(int value){
		root=new Node(value);
	}
	void insert(int key) {
		root=insertRec(root,key);
	}
	
	Node insertRec(Node root,int key) {
		if(root==null)
		{
			root=new Node(key);
			return root;
		}
		else if(key < root.key) {
			root.left=insertRec(root.left,key);
		}
		else if(key>root.key) {
			root.right=insertRec(root.right,key);
		}
		
		return root;
	}
	
	static void levelOrder(Node root) {
	    if (root == null)
	      return;
	 
	    Queue<Node> q = new LinkedList<>();
	 
	    q.add(root);
	 
	    q.add(null);
	 
	    while (!q.isEmpty()) {

	      Node curr = q.poll();

	      if (curr == null) {
	        if (!q.isEmpty()) {
	          q.add(null);
	          System.out.println();
	        }
	      } else {
	        if (curr.left != null)
	          q.add(curr.left);
	 
	        if (curr.right != null)
	          q.add(curr.right);
	 
	        System.out.print("-->"+curr.key + " ");
	      }
	    }
	  }
	public Node[] binarySearchWithParent(int key) {
		Node trav = root;
		Node parent = null;
		while(trav != null) {
			if(key == trav.key)
				break;
			parent = trav;
			if(key < trav.key)
				trav = trav.left;
			else
				trav = trav.right;
		} 
		if(trav == null)
			parent = null;
		return new Node[]{trav, parent};
	}
	public void DeleteNode(int key) {
		Node[] arr=binarySearchWithParent(key);
		Node temp=arr[0];
		Node parent=arr[1];
		
		if(temp==null) {
			System.out.println("Key Not Found.");
			return;
		}
		
		if(temp.left!=null && temp.right!=null) {
			Node successor=temp.right;
			parent=temp;
			while(successor.left!=null) {
				parent =successor;
				successor=successor.left;
				
			}
			temp.key=successor.key;
			temp=successor;
		}
		if(temp.right==null) {
			if(temp==root) {
				root=temp.left;
			}
			else if(temp==parent.left) {
				parent.left=temp.left;
			}
			else
			{
				parent.right=temp.left;
			}
		}
		else
		{
			if(temp==root) {
				root=temp.right;
			}
			else if(temp==parent.left) {
				parent.left=temp.right;
			}
			else
			{
				parent.right=temp.right;
			}
		}
	}
	
	static void inorder(Node root) {
		if(root!=null) {
			 inorder(root.left);
			 System.out.print(root.key+" ");
			 inorder(root.right);
			
		}
	}
	
 public int countLeaf(Node root) {
	 if(root ==null) {
		 return 0;
	 }
	 
	  if (root.left == null && root.right == null)
          return 1;
      else
          return countLeaf(root.left) + countLeaf(root.right);
	 
 }
 
 static int totalNodes(Node root)
 {
     if (root == null)
         return 0;
  
     int l = totalNodes(root.left);
     int r = totalNodes(root.right);
  
     return 1 + l + r;
 }
 
 public int depth(Node root,int key) {
	 if(root==null) {
		 return 0;
	 }
	 int d=1;
	 while(root!=null) {
		 if(root.key==key)
			 return d;
		 else
			 if(key<root.key)
			 {
			 root=root.left;
			 d++;
			 }
			 else if(key>root.key) {
				 root=root.right;
				 d++;
			 }
		 
	 }
	 if(root==null)return 0;

	return d;
 }
 
 public int printParent(int key) {
	 Node[] arr=binarySearchWithParent(key);
	 Node parent=arr[1];
	 if(parent==null)
	 {
		 System.out.println("Element Not Found");
		 return -1;
	 }
	 return parent.key;
 }
 
 public Node printChildren(int key) {
	 Node[] arr=binarySearchWithParent(key);
	 Node Children=arr[0];
	 if(Children==null)
	 {
		 System.out.println("Element Not Found");
		 return null;
	 }
	 
	 
	 return Children;
 }
 public void displaySibling(Node root) {
	 if(root==null) {
		 System.out.println("NULL!!");
		 return;
	 }
	 if(root.left==null && root.right==null) {
		 return;
	 }
	 
	 if(root.left!=null && root.right!=null) {
		 System.out.println("("+root.left.key+" , "+root.right.key+")"+" , ");
		 displaySibling(root.left);
		 displaySibling(root.right);
	 }
	 else if(root.left!=null)
		 displaySibling(root.left);
	 else {
		 displaySibling(root.right);
	 }
 }

	public static void main(String[] args) {
		BST tree=new BST();
		tree.insert(50);
		tree.insert(30);
		tree.insert(34);
		tree.insert(90);
		tree.insert(10);
		tree.insert(20);
		
		tree.inorder(tree.root);
		System.out.println();
		System.out.println();

		
		System.out.println("Siblings :");
	tree.displaySibling(tree.root);
	
	
	
	

	
		
		
		
	}
}