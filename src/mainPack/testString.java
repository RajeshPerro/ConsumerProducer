/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPack;

import java.util.Arrays;

/**
 *
 * @author rajesh
 */
public class testString 
{
    public static void main(String [] args)
    {
      byte [] aaa= {(byte) 1,(byte) 0,(byte) 0};
        String str1 =Arrays.toString(aaa);
        
        if(str1.equalsIgnoreCase("[1, 0, 0]"))
        {
            System.out.println("okay!");
        }
        System.out.println("The string array is  : "+str1);
    }
}
