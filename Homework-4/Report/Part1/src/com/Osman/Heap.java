package com.Osman;

import java.util.ArrayList;
import java.util.Iterator;

public class Heap<E extends Comparable<E>> {
	
	private ArrayList<E> Nodes = new ArrayList<E>();
	
	/*
	 * Getters of Element
	 * @parameter i
	 * @return element
	 */
	public E getElement(int i)
	{
		return Nodes.get(i);
	}
	/*
	 * Getters of size
	 * @return size
	 */
	public int getSize()
	{
		return Nodes.size(); 
	}
	
	/*
	 * It will delete root element.
	 */
    public int deleteRoot() throws IllegalAccessException
    {  
    	if(Nodes.size() != 0)
    	{
        	Nodes.set(0, Nodes.get(Nodes.size()-1));
            Nodes.remove(Nodes.size()-1);
    	}
    	else
		     throw new IllegalAccessException("No Element");

  
        heapDeleteSort(0);
        
        return 0;
    }
	/*
	 * It will sort all of the heap when the root is deleted.
	 * @parameter parent Parent index
	 */
    private void heapDeleteSort(int parent)
    {
        int largest = parent;
        int left = 2 * parent + 1;
        int right = 2 * parent + 2; 
  
        if (left < Nodes.size() && Nodes.get(left).compareTo(Nodes.get(largest)) > 0 )
            largest = left;
  
        if (right < Nodes.size() && Nodes.get(right).compareTo(Nodes.get(largest)) > 0 )
            largest = right;
  
        if (largest != parent) {
        	E temp = Nodes.get(parent);
            Nodes.set(parent, Nodes.get(largest));
            Nodes.set(largest, temp);
  
            heapDeleteSort(largest);
        }
    }
  

    /*
     * It will add i in heap
     * @parameter i 
     */
	 public void insertNode(E i) throws IllegalAccessException
	 {
		 if(!SearchElement(i))
		 {
			  	Nodes.add(i);
			  	heapInsertSort(Nodes.size()-1);
		 }
		 else 
		     throw new IllegalAccessException("Same Element");

	 }
	 
    
	 /*
	  * It is a helper function for sorting when the element is inserted.
	  * @parameter i
	  */
	 private void heapInsertSort(int i)
	 {
	     int parent = (i - 1) / 2;
	   

	     if (Nodes.get(i).compareTo(Nodes.get(parent)) > 0) {
	    	 E temp = Nodes.get(i);
	         Nodes.set(i, Nodes.get(parent));
	         Nodes.set(parent, temp);
	             
	         heapInsertSort(parent);
	     }
	 }
	   
	 /*
	  * It is a helper function for search.
	  * @parameter element
	  */
    private boolean SearchElement(E element)
    {
    	
    	for(int i=0 ; i<Nodes.size(); i++)
    	{
    		if(Nodes.get(i) == element) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    /*
     * It searchs element in the heap.
     * @parameter element
     */
    public void Search(E element)
    {
    	if(SearchElement(element))
    		System.out.println("Element is founded.");
    	else
    		System.out.println("Element is not founded.");

    }
    
    /*
     * It will merge two heap.
     * @parameter New It will take a new heap parameter.
     */
    public void mergeHeap(Heap<E> New)
    {
    	for(int i=0 ; i < New.getSize() ; i++)
    	{
    		try {
				insertNode(New.getElement(i));
			}  	
    		catch (IllegalAccessException e) {
	            System.out.println("Same Element Skipped-"+New.getElement(i));
	        }
    	}
    }
	
    
    public void printList() 
    {
    	for(int i=0; i < Nodes.size() ; i++)
    	{
    		System.out.print(i+"-"+Nodes.get(i)+"  ");
    	}
    }
	
}
