package com.Osman;
import java.util.Random; 


/**Customer control panel.
 * @author osman
 *
 */

public class CustomerPanel {
	private DataControl data;
	private PrintData printdata;
	private ValidateInput validateInput;

	private int customerNumber;
	
	/**Constructor
	 * @param data Control all data.
	 * @param printdata Print All data
	 * @param validateInput Validate user input
	 * @param customerNumber Specisific number for each customer.
	 */
	public CustomerPanel(DataControl data,PrintData printdata,ValidateInput validateInput,int customerNumber)
	{
		this.data = data;
		this.printdata = printdata;
		this.validateInput = validateInput;
		this.customerNumber = customerNumber;
	}
	
	
	/**Customer control panel
	 * @param select
	 */
	public void choice(int select)
	{
		switch(select)
		{
			case 1:
				listOfProducts();
			break;
			case 2:
				searchProduct();
			break;
			case 3:
				shop();
			break;
			case 4:
				viewOrders();
			break;

		}
	}
	
	/**
	 * @return
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	
	/**Search product in branch and takes it's info.
	 * 
	 */
	public void searchProduct()
	{
		String name;
		
    	System.out.printf("Product Name:");
    	name = GetInputFromUser.getSTRING();
    	if(validateInput.controlProductName(name))
    	{
    		if(data.getBranchNumber()==0)
    		{
    			System.out.println("-----------------------");
    			System.out.println("--There Are No Branch--");
    			System.out.println("-----------------------");
    		}
    		else 
    			{
	    			System.out.printf("\n--------------------");
	    			System.out.printf("\n----Product List----");
	    			System.out.printf("\n--------------------\n");
    			}
    		for(int i=0; i<data.getBranchNumber() ;++i) 
    		{
    			System.out.println("Branch ID:"+data.getBranch(i).getBranchID());
    			printdata.printProductInfo(name);
    		}
    	}
    	else
    		System.out.println("Product name is false ! !");
	}
	
	/**It gives information about products in specific BranchID.
	 * 
	 */
	public void listOfProducts()
	{
		int BranchID;
		System.out.printf("\n-------------------");
		System.out.printf("\n----Branch List----");
		System.out.printf("\n-------------------\n");

		if(printdata.Branch())
		{
	    	System.out.printf("BranchID:");
	    	BranchID = GetInputFromUser.getINT();
	    	if(validateInput.controlBranchID(BranchID))
	    	{
	    		for(int i=0; i<data.getBranchNumber() ;++i) 
	    		{
	    			if(data.getBranch(i).getBranchID() == BranchID)
	    			{
	    				printdata.printProductsInfo(i);
	    				break;
	    			}
	    		}
	    	}
	    	else
	    		System.out.println("Branch is false ! !");
		}

	}
	
	/**Customer can buy any product.
	 * 
	 */
	public void shop() 
	{
		String name;
		int BranchID=0;
		int model;
		int colour;
		int saleID=0;
		Random rand = new Random(); 

		
		do {
			System.out.printf("\n-------------------");
			System.out.printf("\n----Branch List----");
			System.out.printf("\n-------------------\n");
			if(printdata.Branch())
			{
				System.out.printf("Enter BranchID or 0 and exit:");
		    	BranchID = GetInputFromUser.getINT();
		    	if(validateInput.controlBranchID(BranchID))
		    	{
		    		for(int i=0; i<data.getBranchNumber() ;++i) 
		    		{
		    			if(data.getBranch(i).getBranchID() == BranchID)
		    			{
		    				do {
		    	    			System.out.printf("\n--------------------");
		    	    			System.out.printf("\n----Product List----");
		    	    			System.out.printf("\n--------------------\n");
			    				printdata.printProductsInfo(i);
			    				
			    		    	System.out.printf("Enter Product Name or 0 and exit:");
			    		    	name = GetInputFromUser.getSTRING();
			    		    	if(validateInput.controlProductName(BranchID,name))
			    		    	{
			    		    		do {
				    		    		printdata.printProductInfo(name);
				    			    	System.out.printf("Enter Model Choice or 0 and exit:");
				    			    	model = GetInputFromUser.getINT();
				    			    	if(model != 0)
				    			    	{
				    			    		if(data.getColourNumber(BranchID, name) != 0)
				    			    		{
						    			    	System.out.printf("Enter Colour Choice or 0 and exit:");
						    			    	colour = GetInputFromUser.getINT();
						    			    	if(validateInput.controlColourandModel(colour, model, name))
						    			    	{
						    			    		saleID = rand.nextInt(1000);
						    			    		data.addSale(customerNumber,saleID, colour, model, BranchID, name);
						    			    		break;
						    			    	}
						    			    	else if(colour != 0)
						    			    		System.out.println("Colour or model name is false ! !");
				    			    		}
				    			    		else {
				    			    			saleID = rand.nextInt(1000);
				    			    			data.addSale(customerNumber,saleID, 0, model, BranchID, name);
					    			    		break;
				    			    		}
				    			    	}

			    		    		}while(model == 0);
			    		    	}
			    		    	else if(!name.equals("0"))
			    		    		System.out.println("Product name is false ! !");
		    				}while(name.equals("0"));
		    				break;
		    			}
		    		}
		    	}
		    	else if(BranchID != 0)
		    		System.out.println("Branch ID is false ! !");
			}
		}while(BranchID != 0);
	}
	
	
	/**Customer can see previous orders.
	 * 
	 */
	public void viewOrders()
	{
		printdata.printSales(customerNumber);
	}
	
	
	/**Make a new acounte for customer.
	 * 
	 */
	public void makeCustomerAccount()
	{
		Random rand = new Random(); 

    	int ID;
    	String firstName;
    	String lastName;
    	String password;

			System.out.printf("ID:");
			ID = GetInputFromUser.getINT();
			if(validateInput.controlCustomerID(ID))
			{
		        System.out.println("Branch Employee acount has not added Successfully!");
			}
			else
			{
		    	System.out.printf("First Name:");
		    	firstName = GetInputFromUser.getSTRING();
		    	System.out.printf("Last Name:");
		    	lastName = GetInputFromUser.getSTRING();
		    	System.out.printf("Password:");
		    	password = GetInputFromUser.getSTRING();
		    	customerNumber = rand.nextInt(1000);
		    	System.out.printf("Customer Number-%d\n",customerNumber);
		    	
		    	if(!validateInput.controlCustomerNumber(customerNumber))
		    	{
			        data.addCustomer(customerNumber,ID,firstName,lastName,password);
			        System.out.println("Customer acount has added Successfully!");
		    	}
		    	else
			        System.out.println("Customer acount has not added Successfully!");


			}
	
	}
	
}
