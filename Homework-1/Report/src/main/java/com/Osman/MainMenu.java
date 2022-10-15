package com.Osman;


/**Main menu.
 * @author osman
 *
 */
public class MainMenu implements Menu {
	public void userInterface(){
		
		for(int i=0;i<40;++i)
			System.out.printf("-");
		System.out.printf("\n");
		for(int i=0;i<11;++i)
			System.out.printf("-");
		System.out.printf("Welcome To Our Store");
		for(int i=29;i<38;++i)
			System.out.printf("-");
		System.out.printf("\n");

		System.out.println("1.Administrator");
		System.out.println("2.Branch Employee");
		System.out.println("3.Customer");
		System.out.println("4.Make Account");
		System.out.println("5.Exit");

		for(int i=0;i<40;++i)
			System.out.printf("-");
		System.out.printf("\n");
		for(int i=0;i<40;++i)
			System.out.printf("-");
		
		
	}
}
