package com.Osman;

/**Products data structure
 * @author osman
 *
 */
public class Products {
	
	private int stock;
	private int model;
	private int colour;
	private String name;
	
	public Products(int stock,int model,int colour,String name)
	{
		this.stock = stock;
		this.model = model;
		this.colour = colour;
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void addStock(int stock) {
		this.stock += stock;
	}
	public void removeStock(int stock) {
		this.stock -= stock;
	}
	public int getModel() {
		return model;
	}
	public void setModel(int model) {
		this.model = model;
	}
	public int getColour() {
		return colour;
	}
	public void setColour(int colour) {
		this.colour = colour;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
        return String.format("Stock: %d\nNumber of Model:%d\nNumber Of Color: %d\nProduct Name: %s\n",getStock(),getModel(),getColour(),getName());
	}
}
