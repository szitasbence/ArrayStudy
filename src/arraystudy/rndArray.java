package arraystudy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bence
 */
public class rndArray {
    
    public static int[] getRandomArray(int maxArrayLength, int maxNumber){
        int length =1 + (int) (Math.random()*maxArrayLength);
        int[] rndArray = new int[length];
        
        for(int i=0; i<length; i++){
            rndArray[i] = 1 + (int) (Math.random()*maxNumber); 
        }
        return rndArray;
        
    }
}
