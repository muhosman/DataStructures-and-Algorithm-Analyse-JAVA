package com.Osman;


public class App 
{
    public static void main( String[] args )
    {
    	int select=0;
    	int ID;
    	String password;
    	DataControl data = new DataControl();
    	data.addAdministrator(161044058,"Osman","Aydin","66894761");
    	
    	ValidateInput validateInput = new ValidateInput(data);
    	PrintData printdata = new PrintData(data);
    	
    	MainMenu MainMenu = new MainMenu();
    	AdministratorMenu AdministratorMenu = new AdministratorMenu();
    	BranchEmployeeMenu BranchEmployeeMenu = new BranchEmployeeMenu();
    	CustomerMenu CustomerMenu = new CustomerMenu();
    	
    	
    	AdminPanel AdminPanel = new AdminPanel(data,printdata,validateInput);
    	BranchEmployeePanel BranchEmployeePanel = new BranchEmployeePanel(data,printdata,validateInput,0);
    	CustomerPanel CustomerPanel = new CustomerPanel(data,printdata,validateInput,0);
    	
    	do {
    		try {
    			MainMenu.userInterface();
        		System.out.printf("\nSelect:");
        		select = GetInputFromUser.getINT();
        		
        		if(select == 1)
        		{
        			System.out.printf("ID:");
        			ID = GetInputFromUser.getINT();
        			System.out.printf("Password:");
        			password = GetInputFromUser.getSTRING();
        			
        			if(validateInput.controlAdminIDPassword(ID,password))
        			{
        				do {
        					AdministratorMenu.userInterface();
        		    		System.out.printf("\nSelect:");
        		    		select = GetInputFromUser.getINT();
        					AdminPanel.choice(select);
        				}while(select != 8);
        				select = 0;
        			}
        			else
        				System.out.println("Id and Password is false ! !");
        		}
        		else if(select == 2)
        		{
        			System.out.printf("ID:");
        			ID = GetInputFromUser.getINT();
        			System.out.printf("Password:");
        			password = GetInputFromUser.getSTRING();
        			
        			if(validateInput.controlBranchEmployeeIDPassword(ID,password))
        			{
        				BranchEmployeePanel.setBranchID(data.getBranchIdBelongsToBranchEmployee(ID,password));
        				do {
        					BranchEmployeeMenu.userInterface();
        		    		System.out.printf("\nSelect:");
        		    		select = GetInputFromUser.getINT();
        		    		BranchEmployeePanel.choice(select);
        				}while(select != 6);
        				select = 0;
        			}
        			else
        				System.out.println("Id and Password is false ! !");
        		}    		
        		else if(select == 3)
        		{
        			System.out.printf("ID:");
        			ID = GetInputFromUser.getINT();
        			System.out.printf("Password:");
        			password = GetInputFromUser.getSTRING();
        			
        			if(validateInput.controlCustomerIDPassword(ID,password))
        			{
        				CustomerPanel.setCustomerNumber(data.getCustomerNumberBelongsToCustomer(ID,password));
        				do {
        					CustomerMenu.userInterface();
        		    		System.out.printf("\nSelect:");
        		    		select = GetInputFromUser.getINT();
        		    		CustomerPanel.choice(select);
        				}while(select != 5);
        				select = 0;
        			}
        			else
        				System.out.println("Id and Password is false ! !");
        		}   	    		
        		else if(select == 4)
        		{
        			CustomerPanel.makeCustomerAccount();
        		}	
    		
    		}
    		catch(Exception e)
    		{
    			System.out.println("Probably You entered false input ! ! !");
    		}
    		
    	}while(select != 5);
    	
    }
    
}
