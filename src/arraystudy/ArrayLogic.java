
package arraystudy;

/**
 *
 * @author Bence Szitas
 * Java tömb műveletek osztály. 
 * Példányosításkor a kapott tömb(ök), fukciókód, és műveleti jel alapján a megfelelő konstrukor kerül meghívásra,
 * ami eldönti, hogy melyik tömb kezelő függvény fog lefutni, majd beállítja az osztályváltozó értékeit. (resultArray, resultNumber).
 * Ezeket az objektum getResultArray(), és getResultNumber() függvényeivel lehet lekérdezni.
 * 
 * Funkció kódok (int functionCode):
 *      Összegzés   -   1
 *      Kiválasztás -   2
 *      Maximum     -   3
 *      Minimum     -   4
 *      Metszet     -   5
 *      Únió        -   6
 *      Rendez fel  -   7
 *      Rendez le   -   8
 */

public class ArrayLogic {
    
    private final String[] FXNAMES ={"Összegzés","Kiválasztás","Maximum","Minimum","Metszet","Únió","Rendezés növekvő","Rendezés csökkenő"};
    private int[] array1;
    private int[] array2;
    private int function;
    private int[] resultArray;
    private int resultNumber;
    
   ArrayLogic(){
       
   }
   
   //New comment test
   
   ArrayLogic(int[] firstArray, int functionCode){
       function = functionCode;
        array1 = firstArray;
        switch(function){
            case 1:
                sum(firstArray);
                break;
            case 3:
                max(firstArray);
                break;
            case 4:
                min(firstArray);
                break;
            case 7:
                rendezFel(array1);
                break;
            case 8:
                rendezLe(array1);
                break;    
        }
        
    }
    
    ArrayLogic(int[] firstArray, int cons, String operand, int functionCode){
        function = functionCode;
        array1 = firstArray;
        switch(function){
            case 2:
                select(array1, cons, operand);
                break;
        }
    }
    
    ArrayLogic(int[] firstArray, int[] secondArray, int functionCode){
        function = functionCode;
        array1 = firstArray;
        array2 = secondArray;
        
        switch(function){
            case 5:
                metszet(array1, array2);
                break;
            case 6:
                unio(array1, array2);
                break;
        }
    }

    public int[] getResultArray() {
        return resultArray;
    }

    public int getResultNumber() {
        return resultNumber;
    }
    
    public String getName(){
        return FXNAMES[function-1];
    }
 
    private void sum(int[] tomb) {
        int amount = 0;
        for (int i=0; i<tomb.length; i++){
            amount = amount + tomb[i];
        }
        resultArray = new int[1];
        resultArray[0] = amount;
    }
     
    private void select(int[] array, int condition, String operand){
        int resultCounter = 0;
        switch(operand){
            case "=":
                for (int i=0; i<array.length; i++){
                    if (array[i] == condition){
                        resultCounter++;
                    }
                resultArray = new int[resultCounter];
                }
                resultCounter = 0;    
                for (int i=0; i<array.length; i++){
                    if (condition == array[i]){
                        resultArray[resultCounter++] = array[i];
                    }
                }
                
                break;
                
            case "<":
                for (int i=0; i<array.length; i++){
                    if (array[i] < condition){
                        resultCounter++;
                    }
                resultArray = new int[resultCounter];
                
                }
                resultCounter = 0;    
                for (int i=0; i<array.length; i++){
                    if (array[i] < condition){
                        resultArray[resultCounter++] = array[i];
                        }
                    }
                break;
                
                case ">":
                for (int i=0; i<array.length; i++){
                    if (array[i] > condition){
                        resultCounter++;
                    }
                resultArray = new int[resultCounter];
                
                }
                resultCounter = 0;    
                for (int i=0; i<array.length; i++){
                    if (array[i] > condition){
                        resultArray[resultCounter++] = array[i];
                        }
                    }
                break;
                
                case ">=":
                for (int i=0; i<array.length; i++){
                    if (array[i] >= condition){
                        resultCounter++;
                    }
                resultArray = new int[resultCounter];
                
                }
                resultCounter = 0;    
                for (int i=0; i<array.length; i++){
                    if (array[i] >= condition){
                        resultArray[resultCounter++] = array[i];
                        }
                    }
                break;
                
                case "<=":
                for (int i=0; i<array.length; i++){
                    if (array[i] <= condition){
                        resultCounter++;
                    }
                resultArray = new int[resultCounter];
                
                }
                resultCounter = 0;    
                for (int i=0; i<array.length; i++){
                    if (array[i] <= condition){
                        resultArray[resultCounter++] = array[i];
                        }
                    }
                break;
                
                case "!=":
                for (int i=0; i<array.length; i++){
                    if (array[i] != condition){
                        resultCounter++;
                    }
                resultArray = new int[resultCounter];
                
                }
                resultCounter = 0;    
                for (int i=0; i<array.length; i++){
                    if (array[i] != condition){
                        resultArray[resultCounter++] = array[i];
                        }
                    }
                break;
        }       
    }
    
    private void max(int[] array){
        rendezLe(array);
        resultArray = new int[array.length];
        resultArray = array;
        resultNumber = resultArray[0];
    }
    
    private void min(int[] array){
        rendezFel(array);
        resultArray = new int[array.length];
        resultArray = array;
        resultNumber = resultArray[0];
    }
    
    private void metszet(int[] array1, int[] array2){
        int resultCounter = 0;
        for(int i=0; i<array1.length;i++){
            for (int j=0; j<array2.length; j++){
                if (array1[i] == array2[j]){
                    resultCounter++;
                }
            }
        }
        resultArray = new int[resultCounter];
        resultCounter = 0;
        for(int i=0; i<array1.length;i++){
            for (int j=0; j<array2.length; j++){
                if (array1[i] == array2[j]){
                    resultArray[resultCounter++] = array2[j];
                }
            }
        }
    }
    
    private void unio(int[] array1, int[] array2){
        int resultCounter = array1.length;
        for(int j=0; j<array2.length;j++){
            int i = 0;
            while(i<array1.length && array1[i] != array2[j]){
                i++;
            }
            if(i>=array1.length){
                resultCounter++;
            }
        }
    
        resultArray = new int[resultCounter];
                
        for(int i=0; i<array1.length;i++){
            resultArray[i] = array1[i];
        }
        
        int resultIndex = array1.length;
        for(int j=0; j<array2.length;j++){
            int i = 0;
            while(i<array1.length && array1[i] != array2[j]){
                i++;
            }
            if(i>=array1.length){
                resultArray[resultIndex++] = array2[j];
            }
        }
    }
        
    private void rendezFel(int[] tomb){
       int meret = tomb.length;
       int tmp;
       for(int i=meret-1; i>0; i--){
           for (int j=0; j<i; j++){
               if (tomb[j]>tomb[j+1]){
                   tmp = tomb[j];
                   tomb[j] = tomb [j+1];
                   tomb[j+1] = tmp;
               }
          }
       }
       resultArray = tomb;
    }
    
    private void rendezLe(int[] tomb){
      int meret = tomb.length;
       int tmp;
       for(int i=meret-1; i>0; i--){
           for (int j=0; j<i; j++){
               if (tomb[j+1]>tomb[j]){
                   tmp = tomb[j];
                   tomb[j] = tomb [j+1];
                   tomb[j+1] = tmp;
               }
          }
       }
       resultArray = tomb;
    }
}
