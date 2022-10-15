package com.Osman;

/**Customer menu.
 * @author osman
 *
 */
public class CustomerMenu implements Menu{
	public void userInterface(){
		
		for(int i=0;i<40;++i)
			System.out.printf("-");
		System.out.println();
		for(int i=0;i<11;++i)
			System.out.printf("-");
		System.out.printf("Customer Menu");
		for(int i=29;i<40;++i)
			System.out.printf("-");
		System.out.println("-");

		System.out.println("1.See the list of products");
		System.out.println("2.See which store a product is in");
		System.out.println("3.Shop");
		System.out.println("4.View previous orders");
		System.out.println("5.Exit");

		for(int i=0;i<40;++i)
			System.out.printf("-");
		System.out.println("-");
		for(int i=0;i<40;++i)
			System.out.printf("-");
	}
}
