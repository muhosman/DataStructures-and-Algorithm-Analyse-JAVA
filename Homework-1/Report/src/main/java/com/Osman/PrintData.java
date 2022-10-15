package com.Osman;

/**Prints all data
 * @author osman
 *
 */
public class PrintData {
	
	DataControl data;
	
	/**Constructor
	 * @param data data
	 */
	public PrintData(DataControl data)
	{
		this.data = data;
	}
	
	/**To control if there is a branch and if there are a branch,it prints 
	 * @return boolean boolean
	 */
	public boolean Branch()
	{
		int flag = 1;
		for(int i=0; i<data.getBranchNumber();++i)
		{
			flag = 0;
			System.out.println(data.getBranch(i));
		}
		if(flag == 1)
		{			
			System.out.println("-----------------------");
			System.out.println("--There Are No Branch--");
			System.out.println("-----------------------");
			return false;
		}
		return true;
	}
	
	/**Prints branch employee information.
	 * 
	 */
	public void BranchEmployee()
	{
		int flag = 1;
		for(int i=0; i<data.getBranchEmployeeNumber();++i)
		{
			flag=0;
			System.out.println(data.getBranchEmployee(i));
		}
		if(flag == 1)
		{
			System.out.println("--------------------------------");
			System.out.println("--There Are No Branch Employee--");
			System.out.println("--------------------------------");
		}
	}
	
    /**Print Stock Information
     * 
     */
    public void printNeededStockInf()
    {
		int flag = 1;
		for(int i=0; i<data.getBranchNumber();++i)
		{
			flag = 0;
			System.out.printf("BranchID:%d\n",data.getBranch(i).getBranchID());
			data.getBranchProduct(i);
		}
		if(flag == 1)
		{			
			System.out.println("-----------------------");
			System.out.println("--There Are No Branch--");
			System.out.println("-----------------------");
		}

    }
    
    /**To print stock information in this branch id.
     * @param BranchID Branch ID
     */
    public void printBranchStockInf(int BranchID)
    {
		for(int i=0; i<data.getBranchNumber();++i)
		{
			if(data.getBranch(i).getBranchID() == BranchID)
			{
				System.out.printf("BranchID:%d\n",data.getBranch(i).getBranchID());
				data.getBranchProduct(i);
				break;
			}
		}   
    }
    /**To print customer order .
     * @param customerNumber customer Number
     */
    public void printSales(int customerNumber)
    {
    	int flag = 1;
    	for(int i=0;i < data.getCustomerNumber();++i)
    	{
    		if(data.getCustomer(i).getCustomerNumber() == customerNumber)
    		{
    			for(int j = 0; j < data.getCustomer(i).getSaleNumber();++j) {
    				System.out.println(data.getCustomer(i).getSale(j));
    				System.out.println();
    			}
    			flag = 0;

    		}
    	}
    	if (flag == 1)
    	{
    		System.out.println("------------");
    		System.out.println("--No Sales--");
    		System.out.println("------------");
    	}
    }
    /**To print customer numbers in this branch.
     * @param BranchID Branch ID
     */
    public void printCustomerNumbersInBranch(int BranchID)
    {
    	for(int i=0; i<data.getCustomerNumber() ; ++i)
    	{
    		for(int j=0; j<data.getCustomer(i).getSaleNumber() ;++j)
    		{
    			if(data.getCustomer(i).getSale(j).getBranchID() == BranchID)
    			{
    				System.out.println("-"+data.getCustomer(i).getCustomerNumber());
    				break;
    			}
    		}
    	}
    }
    
    /**To print product information
     * @param i i
     */
    public void printProductsInfo(int i)
    {
    	data.getBranch(i).printProductInf();
    }
    public void printProductInfo(String name)
    {

			if( data.getBranch(0).getOfficeChairs().getName().equals(name) )
			{
				System.out.println(data.getBranch(0).getOfficeChairs());
			}
			if( data.getBranch(0).getBookcases().getName().equals(name) )
			{
				System.out.println(data.getBranch(0).getBookcases());
			}
			if( data.getBranch(0).getOfficecabinets().getName().equals(name) )
			{
				System.out.println(data.getBranch(0).getOfficecabinets());
			}
			if( data.getBranch(0).getMeetingTables().getName().equals(name) )
			{
				System.out.println(data.getBranch(0).getMeetingTables());
			}
			if( data.getBranch(0).getOfficeDesk().getName().equals(name) )
			{
				System.out.println(data.getBranch(0).getOfficeDesk());
			}

    }
    
    /**To print all customers' orders
     * @param customerNumber customer Number
     */
    public void printOrders(int customerNumber)
    {
    	for(int i=0; i<data.getCustomerNumber() ; ++i)
    	{
    		if(data.getCustomer(i).getCustomerNumber() == customerNumber)
    		{
    			for(int j=0; j< data.getCustomer(i).getSaleNumber() ;++j)
    				System.out.println(data.getCustomer(i).getSale(j));
    		}
    	}
    	
    }
}
