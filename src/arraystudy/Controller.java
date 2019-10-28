
package arraystudy;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Bence Szitas
 * 
 * 
 */

public class Controller implements Initializable {
    private final int MAX_ARRAY_LENGTH = 16;
    private final int MAX_NUMBER = 99;
    private final String[] OPERANDS = {"=",">","<",">=","<=","!="};
    
    private int[] array1;
    private int[] array2;
    private int[] resultArray;
    private String resultString = "";
    private int value;
    private int functionCode = 1;
    private int radioFxCode = 0;
    private boolean inputError = false;
        
//<editor-fold defaultstate="collapsed" desc="FXML import">
    @FXML
    private Button rndButton1;
    @FXML
    private Button rndButton2;
    @FXML
    private Button calculateButton;
    @FXML
    private Button eraseButton;
    @FXML
    private Button errorOkButton;
    @FXML
    private RadioButton radioSum;
    @FXML
    private RadioButton radioMax;
    @FXML
    private RadioButton radioMin;
    @FXML
    private RadioButton radioSelect;
    @FXML
    private RadioButton radioSec;
    @FXML
    private RadioButton radioUnion;
    @FXML
    private RadioButton radioOrderUp;
    @FXML
    private RadioButton radioOrderDown;
    @FXML
    private RadioButton radioFx1;
    @FXML
    private RadioButton radioFx2;
    @FXML
    private RadioButton radioFx3;
    @FXML
    private RadioButton radioFx4;
    @FXML
    private RadioButton radioFx5;
    @FXML
    private RadioButton radioFx6;
    @FXML
    private TextField arrayText1;
    @FXML
    private TextField arrayText2;
    @FXML
    private TextField resultText;
    @FXML
    private TextField valueText;
    @FXML
    private VBox vBox1;
    @FXML
    private Pane mainPane;
    @FXML
    private Pane errorPane;
    @FXML
    private Label errorValue;
//</editor-fold>
    

//<editor-fold defaultstate="collapsed" desc="XFML kezelő függvények">
    @FXML
    private void randomArray1(ActionEvent event) {
        array1 = rndArray.getRandomArray(MAX_ARRAY_LENGTH, MAX_NUMBER);
        arrayText1.setText(getArrayNumbers(array1));
        //System.out.println(Arrays.toString(array1));
    }
    
    @FXML
    private void randomArray2(ActionEvent event) {
        array2 = rndArray.getRandomArray(MAX_ARRAY_LENGTH, MAX_NUMBER);
        arrayText2.setText(getArrayNumbers(array2));
        //System.out.println(Arrays.toString(array2));
    }
    
    @FXML
    private void radioSumCheck(){
        this.functionCode = 1;
        setVisiblity();
    }
    
    @FXML
    private void radioSelectCheck(){
        this.functionCode = 2;
        setVisiblity();
    }
    
    @FXML
    private void radioMaxCheck(){
        this.functionCode = 3;
        setVisiblity();
    }
    
    @FXML
    private void radioMinCheck(){
        this.functionCode = 4;
        setVisiblity();
    }
    
    @FXML
    private void radioSecCheck(){
        this.functionCode = 5;
        setVisiblity();
    }
    
    @FXML
    private void radioUnionCheck(){
        this.functionCode = 6;
        setVisiblity();
    }
    
    @FXML
    private void radioOrderUpCheck(){
        this.functionCode = 7;
        setVisiblity();
    }
    
    @FXML
    private void radioOrderDownCheck(){
        this.functionCode = 8;
        setVisiblity();
    }
    
    @FXML
    private void radioFx1Check(){
        this.radioFxCode = 0;
    }
    
    @FXML
    private void radioFx2Check(){
        this.radioFxCode = 1;
    }
    
    @FXML
    private void radioFx3Check(){
        this.radioFxCode = 2;
    }
    
    @FXML
    private void radioFx4Check(){
        this.radioFxCode = 3;
    }
    
    @FXML
    private void radioFx5Check(){
        this.radioFxCode = 4;
    }
    
    @FXML
    private void radioFx6Check(){
        this.radioFxCode = 5;
    }
    
    @FXML
    private void eraseButtonAction(){
        setDefaults();
    }
    
    @FXML
    private void calculateButtonAction(){
        calculate();
        errorMessage();
    }
    
    @FXML
    private void errorButtonAction(){
        inputError = false;
        errorPane.setVisible(false);
        errorPane.setDisable(true);
        mainPane.setDisable(false);
        mainPane.setVisible(true);
    }
//</editor-fold>
    
    
    private String getArrayNumbers(int[] array){
        String result = "";
        
        for (int i=0; i<array.length; i++){
            if (i<array.length-1)
                result = result + array[i] + ",";
            else
                result = result + array[i];    
        }
        return result;
    }
    
    private void setVisiblity(){
        switch (functionCode){
            case 1:
            case 3:
            case 4:
            case 7:    
            case 8:
                vBox1.setDisable(true);
                valueText.setDisable(true);
                rndButton2.setDisable(true);
                arrayText2.setDisable(true);
                break;
            case 2:
                vBox1.setDisable(false);
                valueText.setDisable(false);
                rndButton2.setDisable(true);
                arrayText2.setDisable(true);
                break;
            case 5:
            case 6:
                vBox1.setDisable(true);
                valueText.setDisable(true);
                rndButton2.setDisable(false);
                arrayText2.setDisable(false);
                break;
        }
    }
    
    private void setDefaults(){
        vBox1.setDisable(true);
        valueText.setDisable(true);
        valueText.setText("");
        rndButton2.setDisable(true);
        arrayText2.setDisable(true);
        arrayText2.setText("");
        arrayText1.setText("");
        resultText.setText("");
        errorValue.setVisible(false);
        radioSum.setSelected(true);
        this.functionCode = 1;
        radioFx1.setSelected(true);
        this.radioFxCode = 0;
        array1 = null;
        array2 = null;
        value = 0;
        inputError = false;
        resultString = "";
    }
    
    private void calculate(){
        ArrayLogic arrayLogic;
        resultText.setText("");
        resultString="";
        
        String string1 = arrayText1.getText();
        String string2 = arrayText2.getText();
         
        String[] array1str=string1.split(",", MAX_ARRAY_LENGTH);
        String[] array2str=string2.split(",", MAX_ARRAY_LENGTH);
        
        int[] array1int = new int[array1str.length];
        int[] array2int = new int[array2str.length];
   
        //Convert first String[] array to int[] array
            for (int i=0; i<array1str.length; i++){
                try{
                array1int[i] = Integer.parseInt(array1str[i]);
                if (array1int[i] <= 0 || array1int[i] > 99 ){
                    inputError = true;
                    return;
                }
                                    
                }
                catch(Exception e){
                   inputError = true;
                   return;
                }
            }

        //Convert second String[] array to int[] array
        if(functionCode == 5 || functionCode == 6 ){
            for (int i=0; i<array2str.length; i++){
                try{
                    array2int[i] = Integer.parseInt(array2str[i]);
                    if (array2int[i] <= 0 || array2int[i] > 99 ){
                        inputError = true;
                        return;
                    }
                }
                
                catch(Exception e){
                   inputError = true;
                   return;
                }
            }
        }
        
        switch(functionCode){
            case 1:
            case 3:
            case 4:
            case 7:
            case 8:
                arrayLogic = new ArrayLogic(array1int, functionCode);
                resultArray = arrayLogic.getResultArray();
                break;
            case 2:
                try{
                value = Integer.parseInt(valueText.getText());
                if (value <= 0 || value > 99){
                    errorValue.setVisible(true);
                    return;
                }
                else if (errorValue.isVisible())
                    errorValue.setVisible(false);
                }
                catch(Exception e){
                   errorValue.setVisible(true);
                   return;
                }
                arrayLogic = new ArrayLogic(array1int, value, OPERANDS[radioFxCode], functionCode);
                resultArray = arrayLogic.getResultArray();
                break;
            case 5:
            case 6:
                arrayLogic = new ArrayLogic(array1int, array2int, functionCode);
                resultArray = arrayLogic.getResultArray();
                break;
        }
        
        //Write numbers to resultString:
        for (int i=0; i<resultArray.length; i++){
            if(i<resultArray.length-1)
                resultString = resultString + resultArray[i] + ",";
            else
                resultString = resultString + resultArray[i];
        }
        
        switch(functionCode){
            case 3:
            case 4:
                resultText.setText(Integer.toString(resultArray[0]));
                break;
            case 1:
            case 2:
            case 5:
            case 6:    
            case 7:
            case 8:
                resultText.setText(resultString);
                break;
        }
    }
    
    public void errorMessage(){
        if (inputError){
            mainPane.setDisable(true);
            mainPane.setVisible(false);
            errorPane.setVisible(true);
            errorPane.setDisable(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
