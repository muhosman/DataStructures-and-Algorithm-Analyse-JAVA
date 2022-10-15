package com.Osman;

/**Branch Employee Menu
 * @author osman
 *
 */
public class BranchEmployeeMenu implements Menu{
	public void userInterface(){

		for(int i=0;i<40;++i)
			System.out.printf("-");
		System.out.println();
		for(int i=0;i<11;++i)
			System.out.printf("-");
		System.out.printf("Branch Employee Menu");
		for(int i=29;i<40;++i)
			System.out.printf("-");
		System.out.println();

		System.out.println("1.Adding product stock");
		System.out.println("2.Removing product stock");
		System.out.println("3.Print Stock Info");
		System.out.println("4.Sales Confirmation");
		System.out.println("5.Access the information of the previous orders of a customer");
		System.out.println("6.Exit");
		System.out.println();

		for(int i=0;i<40;++i)
			System.out.printf("-");
		System.out.println();
		for(int i=0;i<40;++i)
			System.out.printf("-");
	}
}
