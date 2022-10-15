package BSTHeapTree;

import java.util.ArrayList;
import java.util.Iterator;

public class Heap <E extends Comparable<E>>{
	
	private class Node<E>{
		
		private E value;
		private int numberOfOcurrences;
		
		/*
		 * Node Constructor
		 * @parameter value Value of node
		 * @parameter numberOfOcurrences Number of value
		 */
		public Node(E value,int numberOfOcurrences) {
			this.value = value;
			this.numberOfOcurrences = numberOfOcurrences;
		}
		/*
		 * Getters of value
		 * @return value
		 */
		public E getValue() {
			return value;
		}
		/*
		 * Setters of value
		 * @parameter value New value
		 */
		public void setValue(E value) {
			this.value = value;
		}
		/*
		 * Getters of NumberOfOcurrences
		 * @return numberOfOcurrences
		 */
		public int getNumberOfOcurrences() {
			return numberOfOcurrences;
		}
		/*
		 * Setters of NumberOfOcurrences
		 * @parameter numberOfOcurrences New numbers of value
		 */
		public void setNumberOfOcurrences(int numberOfOcurrences) {
			this.numberOfOcurrences = numberOfOcurrences;
		}
		
	}
	
	private ArrayList<Node<E>> Nodes = new ArrayList<Node<E>>();
	private int depth;
	
	//private E mod;
	private int modNumberOfOcurrence;
	
	
	public int getModNumberOfOcurrence() {
		return modNumberOfOcurrence;
	}
	public void setModNumberOfOcurrence(int modNumberOfOcurrence) {
		this.modNumberOfOcurrence = modNumberOfOcurrence;
	}
	/*
	 * Getters for value of node
	 * This function provides to reach Nodes' variable. Because we take the heap parameter and 
	 * we he have to use nodes' function but node class is private so we use this in merge function.
	 * @parameter i Index of the node that has the value of the node
	 * @return value
	 */
	public E getElement(int i)
	{
		return Nodes.get(i).getValue();
	}
	/*
	 * Getters for NumberOfOcurrences of node
	 * This function provides to reach Nodes' variable. Because we take the heap parameter and 
	 * we he have to use nodes' function but node class is private so we use this in merge function.
	 * @parameter i  Index of the node that has the NumberOfOcurrences of the node
	 * @return numberOfOcurrences
	 */
	public int getNumberOfOcurrences(int i) {
		return Nodes.get(i).getNumberOfOcurrences();
	}
	/*
	 *Getters of size
	 *@return size 
	 */
	public int getSize()
	{
		return Nodes.size(); 
	}
	
	/*
	 * Getters of Depth
	 * @return depth
	 */
	public int getDepth() {
		return depth;
	}
	/*
	 * Setters of Depth
	 * @parameter depth New depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
    public E find_mod()
    {
    	int temp;
    	E mod;
    	
    	setModNumberOfOcurrence(Nodes.get(0).getNumberOfOcurrences() );
    	//setMod(Nodes.get(0).getValue());
    	mod = Nodes.get(0).getValue();
    	for(int i=1; i<Nodes.size() ; i++)
    	{
    		if(getModNumberOfOcurrence() < Nodes.get(i).getNumberOfOcurrences())
    		{
    	    	setModNumberOfOcurrence(Nodes.get(i).getNumberOfOcurrences() );
    			mod = Nodes.get(i).getValue();
    		}
    	}
    	return mod;
    	
    }
	
	/*
	 * Remove function deletes specific item in the heap
	 * @parameter item Item is value that will delete
	 * @return It will return the numberOfOcurrences item that deleted otherwise it will return -1
	 */
    public int remove(E item)
    {  
    	int temp = SearchElement(item);
    	int parent = (temp-1)/2;
    	//Temp means that there is value or not
    	//If there is not any item, temp will be -1 other wise it will has index of item
    	if(temp != -1)
    	{
    		//If this item number is greater than 1 it will decrease just numberOfOcurrence
    		//Otherwise it will delete spesific item
    		if(Nodes.get(temp).getNumberOfOcurrences() == 1)
    		{

    			//It changes the item that will delete with the last item and delete this item
            	Nodes.set(temp,Nodes.get(Nodes.size()-1));
                Nodes.remove(Nodes.size()-1);
                
                if(Nodes.size() == 0)
                {
                	return 0;
                }
                //If The deleted item is root or greater than the parent item it will sort the heap toward down otherwise sort toward up
                if ( temp == 0 || Nodes.get(parent).getValue().compareTo(Nodes.get(temp).getValue()) > 0 ) 
                {
                	deleteSortDown(temp);  
                }
                 else
                	 deleteSortUp(temp);
                
    		}
    		else
    		{
    			//It decrease numberOfOcurrence
    			Nodes.get(temp).setNumberOfOcurrences(Nodes.get(temp).getNumberOfOcurrences()-1);
    			return Nodes.get(temp).getNumberOfOcurrences();
    		}
    	}
    	else
    		return -1;
        return 0;
    }
    

    /*
     * Sort the heap toward down
     * @parameter i It is the deleted item index
     */
	public void deleteSortDown(int i)
	{
		//left and right child index variable
		int left,right;
		//It will repeat until the last child index
		while((2*i)+1 <= Nodes.size()-1)
		{
			left = (i*2)+1;
			right = (i*2)+2;
			
			if(right <= Nodes.size()-1)
			{
				if( Nodes.get(i).getValue().compareTo(Nodes.get(left).getValue()) > 0 &&
					Nodes.get(i).getValue().compareTo(Nodes.get(right).getValue()) > 0	)
				{
					break;
				}

				else
				{
					if(Nodes.get(left).getValue().compareTo(Nodes.get(right).getValue()) > 0)
					{
						Node<E> temp = Nodes.get(i);
						Nodes.set(i,Nodes.get(left));
						Nodes.set(left, temp);
						
						i = left;
					}
					else
					{
						Node<E> temp = Nodes.get(i);
						Nodes.set(i,Nodes.get(right));
						Nodes.set(right, temp);
						
						i = right;
					}
				}
			}
			else
			{
				if(Nodes.get(i).getValue().compareTo(Nodes.get(left).getValue()) > 0)
				{
					break;
				}
				else
				{
					Node<E> temp = Nodes.get(i);
					Nodes.set(i,Nodes.get(left));
					Nodes.set(left, temp);
					
					i = left;
				}
			}
		}
	}
	
	/*
	 * Swap the value with deleted item index and its parent
	 * @parameter i Deleted item index
	 */
	public void deleteSortUp(int i)
	{
		Node<E> temp = Nodes.get((i-1)/2);
		Nodes.set((i-1)/2,Nodes.get(i));
		Nodes.set(i, temp);
	}
	/*
	 * Add function adds the item to heap.
	 * If this heap is full it will return -1.
	 * Temp means that there is value or not.If there is not any item, temp doesn't have any index.
	 * If the item that will add is already in heap, it will just increase numberOfOcurrences otherwhise it will add this item.
	 * @parameter item Item is value that will add
	 * @return It will return the numberOfOcurrences item that added otherwise it will return -1
	 */
	 public int add(E i)
	 {
		int temp = SearchElement(i);
		Node<E> NewNode = new Node<E>(i,1);
		

		if(temp >= 0) {
			Nodes.get(temp).setNumberOfOcurrences(Nodes.get(temp).getNumberOfOcurrences()+1);
		  	return Nodes.get(temp).getNumberOfOcurrences();
		}
		else if(getDepth() > 2 || Nodes.size() >= 7)
			return -1;
		else {
			Nodes.add(NewNode);
		  	heapInsertSort(Nodes.size()-1);
		  	return Nodes.get(Nodes.size()-1).getNumberOfOcurrences();
		}
	 }
	 
	 /*
     * It will sort heap when the item was added.
     * @parameter i The item is value that will add. 
     */
	 public void heapInsertSort(int i)
	 {
	     int parent = (i - 1) / 2;
	   
	     
	     if (Nodes.get(i).getValue().compareTo(Nodes.get(parent).getValue()) > 0 ) {
	        	 
	        Node<E> temp;
	        temp = Nodes.get(i);
	        Nodes.set(i, Nodes.get(parent));
	        Nodes.set(parent, temp);
	             
	        heapInsertSort(parent);
	     }
	     
	 }


	    public int Search(E element)
	    {
	    	int temp = SearchElement(element);
	    	return temp;
	    }
	    
    /*
     * To search the specific item in the heap
     * @parameter element Element is generic variable that will search in heap.
     */
    private int SearchElement(E element)
    {
    	for(int i=0 ; i<Nodes.size(); i++)
    	{
    		if(Nodes.get(i).getValue().compareTo(element) == 0) {
    			return i;
    		}
    	}
    	
    	return -1;
    }

	 /*
	  * Print function.
	  */
   public void printList() 
   {
   	for(int i=0; i < Nodes.size() ; i++)
   	{
   		System.out.print(Nodes.get(i).getValue()+"-"+Nodes.get(i).getNumberOfOcurrences() + " || ");
   	}
   }
   
}
