package com.Osman;

/**Sales data structure
 * @author osman
 *
 */
public class Sale {

    private int saleID;
    private int confirmation;
    private int branchID;
    
	private String name;
	private int model;
	private int colour;

    public Sale()
    {
    	this(0,0,0,"no",0,0);
    }
    public Sale(int saleID,int confirmation,int branchID,String name,int model,int colour)
    {
    	this.saleID = saleID;
    	this.confirmation = confirmation;
    	this.branchID = branchID;
    	this.name = name;
    	this.model = model;
    	this.colour = colour;
    } 
    
	public int getModel() {
		return model;
	}
	public void setModel(int model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getColour() {
		return colour;
	}
	public void setColour(int colour) {
		this.colour = colour;
	}

    public int getSaleID()
    {
    	return saleID;
    }
    public void setSaleID(int saleID)
    {
    	this.saleID = saleID;
    }
    public int getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }

    public int getBranchID() {
        return branchID;
    }
    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    @Override
	public String toString(){
        return String.format("Sale ID: %d\nStatus: %d\nBranch ID: %d\nProduct Name: %s\nProduct Colour:%s\nProduct Model:%s",
        		getSaleID(),getConfirmation(),getBranchID(),getName(),getColour(),getModel());
    }
}
