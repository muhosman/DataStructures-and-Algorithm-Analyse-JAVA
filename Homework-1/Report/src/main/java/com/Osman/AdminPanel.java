package com.Osman;


/**Administrator control panel.
 * @author osman
 *
 */
public class AdminPanel {

	private DataControl data;
	private PrintData printdata;
	private ValidateInput validateInput;

	
	/**Constructor
	 * @param data Data
	 * @param printdata Print Data
	 * @param validateInput Validate Input
	 */
	public AdminPanel(DataControl data,PrintData printdata,ValidateInput validateInput)
	{
		this.data = data;
		this.printdata = printdata;
		this.validateInput = validateInput;
	}
	
	/**Administrator control menu.
	 * @param select select
	 */
	public void choice(int select)
	{
		switch(select)
		{
			case 1:
				addBranch();
			break;
			case 2:
				printBranch();
			break;
			case 3:
				removeBranch();
			break;
			case 4:
				addBranchEmployee();
			break;
			case 5:
				printBranchEmployee();
			break;
			case 6:
				removeBranchEmployee();
			break;
			case 7:
				printNeededStockInf();
			break;
		}
	}
	
    /**Add new branch.
     * 
     */
    public void addBranch()
    {
    	int BranchID;
		System.out.printf("\nBranchID:");
		BranchID = GetInputFromUser.getINT();
		if(!validateInput.controlBranchID(BranchID)) {
	        data.addBranch(BranchID);
	        System.out.println("Your Branch has added Successfully!");
		}
		else
	        System.out.println("Your Branch has not added Successfully,Change BranchID!");
	}
    
    /**Remove branch.
     * 
     */
    public void removeBranch()
    {
    	int BranchID;
		System.out.printf("\nBranchID:");
		BranchID = GetInputFromUser.getINT();
		if(validateInput.controlBranchID(BranchID)) {
			data.removeBranch(BranchID);
	        System.out.println("Your Branch has removed Successfully!");
		}
		else
	        System.out.println("Your Branch has not removed Successfully!");

    }
    
    /**Print all branch.
     * 
     */
    public void printBranch()
    {
    	printdata.Branch();
    }
    
    /**Add new branch employee.
     * 
     */
    public void addBranchEmployee()
    {
    	int BranchID;
    	int ID;
    	String firstName;
    	String lastName;
    	String password;
    	System.out.printf("Write BranchID:");
    	BranchID = GetInputFromUser.getINT();
		if(!validateInput.controlBranchID(BranchID)) {
	        System.out.println("There are not any branch with this ID.");
		}
		else
		{
			System.out.printf("ID:");
			ID = GetInputFromUser.getINT();
			if(validateInput.controlBranchEmployeeID(ID))
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
		        data.addBranchEmployee(BranchID,ID,firstName,lastName,password);
		        System.out.println("Branch Employee acount has added Successfully!");
			}
		}
		
    }
    
    /**Remove branch employee.
     * 
     */
    public void removeBranchEmployee()
    {
    	int ID;
		System.out.printf("ID:");
		ID = GetInputFromUser.getINT();
		if(validateInput.controlBranchEmployeeID(ID))
		{
	    	data.removeBranchEmployee(ID);
	        System.out.println("Branch Employee acount has removed Successfully!");
		}
		else
		{
	        System.out.println("There are not any Branch Employee with this ID.");
		}
    }
    
    /**Print all branch employee information.
     * 
     */
    public void printBranchEmployee()
    {
    	printdata.BranchEmployee();
    }
    
    /**Print All stock information.
     * 
     */
    public void printNeededStockInf()
    {
    	printdata.printNeededStockInf();
    }
}
