/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableaugenerator;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author jespe_000
 */
public class TableauGenerator {
    
    public static void main(String[] args) {
        findParantesesPairs("((p) > (p ^ r))");                
    }
    
    public static void findParantesesPairs(String Udsagn)
    {   
        //ignorer paranteser direkte inde i sætningen 
        Udsagn = "(" + Udsagn.replaceAll(" ", "") + ")";
        int numberOfParentesPairs = findNumberOfParentesPairs(Udsagn);        
        int[][] parantesesPairsInt = new int[numberOfParentesPairs][3];        
        parantesesPairsInt = pairUpParenteses(Udsagn, parantesesPairsInt); //Necccesary? object?        
        //Arrays.sort(parantesesPairsInt[0][]); 
        
        System.out.println(Udsagn);        
    }
    
    public static int[][] sortMulitdimensional(int[][] arrayToSort)
    {        
        return arrayToSort;
    }

    public static int[][] pairUpParenteses(String Udsagn, int[][] parantesesPairsInt) {
        
        int pairNumberCurrent = 0;
        int pairDepth = 0;        
        for (int i = 0; i < Udsagn.length(); i++) {
            char currentChar = Udsagn.charAt(i);
            if (currentChar == '(')
            {           
                parantesesPairsInt[pairNumberCurrent][0] = i;
                pairNumberCurrent++;
                pairDepth++;
            }                
            else if (currentChar == ')') //if ) is the first?
            {
                for (int j = pairNumberCurrent; j > 0; j--) {                    
                    if (parantesesPairsInt[j - 1][1] == 0)
                    {
                        parantesesPairsInt[j - 1][1] = i;
                        parantesesPairsInt[j - 1][2] = pairDepth;                       
                        pairDepth--;
                        break;
                    }                         
                }
                
            }            
        }//Husk errorbeskeder hvis der mangler paranteser
        
        return parantesesPairsInt;
    }
    
    public static int findNumberOfParentesPairs(String Udsagn)
    {
        int numberOfLeftParenteses = 0;
        int numberOfRightParenteses = 0;
        
        for (int i = 0; i < Udsagn.length(); i++) {
            char currentChar = Udsagn.charAt(i);
            if (currentChar == '(')
                numberOfLeftParenteses++;
            else if (currentChar == ')')
            {
                numberOfRightParenteses++;
                if (numberOfRightParenteses >  numberOfLeftParenteses)
                    throw new IllegalArgumentException("Syntax error, ) at index " + i + " does not pair up with any ) before it");
            }                 
        }
        
        if (numberOfLeftParenteses == numberOfRightParenteses)  
            return numberOfLeftParenteses;
        else
        {
            throw new IllegalArgumentException("The number of ('s is different from the number of )'s. ( =" + numberOfLeftParenteses + ". ) = " + numberOfRightParenteses);
        }
    }    
    
    
}

