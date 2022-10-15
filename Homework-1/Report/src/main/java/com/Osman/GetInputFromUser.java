package com.Osman;

import java.util.Scanner;

/**Take input from user.
 * @author osman
 *
 */
public class GetInputFromUser {
	
    public static int getINT(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public static String getSTRING(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

}
