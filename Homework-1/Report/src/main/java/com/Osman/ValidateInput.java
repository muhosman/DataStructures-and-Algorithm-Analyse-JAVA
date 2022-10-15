package com.Osman;

/**To validate all user input.
 * @author osman
 *
 */
public class ValidateInput {

	private DataControl data;
	
	/**Constructor
	 * @param data data
	 */
	public ValidateInput(DataControl data)
	{
		this.data = data;
	}
	
	
	/**To control admin id and password and return true if they are correct 
	 * @param ID ID
	 * @param Password Password
	 * @return boolean
	 */
	public boolean controlAdminIDPassword(int ID,String Password)
	{
		for(int i=0; i<data.getAdministratorNumber() ;++i) {
			if(data.getAdministrator(i).getId() == ID)
			{
				if(data.getAdministrator(i).getPassword().equals(Password) )
				{
					return true;
				}
			}
		}
		return false;
	}
	/**To control branch employee id and password and return true if they are correct 
	 * @param ID ID
	 * @param Password Password
	 * @return boolean
	 */
	public boolean controlBranchEmployeeIDPassword(int ID,String Password)
	{
		for(int i=0; i<data.getBranchEmployeeNumber() ;++i) {
			if(data.getBranchEmployee(i).getId() == ID)
			{
				if(data.getBranchEmployee(i).getPassword().equals(Password) )
				{
					return true;
				}
			}
		}
		return false;
	}
	/**To control customer id and password and return true if they are correct 
	 * @param ID ID
	 * @param Password Password
	 * @return boolean
	 */
	public boolean controlCustomerIDPassword(int ID,String Password)
	{
		for(int i=0; i<data.getCustomerNumber() ;++i) {
			if(data.getCustomer(i).getId() == ID)
			{
				if(data.getCustomer(i).getPassword().equals(Password) )
				{
					return true;
				}
			}
		}
		return false;
	}
	/**To control branch id if there are branch
	 * @param ID ID
	 * @return boolean
	 */
	public boolean controlBranchID(int ID)
	{
		for(int i=0; i<data.getBranchNumber() ;++i) {
			if(data.getBranch(i).getBranchID() == ID)
			{
				return true;
			}
		}
		return false;
	}
	/**To control branch employee id if there are branch employee
	 * @param ID ID
	 * @return boolean
	 */
	public boolean controlBranchEmployeeID(int ID)
	{
		for(int i=0; i<data.getBranchEmployeeNumber() ;++i) {
			if(data.getBranchEmployee(i).getId() == ID)
			{
				return true;
			}
		}
		return false;
	}
	/**To control customer id if there are customer
	 * @param ID ID
	 * @return boolean
	 */
	public boolean controlCustomerID(int ID)
	{
		for(int i=0; i<data.getCustomerNumber() ;++i) {
			if(data.getCustomer(i).getId() == ID)
			{
				return true;
			}
		}
		return false;
	}

	/**To control product if there are product in this branch
	 * @param BranchID Branch ID
	 * @param name name
	 * @return boolean 
	 */
	public boolean controlProductName(int BranchID,String name)
	{
		int select=0;
		for(int i=0; i<data.getBranchNumber() ;++i) {
			if(data.getBranch(i).getBranchID() == BranchID)
			{
				select = i;
				break;
			}
		}
		if( data.getBranch(select).getOfficeChairs().getName().equals(name) )
			return true;
		if( data.getBranch(select).getBookcases().getName().equals(name) )
			return true;
		if( data.getBranch(select).getOfficecabinets().getName().equals(name) )
			return true;
		if( data.getBranch(select).getMeetingTables().getName().equals(name) )
			return true;
		if( data.getBranch(select).getOfficeDesk().getName().equals(name) )
			return true;
		else 
			return false;
	}
	/**To control product if there are product
	 * @param name name
	 * @return boolean
	 */
	public boolean controlProductName(String name)
	{
		if( 1 >= data.getBranchNumber() )
		{
			if( data.getBranch(0).getOfficeChairs().getName().equals(name) )
				return true;
			if( data.getBranch(0).getBookcases().getName().equals(name) )
				return true;
			if( data.getBranch(0).getOfficecabinets().getName().equals(name) )
				return true;
			if( data.getBranch(0).getMeetingTables().getName().equals(name) )
				return true;
			if( data.getBranch(0).getOfficeDesk().getName().equals(name) )
				return true;
			else 
				return false;
		}
		return false;
	}
	/**To control product stock if there are products in this branch
	 * @param BranchID Branch ID
	 * @param name name
	 * @param stock stock
	 * @return boolean
	 */
	public boolean controlProductStock(int BranchID,String name,int stock)
	{
		int select=0;
		for(int i=0; i<data.getBranchNumber() ;++i) {
			if(data.getBranch(i).getBranchID() == BranchID)
			{
				select = i;
				break;
			}
		}	
		
		if( data.getBranch(select).getOfficeChairs().getName().equals(name) && data.getBranch(select).getOfficeChairs().getStock() >= stock )
			return true;
		if( data.getBranch(select).getBookcases().getName().equals(name) && data.getBranch(select).getBookcases().getStock() >= stock )
			return true;
		if( data.getBranch(select).getOfficecabinets().getName().equals(name) && data.getBranch(select).getOfficecabinets().getStock() >= stock )
			return true;
		if( data.getBranch(select).getMeetingTables().getName().equals(name) && data.getBranch(select).getMeetingTables().getStock() >= stock )
			return true;
		if( data.getBranch(select).getOfficeDesk().getName().equals(name) && data.getBranch(select).getOfficeDesk().getStock() >= stock )
			return true;
		else 
			return false;
		
	}
	
	/**To control customer number if there are customer
	 * @param customerNumber customer Number
	 * @return boolean
	 */
	public boolean controlCustomerNumber(int customerNumber)
	{
		for(int i=0; i<data.getCustomerNumber();++i)
		{
			if(data.getCustomer(i).getCustomerNumber()==customerNumber)
			{
				return true;
			}
		}
		return false;
	}
	/**To control customer if there are customer in this branch
	 * @param customerNumber customer Number
	 * @param BranchID Branch ID
	 * @return boolean 
	 */
	public boolean controlCustomerNumberInBranch(int customerNumber,int BranchID)
	{
		for(int i=0; i<data.getCustomerNumber();++i)
		{
			if(data.getCustomer(i).getCustomerNumber()==customerNumber)
			{
				for(int j=0; j < data.getCustomer(i).getSaleNumber() ; ++j )
				{
					if(data.getCustomer(i).getSale(j).getBranchID() == BranchID)
					{
						return true;
					}
				}
				break;
			}
		}
		return false;
	}
	/**To control customer order if there are order in this branch
	 * @param customerNumber customer Number
	 * @param saleID sale ID
	 * @param BranchID Branch ID
	 * @return boolean
	 */
	public boolean controlSaleIDinBranch(int customerNumber,int saleID,int BranchID)
	{
		for(int i=0; i<data.getCustomerNumber();++i)
		{
			if(data.getCustomer(i).getCustomerNumber()==customerNumber)
			{
				for(int j=0; j < data.getCustomer(i).getSaleNumber() ; ++j )
				{
					if(data.getCustomer(i).getSale(j).getSaleID() == saleID && data.getCustomer(i).getSale(j).getBranchID() == BranchID)
					{
						return true;
					}
				}
				break;
			}
		}
		return false;
	}
	/**To control colour and model input if it is correct
	 * @param colour colour
	 * @param model model
	 * @param name name
	 * @return boolean
	 */
	public boolean controlColourandModel(int colour,int model,String name)
	{
		for(int i=0; i<data.getBranchNumber() ;++i) {
			if( data.getBranch(i).getOfficeChairs().getName().equals(name) ) {
				if(data.getBranch(i).getOfficeChairs().getColour() >= colour && colour >=1) {
					if(data.getBranch(i).getOfficeChairs().getModel() >= model && model >=1) {
						return true;
					}
				}
			}
			else if( data.getBranch(i).getBookcases().getName().equals(name) ) {
				if(data.getBranch(i).getBookcases().getColour() >= colour && colour >=1) {
					if(data.getBranch(i).getBookcases().getModel() >= model && model >=1) {
						return true;			
					}
				}
			}
			else if( data.getBranch(i).getOfficecabinets().getName().equals(name) ) {
				if(data.getBranch(i).getOfficecabinets().getColour() >= colour && colour >=1) {
					if(data.getBranch(i).getOfficecabinets().getModel() >= model && model >=1) {
						return true;
					}
				}
			}
			else if( data.getBranch(i).getMeetingTables().getName().equals(name) ) {
				if(data.getBranch(i).getMeetingTables().getColour() >= colour && colour >=1) {
					if(data.getBranch(i).getMeetingTables().getModel() >= model && model >=1) {
						return true;			
					}
				}
			}
			else if( data.getBranch(i).getOfficeDesk().getName().equals(name) ) {
				if(data.getBranch(i).getOfficeDesk().getColour() >= colour && colour >=1) {
					if(data.getBranch(i).getOfficeDesk().getModel() >= model && model >=1) {
						return true;
					}
				}
			}
			
		}
		return false;
	}
}
