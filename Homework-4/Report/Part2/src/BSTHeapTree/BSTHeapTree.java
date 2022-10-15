package BSTHeapTree;
import java.util.Random;

public class BSTHeapTree {
		
	public static void driverFunction() throws IllegalAccessException
	{


	    Random rand = new Random();

		HeapTree<Integer> NewSecondTree = new HeapTree<Integer>();
		HeapTree<Integer> NewTree = new HeapTree<Integer>();

		
		for(int i=0; i<3000 ; i++)
		{
	        int randN = rand.nextInt(100);
			NewSecondTree.add(randN);
		}
		
		try {
			System.out.println("Mod Number"+NewSecondTree.find_mod()+"  "+"Mod NumberOfOcurrence-"+NewSecondTree.getNumberOfOcurrences() );
		}
		catch(IllegalAccessException e) {
            System.out.println("There are not any element in this heap.");
		}
		
		System.out.println();
		System.out.println();

		NewTree.add(16);
		NewTree.add(17);
		NewTree.add(125);
		NewTree.add(122);
		NewTree.add(1000);
		NewTree.add(102);
		NewTree.add(109);
		NewTree.add(11);
		NewTree.add(1);
		NewTree.add(5);
		NewTree.add(102);
		NewTree.add(109);
		NewTree.add(11);
		NewTree.add(1000);
		
		NewTree.add(1100);
		NewTree.add(1200);
		NewTree.add(500);
		NewTree.add(105);
		NewTree.add(107);
		NewTree.add(1100);
		NewTree.add(1040);

		NewTree.add(122);
		NewTree.add(122);
		NewTree.add(122);

		NewTree.add(10);

		NewTree.add(1);
		NewTree.add(5);

		try {
			NewTree.remove(500);
			NewTree.remove(125);
			NewTree.remove(1000);
			NewTree.remove(1000);

		}
		catch(IllegalAccessException e) {
            System.out.println("There are not any element in this heap.");
		}
		
		NewTree.add(5000);
		
		System.out.println("--HeapTree--");
		NewTree.travelPrint();
		System.out.println();

		try {
			System.out.println("Mod Number-"+NewTree.find_mod());
		}
		catch(IllegalAccessException e) {
            System.out.println("There are not any element in this heap.");
		}
		
		System.out.println("If element is founded it will print numberofocurrence otherwise it will print -1 : "+NewTree.find(1100));
		System.out.println("If element is founded it will print numberofocurrence otherwise it will print -1 : "+NewTree.find(11));
		System.out.println("If element is founded it will print numberofocurrence otherwise it will print -1 : "+NewTree.find(1040));
		System.out.println("If element is founded it will print numberofocurrence otherwise it will print -1 : "+NewTree.find(122));


	}
	
	public static void main(String[] args) throws IllegalAccessException
	{
		driverFunction();
	}
}
