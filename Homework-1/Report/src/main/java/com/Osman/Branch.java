package com.Osman;

/** Branch data structure.
 * @author osman
 *
 */
public class Branch {
    private int branchID;
    private int branchEmployeeIDs[];
    private int branchEmployeeNumber;

	private Products OfficeChairs; 
    private Products MeetingTables;
    private Products Bookcases;
    private Products Officecabinets;
    private Products OfficeDesk; 
    
    
    /**Default constructor.
     * 
     */
    public Branch() {
		branchID = 0;
		branchEmployeeNumber = 0;
		
		OfficeChairs = new Products(0,7,5,"Office Chair");
		MeetingTables = new Products(0,10,4,"Meeting Table");
		Bookcases = new Products(0,12,0,"Bookcase");
		Officecabinets = new Products(0,12,0,"Office Cabinet");
		OfficeDesk = new Products(0,5,4,"Office Desk");
	}
    
    /**Constructor.
     * @param branchID
     * @param branchEmployeeNumber It takes number of branch employees.
     */
    public Branch(int branchID, int branchEmployeeNumber) {
		this.branchID = branchID;
		this.branchEmployeeNumber = branchEmployeeNumber;
		OfficeChairs = new Products(0,7,5,"Office Chair");
		MeetingTables = new Products(0,10,4,"Meeting Table");
		Bookcases = new Products(0,12,0,"Bookcase");
		Officecabinets = new Products(0,12,0,"Office Cabinet");
		OfficeDesk = new Products(0,5,4,"Office Desk");
	}
    
    
    /**Save branch employee ıd in branch data structure.
     * @param BranchEmployeeID Branch Employee ID
     */
    public void addBranchEmployeeIDs(int BranchEmployeeID){
    	int temp [] = new int[getBranchEmployeeNumber()];
    	for(int i = 0; i < getBranchEmployeeNumber()-1;++i) {
    		temp[i] = branchEmployeeIDs[i];

    	}
    	temp[getBranchEmployeeNumber()-1] = BranchEmployeeID;        
    	branchEmployeeIDs = temp;
    }
    /**
     * @param BranchEmployeeID BranchEmployee ID
     */
    public void removeBranchEmployeeIDs(int BranchEmployeeID){
    	int select=0;
    	int temp [] = new int[getBranchEmployeeNumber()-1];
        
    	for(int i = 0;;++i) 
    	{
    		if(branchEmployeeIDs[i] == BranchEmployeeID)
    		{
    			select = i;
    			break;
    		}
			select = i;

    		temp[i] = branchEmployeeIDs[i];
    	}
    	for(int i=select; i < getBranchEmployeeNumber()-1;i++)
    	{
    		temp[i] = branchEmployeeIDs[i+1];

    	}
    	branchEmployeeIDs = temp;
    	setBranchEmployeeNumber(-1);
    }
    /**Print all branch employee id.
     * 
     */
    public int getBranchEmployeeIDs(int i)
    {
    	return branchEmployeeIDs[i];
    }
    
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public int getBranchEmployeeNumber() {
		return branchEmployeeNumber;
	}
	public void setBranchEmployeeNumber(int branchEmployeeNumber) {
		this.branchEmployeeNumber += branchEmployeeNumber;
	}
	public Products getOfficeChairs() {
		return OfficeChairs;
	}
	public void setOfficeChairs(Products officeChairs) {
		OfficeChairs = officeChairs;
	}
	public Products getMeetingTables() {
		return MeetingTables;
	}
	public void setMeetingTables(Products meetingTables) {
		MeetingTables = meetingTables;
	}
	public Products getBookcases() {
		return Bookcases;
	}
	public void setBookcases(Products bookcases) {
		Bookcases = bookcases;
	}
	public Products getOfficecabinets() {
		return Officecabinets;
	}
	public void setOfficecabinets(Products officecabinets) {
		Officecabinets = officecabinets;
	}
	public Products getOfficeDesk() {
		return OfficeDesk;
	}
	public void setOfficeDesk(Products officeDesk) {
		OfficeDesk = officeDesk;
	}
	public void setBranchEmployeeIDs(int[] branchEmployeeIDs) {
		this.branchEmployeeIDs = branchEmployeeIDs;
	}
	
	
	/**To ıncrease the product stock.
	 * @param stock stock
	 * @param name name
	 */
	public void addStock(int stock,String name)
	{
		if(OfficeChairs.getName().equals(name))
				OfficeChairs.addStock(stock);
		else if(OfficeDesk.getName().equals(name))
			OfficeDesk.addStock(stock);
		else if(MeetingTables.getName().equals(name))
			MeetingTables.addStock(stock);
		else if(Bookcases.getName().equals(name))
			Bookcases.addStock(stock);
		else if(Officecabinets.getName().equals(name))
			Officecabinets.addStock(stock);
		else
			System.out.println("This Product Name is false ! ! ! \n");
	}
	
	/**To decrease the product stock.
	 * @param stock stock
	 * @param name name
	 */
	public void removeStock(int stock,String name)
	{
		if(OfficeChairs.getName().equals(name))
				OfficeChairs.removeStock(stock);
		else if(OfficeDesk.getName().equals(name))
			OfficeDesk.removeStock(stock);
		else if(MeetingTables.getName().equals(name))
			MeetingTables.removeStock(stock);
		else if(Bookcases.getName().equals(name))
			Bookcases.removeStock(stock);
		else if(Officecabinets.getName().equals(name))
			Officecabinets.removeStock(stock);
		else
			System.out.println("This Product Name is false ! ! ! \n");
	}
	
	/**To print all product information.
	 * 
	 */
	public void printProductInf()
	{
		System.out.println(OfficeChairs);
		System.out.println(OfficeDesk);
		System.out.println(MeetingTables);
		System.out.println(Bookcases);
		System.out.println(Officecabinets);
	}
	
    @Override
	public String toString(){
        return String.format("Branch ID:%s\nNumber of Branch Employee:%s\n",
        		getBranchID(),getBranchEmployeeNumber());
    }
}
