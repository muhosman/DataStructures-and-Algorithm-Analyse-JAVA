package com.Osman;

/**Branch Employee control panel.
 * @author osman
 *
 */
public class BranchEmployeePanel {

	private DataControl data;
	private PrintData printdata;
	private ValidateInput validateInput;
	private int BranchID;

	/** Constructor
	 * @param data data
	 * @param printdata print data
	 * @param validateInput validate Input
	 * @param BranchID Branch ID
	 */
	public BranchEmployeePanel(DataControl data,PrintData printdata,ValidateInput validateInput,int BranchID)
	{
		this.data = data;
		this.printdata = printdata;
		this.validateInput = validateInput;
		this.BranchID = BranchID;
	}
	
	
	/**Branch employe control menu.
	 * @param select select
	 */
	public void choice(int select)
	{
		switch(select)
		{
			case 1:
				addProductStock();
			break;
			case 2:
				removeProductStock();
			break;
			case 3:
				printStockINF();
			break;
			case 4:
				confirmSale();
			break;
			case 5:
				ordersOfCustomer();
			break;
		}
	}
	
	public int getBranchID() {
		return BranchID;
	}


	public void setBranchID(int branchID) {
		BranchID = branchID;
	}
	
	/**To ıncrease the product stock.
	 * 
	 */
	public void addProductStock()
	{
		int stock;
		String name;
		
    	System.out.printf("Enter Stock For Add:");
    	stock = GetInputFromUser.getINT();
    	System.out.printf("Product Name:");
    	name = GetInputFromUser.getSTRING();
    	if(validateInput.controlProductName(BranchID,name) )
    	{
    		data.addProductStock(BranchID,stock,name);
    	}
    	else
    		System.out.println("Product name is false ! !");
	}
	
	/**To decrease the product stock.
	 * 
	 */
	public void removeProductStock()
	{
		int stock;
		String name;
		
    	System.out.printf("Enter Stock For Remove:");
    	stock = GetInputFromUser.getINT();
    	System.out.printf("Product Name:");
    	name = GetInputFromUser.getSTRING();
    	if(validateInput.controlProductName(BranchID,name) )
    	{
    		if(validateInput.controlProductStock(BranchID, name, stock))
    			data.removeProductStock(BranchID,stock,name);
    		else
    			System.out.printf("You don't have %d stock in this product ! !\n",stock);
    	}
    	else
    		System.out.println("Product name is false ! !");
	}
	
	
	/**To print all stock information.
	 * 
	 */
	public void printStockINF()
	{
		printdata.printBranchStockInf(BranchID);
	}
	
	/**To confirm customer order.If the stock is needed,this function will confirm order.
	 * 
	 */
	public void confirmSale()
	{
		int customerNumber=0;
		int saleID=0;
		
		printdata.printCustomerNumbersInBranch(BranchID);
    	System.out.printf("Customer Number:");
    	customerNumber = GetInputFromUser.getINT();
    	
    	if(validateInput.controlCustomerNumberInBranch(customerNumber,BranchID))
    	{
        	printdata.printSales(customerNumber);
        	System.out.printf("Sale ID:");
        	saleID = GetInputFromUser.getINT();
        	
        	if(validateInput.controlSaleIDinBranch(customerNumber,saleID,BranchID))
        	{ 
            	data.confirmSale(customerNumber, saleID);
        	}
        	else
        		System.out.println("False sale ID ! ! !");
    	}
    	else
    		System.out.println("False customer number ! ! !");
	}

	
	/**To print customer orders.
	 * 
	 */
	public void ordersOfCustomer()
	{
		int customerNumber=0;

		printdata.printCustomerNumbersInBranch(BranchID);
    	System.out.printf("Customer Number:");
    	customerNumber = GetInputFromUser.getINT();
    	
    	if(validateInput.controlCustomerNumberInBranch(customerNumber,BranchID))
    	{
        	printdata.printSales(customerNumber);
    	}
    	else
    		System.out.println("False customer number ! ! !");
	}

	
}

