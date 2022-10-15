package com.Osman;

/**Data control statement.
 * @author osman
 *
 */
public class DataControl {
	
	//It saves all branch.
	private Branch branch [];
	private int branchNumber;
	//It saves all branch employees
	private BranchEmployee branchEmployee [];
	private int branchEmployeeNumber;
	//It saves administrator.
	private Administrator administrator [];
	private int administratorNumber;
	//It saves customer.
	private Customer customer [];
	private int customerNumber;
	
	/**Default constructor
	 * 
	 */
	public DataControl()
	{
		branchNumber=0;
		branchEmployeeNumber=0;
		administratorNumber=0;
	}
	
    /**To add branch with using Branch ID
     * @param BranchID  Branch ID 
     */
    public void addBranch(int BranchID){
    	setBranchNumber(getBranchNumber()+1);
    	Branch brnch = new Branch(BranchID,0);
        Branch temp [] = new Branch[getBranchNumber()];
        
    	for(int i = 0; i < getBranchNumber()-1;++i) {
    		temp[i] = branch[i];

    	}
    	temp[getBranchNumber()-1] = brnch;        
    	branch = temp;
    }
    
    /**To remove branch with using Branch ID
     * @param ID ID
     */
    public void removeBranch(int ID){
    	int select=0;
    	
    	Branch temp [] = new Branch[getBranchNumber()-1];
        
    	for(int i = 0;;++i) 
    	{
    		if(branch[i].getBranchID() == ID)
    		{
    			for(int j=0;j<branch[i].getBranchEmployeeNumber();++j)
    				removeBranchEmployee(branch[i].getBranchEmployeeIDs(j));
    			select = i;
    			break;
    		}
			select = i;

    		temp[i] = branch[i];
    	}
    	for(int i=select; i < getBranchNumber()-1;i++)
    	{
    		temp[i] = branch[i+1];

    	}
    	branch = temp;
    	setBranchNumber(getBranchNumber()-1);
    }
    
    public int getBranchNumber()
    {
    	return branchNumber;
    }
    public void setBranchNumber(int branchNumber)
    {
    	this.branchNumber = branchNumber;
    }
    public Branch getBranch(int i)
    {
    	return branch[i];
    }
    public void getBranchProduct(int i)
    {
    	branch[i].printProductInf();
    }
    public int getColourNumber(int BranchID,String name)
    {
		int select=0;
		for(int i=0; i<getBranchNumber() ;++i) {
			if(getBranch(i).getBranchID() == BranchID)
			{
				select = i;
				break;
			}
		}
		if( getBranch(select).getOfficeChairs().getName().equals(name) )
			return getBranch(select).getOfficeChairs().getColour();
		if( getBranch(select).getBookcases().getName().equals(name) )
			return getBranch(select).getBookcases().getColour();
		if( getBranch(select).getOfficecabinets().getName().equals(name) )
			return getBranch(select).getOfficecabinets().getColour();
		if( getBranch(select).getMeetingTables().getName().equals(name) )
			return getBranch(select).getMeetingTables().getColour();
		if( getBranch(select).getOfficeDesk().getName().equals(name) )
			return getBranch(select).getOfficeDesk().getColour();
		else 
			return 0;
    }
    public int getModelNumber(int BranchID,String name)
    {
		int select=0;
		for(int i=0; i<getBranchNumber() ;++i) {
			if(getBranch(i).getBranchID() == BranchID)
			{
				select = i;
				break;
			}
		}
		if( getBranch(select).getOfficeChairs().getName().equals(name) )
			return getBranch(select).getOfficeChairs().getModel();
		if( getBranch(select).getBookcases().getName().equals(name) )
			return getBranch(select).getBookcases().getModel();
		if( getBranch(select).getOfficecabinets().getName().equals(name) )
			return getBranch(select).getOfficecabinets().getModel();
		if( getBranch(select).getMeetingTables().getName().equals(name) )
			return getBranch(select).getMeetingTables().getModel();
		if( getBranch(select).getOfficeDesk().getName().equals(name) )
			return getBranch(select).getOfficeDesk().getModel();
		else 
			return 0;
    }
    /**To handle Branch Id with using id and password information that belongs to branch employee.
     * @param ID ID
     * @param Password Password
     * @return Branch ID
     */
    public int getBranchIdBelongsToBranchEmployee(int ID,String Password)
    {
		for(int i=0; i<getBranchEmployeeNumber() ;++i) {
			if(getBranchEmployee(i).getId() == ID)
			{
				if(getBranchEmployee(i).getPassword().equals(Password) )
				{
					return getBranchEmployee(i).getBranchID();
				}
			}
		}
		return 0;
    }
    
    /**To add new branch employee.
     * @param BranchID Branch ID
     * @param ID ID
     * @param firstName first Name
     * @param lastName lastName
     * @param Password Password
     */
    public void addBranchEmployee(int BranchID,int ID,String firstName,String lastName,String Password){
    	setBranchEmployeeNumber(getBranchEmployeeNumber()+1);
    	BranchEmployee brnchemp = new BranchEmployee(BranchID,ID,firstName,lastName,Password);
        BranchEmployee temp [] = new BranchEmployee[getBranchEmployeeNumber()];
        
    	for(int i = 0; i < getBranchEmployeeNumber()-1;++i) {
    		temp[i] = branchEmployee[i];

    	}
    	temp[getBranchEmployeeNumber()-1] = brnchemp;        
    	branchEmployee = temp;
    	
    	for(int i=0;i<getBranchNumber();++i)
    	{
    		if(BranchID == getBranch(i).getBranchID())
    		{
    			getBranch(i).setBranchEmployeeNumber(1);
    			getBranch(i).addBranchEmployeeIDs(ID);
    		}
    	}
    	
    }
    
    /**To remove branch employee.
     * @param ID ID
     */
    public void removeBranchEmployee(int ID){
    	int select=0;
    	BranchEmployee temp [] = new BranchEmployee[getBranchEmployeeNumber()-1];
        
    	for(int i = 0;;++i) 
    	{
    		if(branchEmployee[i].getId() == ID)
    		{
    	    	for(int j=0;j<getBranchNumber();++j)
    	    	{
    	    		if(getBranch(j).getBranchID() == branchEmployee[i].getBranchID())
    	    		{
    	    			getBranch(j).setBranchEmployeeNumber(-1);
    	    		}
    	    	}
    			select = i;
    			break;
    		}
			select = i;

    		temp[i] = branchEmployee[i];
    	}
    	for(int i=select; i < getBranchEmployeeNumber()-1;i++)
    	{
    		temp[i] = branchEmployee[i+1];

    	}
    	branchEmployee = temp;
    	setBranchEmployeeNumber(getBranchEmployeeNumber()-1);
    }
    public BranchEmployee getBranchEmployee(int i)
    {
    	return branchEmployee[i];
    }
    public int getBranchEmployeeNumber()
    {
    	return branchEmployeeNumber;
    }
    public void setBranchEmployeeNumber(int branchEmployeeNumber)
    {
    	this.branchEmployeeNumber = branchEmployeeNumber;
    }
    
    
    /**To add administrator.
     * @param ID ID
     * @param firstName  firstName 
     * @param lastName  lastName
     * @param Password Password
     */
    public void addAdministrator(int ID,String firstName,String lastName,String Password){
    	setAdministratorNumber(getAdministratorNumber()+1);
    	Administrator admn = new Administrator(ID,firstName,lastName,Password);
    	Administrator temp [] = new Administrator[getAdministratorNumber()];
        
    	for(int i = 0; i < getAdministratorNumber()-1;++i) {
    		temp[i] = administrator[i];

    	}
    	temp[getAdministratorNumber()-1] = admn;        
    	administrator = temp;
    }
    
    /**To remove administrator.
     * 
     */
    public void removeAdministrator(){
    	int select=0;
    	int ID=0;
    	Administrator temp [] = new Administrator[getAdministratorNumber()-1];
        
    	for(int i = 0;;++i) 
    	{
    		if(administrator[i].getId() == ID)
    		{
    			select = i;
    			break;
    		}
			select = i;

    		temp[i] = administrator[i];
    	}
    	for(int i=select; i < getAdministratorNumber()-1;i++)
    	{
    		temp[i] = administrator[i+1];

    	}
    	administrator = temp;
    	setAdministratorNumber(getAdministratorNumber()-1);
    }
    public Administrator getAdministrator(int i)
    {
    	return administrator[i];
    }
    public int getAdministratorNumber()
    {
    	return administratorNumber;
    }
    public void setAdministratorNumber(int administratorNumber)
    {
    	this.administratorNumber = administratorNumber;
    } 
    
    /**To increase product stock in this branch id.
     * @param BranchID Branch ID
     * @param stock stock
     * @param name name
     */
    public void addProductStock(int BranchID,int stock,String name)
    {
		for(int i=0; i<getBranchNumber() ;++i) {
			if(branch[i].getBranchID() == BranchID)
			{
				branch[i].addStock(stock, name);
				break;
			}
		}
    }
    
    /**To decrease product stock in this branch id.
     * @param BranchID BranchID
     * @param stock stock
     * @param name name
     */
    public void removeProductStock(int BranchID,int stock,String name)
    {
		for(int i=0; i<getBranchNumber() ;++i) {
			if(branch[i].getBranchID() == BranchID)
			{
				branch[i].removeStock(stock,name);
				break;
			}
		}
    }
    
    /**To add customer.
     * @param customerNumber customerNumber
     * @param ID ID
     * @param firstName firstName
     * @param lastName lastName
     * @param Password Password
     */
    public void addCustomer(int customerNumber,int ID,String firstName,String lastName,String Password){
    	setCustomerNumber(getCustomerNumber()+1);
    	Customer cstmr = new Customer(ID,firstName,lastName,Password,0,customerNumber);
        Customer temp [] = new Customer[getCustomerNumber()];
        
    	for(int i = 0; i < getCustomerNumber()-1;++i) {
    		temp[i] = customer[i];
    	}
    	temp[getCustomerNumber()-1] = cstmr;        
    	customer = temp;
    }
    
	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public Customer getCustomer(int i) {
		return customer[i];
	}
	
	/**To add customer order in specified customer number.
	 * @param customerNumber customer Number
	 * @param colour colour
	 * @param model model
	 * @param BranchID Branch ID
	 * @param name name
	 */
	public void addSale(int customerNumber,int saleID,int colour,int model,int BranchID,String name)
	{
		for(int i = 0; i< getCustomerNumber(); ++i)
		{
			if(customer[i].getCustomerNumber() == customerNumber)
			{
				Sale sale = new Sale(saleID,0,BranchID,name,model,colour);
				customer[i].setSaleNumber(1);
				customer[i].addSale(sale);
			}
		}
	}
	
    /**To accept to customer order from branch employee.
     * @param customerNumber customer Number
     * @param saleID sale ID
     */
    public void confirmSale(int customerNumber,int saleID)
    {
    	for(int i=0; i <getCustomerNumber();++i )
    	{
    		if(customer[i].getCustomerNumber() == customerNumber)
    		{
    			for(int j=0;j < customer[i].getSaleNumber();++j)
    			{
    				if(customer[i].getSale(j).getSaleID() == saleID && customer[i].getSale(j).getConfirmation() == 0)
    				{
    					if(controlProductStock(customer[i].getSale(j).getBranchID(),customer[i].getSale(j).getName(),1))
    					{
            				removeProductStock(customer[i].getSale(j).getBranchID(),1,customer[i].getSale(j).getName());
            				customer[i].getSale(j).setConfirmation(1);
    					}
    					else 
    					{
    						System.out.printf("------------------------------\n");
    						System.out.printf("Your stock is not needed ! ! !\n");
    						System.out.printf("------------------------------\n");
    					}
    					break;
    				}
    			}
    		}
    	}
    }
    
	/**To check whether the product in the stock is sufficient. 
	 * @param BranchID Branch ID
	 * @param name name
	 * @param stock stock
	 * @return
	 */
	public boolean controlProductStock(int BranchID,String name,int stock)
	{
		int select=0;
		for(int i=0; i<getBranchNumber() ;++i) {
			if(getBranch(i).getBranchID() == BranchID)
			{
				select = i;
				break;
			}
		}	
		
		if( getBranch(select).getOfficeChairs().getName().equals(name) && getBranch(select).getOfficeChairs().getStock() >= stock )
			return true;
		if( getBranch(select).getBookcases().getName().equals(name) && getBranch(select).getBookcases().getStock() >= stock )
			return true;
		if( getBranch(select).getOfficecabinets().getName().equals(name) && getBranch(select).getOfficecabinets().getStock() >= stock )
			return true;
		if( getBranch(select).getMeetingTables().getName().equals(name) && getBranch(select).getMeetingTables().getStock() >= stock )
			return true;
		if( getBranch(select).getOfficeDesk().getName().equals(name) && getBranch(select).getOfficeDesk().getStock() >= stock )
			return true;
		else 
			return false;
		
	}
	
    /**To return customer number with using id and password that belongs to customer.
     * @param ID ID
     * @param Password Password
     * @return Customer Number
     */
    public int getCustomerNumberBelongsToCustomer(int ID,String Password)
    {
		for(int i=0; i<getCustomerNumber() ;++i) {
			if(getCustomer(i).getId() == ID)
			{
				if(getCustomer(i).getPassword().equals(Password) )
				{
					return getCustomer(i).getCustomerNumber();
				}
			}
		}
		return 0;
    }
}
