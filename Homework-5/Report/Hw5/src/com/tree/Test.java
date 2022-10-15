package com.tree;

public class Test {

	public static void main(String[] args) {
		ArrayBinarySearchTree<Integer> tree = new ArrayBinarySearchTree<Integer>();
		
		
		
		try {
			tree.add(10);
			tree.add(20);
			tree.add(5);
			tree.add(3);
			tree.add(8);
			tree.add(2);
			tree.add(4);
			tree.add(13);

			System.out.println(tree.toString());
			System.out.println("Contains 5 ?:"+tree.contains(5));
			System.out.println("Contains 15 ?:"+tree.contains(15));
			System.out.println("Find:"+tree.find(4));
			System.out.println("Find:"+tree.find(21));
						
			System.out.println("Deleting... "+tree.delete(10));
			System.out.println("Deleted 10:"+tree.toString());

			System.out.println("Deleting... "+tree.delete(3));
			System.out.println("Deleted 3:"+tree.toString());
			
			System.out.println("Removing... "+tree.remove(20));
			System.out.println("Removed 20:"+tree.toString());

			
			System.out.println("Deleting... "+tree.delete(20));
			System.out.println("Deleted 3:"+tree.toString());

		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
