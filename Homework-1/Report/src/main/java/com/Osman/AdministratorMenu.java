package com.Osman;

/**It just print Administrator menu.
 * @author osman
 *
 */
public class AdministratorMenu implements Menu {
	
	public void userInterface(){
		
		for(int i=0;i<40;++i)
			System.out.printf("-");
		System.out.println();
		for(int i=0;i<11;++i)
			System.out.printf("-");
		System.out.printf("Administrator Menu");
		for(int i=29;i<40;++i)
			System.out.printf("-");
		
		System.out.println();
		System.out.println("1.Adding branche");
		System.out.println("2.See All Branches");
		System.out.println("3.Removing branches");
		System.out.println("4.Adding branche employee");
		System.out.println("5.See All branche employees");
		System.out.println("6.Removing branche employees");
		System.out.println("7.You can also query whether there are any products that need to be supplied !");
		System.out.println("8.Exit");

		for(int i=0;i<40;++i)
			System.out.printf("-");
		System.out.println();		
		for(int i=0;i<40;++i)
			System.out.printf("-");
				
	}
}
