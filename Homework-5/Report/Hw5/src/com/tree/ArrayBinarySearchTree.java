package com.tree;

import java.util.Arrays;

public class ArrayBinarySearchTree<E extends Comparable<E>> implements SearchTree<E>{

	private class Array<E> {
		private E[] arr;
		private int capacity;
		
		/**
		 * Array of capacity will be 10 at first implementation.
		 */
		public Array() {
			this.capacity = 10;
			this.arr = (E[]) new Object[this.capacity];
		}
		
		/**
		 * Return size of array.
		 * @return
		 */
		public int getSize() {
			return this.capacity;
		}
		
		/**
		 * Return the element at specific index.
		 * @param index
		 * @return
		 */
		public E get(int index) {
			if(index >= this.capacity) {
				return null;
			}
			return arr[index];
		}
		/**
		 * Control array capacity after that put the element to the index size of array.
		 * @param element
		 */
		public void put(E element,int index) {
			if(index >= this.capacity)
			{
				capacityControl(index);
			}
			arr[index] = element;
		}
		/**
		 * Set the element at specific index.
		 * @param element
		 * @param index
		 */
		public void set(E element,int index) {
			if(index >= this.capacity) {
				throw new ArrayIndexOutOfBoundsException(index);
			}
			arr[index] = element;
		}
		
		/**
		 * Makes the array capacity double and copy the element of array
		 * to new capacity array if already size is bigger than capacity.
		 * @param size
		 */
		private void capacityControl(int size) {
			if(size >= this.capacity) {
				this.capacity = this.capacity*2;
				this.arr = Arrays.copyOf(this.arr,this.capacity);
				capacityControl(size);
			}
		}
	}

	private Array<E> nodes;
	private boolean addReturn;
	
	/**
	 * Constructor
	 */
	public ArrayBinarySearchTree() {
		super();
		this.nodes = new Array<E>();
	}

	
	@Override
	public boolean add(E item) {
		add(0,item);
		return addReturn;
	}
	
	/**
	 * This is a helper function for adding that is given item to blank leaf. 
	 * It is comparing every item with the leaf node and put this item right position that
	 * is order of binary search tree. Every leaf is a member of array so function detect the index
	 * of leaf node with formula is (2*parent)+1.
	 * @param index
	 * @param item
	 */
	private void add(int index,E item) {
	    if (nodes.get(index) == null) {
	    	nodes.put(item, index);
	    	addReturn = true;
	    } 
	    else if (nodes.get(index).compareTo(item) == 0) { // item is already there
	    	addReturn = false;
	    } 
	    else if (nodes.get(index).compareTo(item) < 0) { // right leaf
	    	add((2*index)+2, item);
	    }
	    else {	// left leaf
	    	add((2*index)+1, item);
	    }
	}
	
	@Override
	/** Starter method contains.
	* @param target The Comparable object being sought 
	* @return The object, if found, otherwise null
	*/
	public boolean contains(E target) {
		if(find(0,target) == null)
			return false;
		else
			return true;
	}

	@Override
	/** Starter method find.
	* pre: The target object must implement
	* the Comparable interface.
	* @param target The Comparable object being sought 
	* @return The object, if found, otherwise null
	*/
	public E find(E target) {
	    return find(0, target);	
	}

	/** Recursive find method.
	* @param localRoot The local subtree's root 
	* @param target The object being sought 
	* @return The object, if found, otherwise null
	*/
	private E find(int index, E target) {
	    if (nodes.get(index) == null)
	    	return null;
		// Compare the target with the data field at the root. 
	    int compResult = target.compareTo(nodes.get(index));
		if (compResult == 0)
		        return nodes.get(index);
		    else if (compResult < 0)
		        return find((2*index)+1, target);
		else
		        return find((2*index)+2, target);
	}
	
	@Override
	/** Starter method delete.
	* post: The object is not in the tree. 
	* @param target The object to be deleted 
	* @return The object deleted from the tree or null if the object was not in the tree 
	*/
	public E delete(E target) {
	    return  delete(0, target);
	}
	/** Recursive finder of item that wants to delete.
	* post: The item is not in the tree;
	* deleteReturn is equal to the deleted item as it was stored in the tree or null
	* if the item was not found.
	* @param index The index of the current subtree 
	* @param item The item to be deleted
	* @return The modified local root that does not contain the item
	*/
	private E delete(int index, E item) {
	    if (nodes.get(index) == null) {	// item is not in the tree. deleteReturn = null;
	    	return nodes.get(index);
	    }
		// Search for item to delete.
		int compResult = item.compareTo(nodes.get(index));
		
		if (compResult < 0) 
		{	// item is smaller than localRoot.data. 
			return delete((2*index)+1, item);
		} 
		else if (compResult > 0) 
		{	// item is larger than localRoot.data.  
			return delete((2*index)+2, item);
		} 
		else 
		{	// item is at index
			E deletedItem = nodes.get(index);
			reorderofTree(index);
			return deletedItem;
		}
	}
	
	/**
	 * This functin reordering the tree when delete function detects the deleted item.
	 * @param index Reorder position index for item
	 */
	private void reorderofTree(int index) {
	    if (nodes.get(index) != null) {	// item is not in the tree. deleteReturn = null;   
			if(nodes.get((2*index)+1) == null && nodes.get( (2*index)+2 ) == null) {
				nodes.set(null, index);
			}
			else if (nodes.get((2*index)+1) == null) {	// If there is no left child, return right child // which can also be null.
				nodes.set(nodes.get((2*index)+2), index);
				reorderofTree((2*index)+2);
			} 
			else if (nodes.get((2*index)+2) == null) {	// If there is no right child, return left child. 
				nodes.set(nodes.get((2*index)+1), index);
				reorderofTree((2*index)+1);		
			} 
			else 
			{ // Node being deleted has 2 children, replace the data // with inorder predecessor.
				if (nodes.get( ((((2*index)+1)*2)+2) ) == null) 
				{
					// The left child has no right child.
					// Replace the data with the data in the
					// left child.
					nodes.set(nodes.get((2*index)+1), index);
					reorderofTree((2*index)+1);	
				} else 
				{
					// Search for the inorder predecessor (ip) and
					// replace deleted node's data with ip. 
					int position = findLargestChild((2*index)+1); 
					nodes.set(nodes.get(position), index);
					
					if(nodes.get((2*position)+1) != null)
						reorderofTree(position);
					else
						nodes.set(null, position);

				} 
			}
	    }
	}
	
	/**
	 * It finds the largest element in the tree.
	 * @param index Index of leaf that we want to control for largest or not
	 * @return Returns the biggest element position index.
	 */
	private int findLargestChild(int index) {
		if(nodes.get((2*index)+2) == null) {
			return index;
		}
		else
			return findLargestChild((2*index)+2);
	}
	
	@Override
	/** Starter method delete.
	* post: The object is not in the tree. 
	* @param target The object to be deleted 
	* @return The object deleted from the tree or null if the object was not in the tree 
	*/
	public boolean remove(E target) {
		if( null == delete(0, target))
			return false;
		else
			return true;
	}


	/**
	 * Returns the nodes leaf
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder() ;
		
		for(int i=0; i < nodes.getSize() ; i++) {
			str.append("["+nodes.get(i)+"]");
			if(i+1 != nodes.getSize())
				str.append("--");
		}
		return "ArrayBinarySearchTree [ nodes=" + str + " ]";
	}

}
