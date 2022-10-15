package com.Osman;

public class HeapOperation 
{
	public static void TestFunction()
	{
		Heap<Integer> NewHeap = new Heap<Integer>();
		Heap<Integer> NewHeapp = new Heap<Integer>();

        try {
        	System.out.println("--First Heap--");
    		NewHeapp.insertNode(13);
    		NewHeapp.insertNode(10);
    		NewHeapp.insertNode(12);
    		NewHeapp.insertNode(11);

    		
    		NewHeapp.printList();
    		
    		System.out.println();
        	System.out.println("--Second Heap--");

    		NewHeap.insertNode(13);
    		NewHeap.insertNode(17);
    		NewHeap.insertNode(18);
    		NewHeap.insertNode(15);
    		NewHeap.insertNode(19);
    		NewHeap.insertNode(16);

        }
        catch (IllegalAccessException e) {
            System.out.println("You want add elment that already in the heap.");
        }
    		
        try {		
        	
        	NewHeap.deleteRoot();

			NewHeap.printList();
	
			System.out.println();
	
	    	System.out.println("--Merged Heap--");
	
			NewHeap.mergeHeap(NewHeapp);
			
			NewHeap.deleteRoot();
	
			NewHeap.printList();
        }

    		
            catch (IllegalAccessException e) {
                System.out.println("There are not any element like this.");
            }

	}
	public static void main(String[] args) 
	{
		TestFunction();
	}

}
