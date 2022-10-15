package com.Osman;

/**Administrator data structure.
 * @author osman
 *
 */

public class Administrator implements UserInterface{
    private  int IdNumber;
    private String firstName;
    private  String lastName;
    private String password;
	
    
    public Administrator() {
        this(0,"NoName","NoLastName","NoPassword");
    }
    
    /**Constructor
     * @param id Administrator Login ID
     * @param firstName First Name
     * @param lastName Last Name
     * @param password Password
     */
    public Administrator(int id, String firstName, String lastName,String password) {
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
    
    @Override
	public String toString(){
        return String.format("First Name:%s\nLast Name:%s\nID:%s\nPassword:%s\nBranch ID:%s\n",
        		this.getFirstName(),this.getLastName(),this.getId(),this.getPassword());   }
    
}
