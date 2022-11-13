package com.gradedproject.groupb5;

class Node
{
	int val;
	Node left, right;

	Node(int item)
	{
		val = item;
		left = right = null;
	}
}
class NoLeftSubTree
{
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;
	static void ConvertBSTtoSkewedTree(Node root,
			int order)
	{
		if(root == null)
		{
			return;
		}
		if(order > 0)
		{
			ConvertBSTtoSkewedTree(root.right, order);
		}
		else
		{
			ConvertBSTtoSkewedTree(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;
		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		if (order > 0)
		{
			ConvertBSTtoSkewedTree(leftNode, order);
		}
		else
		{
			ConvertBSTtoSkewedTree(rightNode, order);
		}
	}

	static void traverseRightSkewedTree(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewedTree(root.right);	
	}
	public static void main (String[] args)
	{
		NoLeftSubTree tree = new NoLeftSubTree();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left =new Node(10);
		tree.node.right.left = new Node(55);

		int order = 0;
		ConvertBSTtoSkewedTree(node, order);
		traverseRightSkewedTree(headNode);
	}
}



