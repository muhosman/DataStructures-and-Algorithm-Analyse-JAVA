package com.Osman;

/**Customer data structure.
 * @author osman
 *
 */
public class Customer implements UserInterface{
	
    private  int IdNumber;
    private String firstName;
    private  String lastName;
    private String password;
    
    private Sale sales[];
    private int saleNumber;
    
    private int customerNumber;

    
    /**Default constructor.
     * 
     */
    public Customer() {
        this(0,"NoName","NoLastName","NoPassword",0,0);
    }

    /**Constructor
     * @param id id
     * @param firstName first Name
     * @param lastName last Name
     * @param password password
     * @param saleNumber Count of sale
     * @param customerNumber customer Number
     */
    public Customer(int id, String firstName, String lastName,String password,int saleNumber,int customerNumber) {
        this.IdNumber = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.saleNumber = saleNumber;
        this.customerNumber = customerNumber;
    }
    
    public int getId() {
        return IdNumber;
    }
    public void setId(int id) {
        this.IdNumber = id;
    }
    
    public int getSaleNumber() {
        return saleNumber;
    }
    public void setSaleNumber(int saleNumber) {
        this.saleNumber += saleNumber;
    }
    public void addSale(Sale sale){
    	Sale temp [] = new Sale[getSaleNumber()];
    	for(int i = 0; i < getSaleNumber()-1;++i) {
    		temp[i] = sales[i];

    	}
    	temp[getSaleNumber()-1] = sale;        
    	sales = temp;
    }
    public Sale getSale(int i)
    {
    	return sales[i];
    }
    public void getSaleINF()
    {
    	for(int i=0;i < getSaleNumber();++i)
    		System.out.println(sales[i]);
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
    

    public int getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
	public String toString(){
        return String.format("First Name:%s\nLast Name:%s\nCustomer Number:%d\nID:%s\nPassword:%s\n",
        		getFirstName(),getLastName(),getCustomerNumber(),getId(),getPassword());
    }
}