package com.Osman;

/**Branch Employee data structure.
 * @author osman
 *
 */

public class BranchEmployee implements UserInterface {

    private int branchID;

    private  int IdNumber;
    private String firstName;
    private  String lastName;
    private String password;
    
    /**Default Constructor
     * 
     */
    public BranchEmployee() {
        this(0,0,"NoName","NoLastName","NoPassword");
    }
    
    
    /**Constructor
     * @param branchID Branch ID
     * @param id Login id
     * @param firstName FirstName
     * @param lastName LastName
     * @param password Password
     */
    public BranchEmployee(int branchID,int id, String firstName, String lastName,String password) {
    	this.branchID = branchID;
        this.IdNumber = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
    
    public int getId() {
        return IdNumber;
    }
    public void setId(int id) {
        this.IdNumber = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getBranchID() {
        return branchID;
    }
    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
    
    @Override
	public String toString(){
        return String.format("First Name:%s\nLast Name:%s\nID:%s\nPassword:%s\nBranch ID:%s\n",
        		this.getFirstName(),this.getLastName(),this.getId(),this.getPassword(),this.getBranchID());   }
}
