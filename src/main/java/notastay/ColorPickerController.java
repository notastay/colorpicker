package notastay;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ColorPickerController {

    @FXML
    Pane colorPanel;
    @FXML
    Slider redSlider;
    @FXML
    Slider greenSlider;
    @FXML
    Slider blueSlider;
    @FXML
    Label hexLabel;
    @FXML
    TextField redTField;
    @FXML
    TextField greenTField;
    @FXML
    TextField blueTField;

    @FXML
    public void initialize() {
        redSlider.valueProperty().addListener((observable, oldValue, newValue)-> updateFromSlider(redSlider, redTField));
        greenSlider.valueProperty().addListener((observable, oldValue, newValue)-> updateFromSlider(greenSlider, greenTField));
        blueSlider.valueProperty().addListener((observable, oldValue, newValue)-> updateFromSlider(blueSlider, blueTField));
        redTField.textProperty().addListener((observable, oldValue, newValue)-> updateFromTField(redTField, redSlider));
        greenTField.textProperty().addListener((observable, oldValue, newValue)-> updateFromTField(greenTField, greenSlider));
        blueTField.textProperty().addListener((observable, oldValue, newValue)-> updateFromTField(blueTField, blueSlider));

        updateColor();
    }

    private void updateFromSlider(Slider slider, TextField textField) {
        int value = (int) slider.getValue();
        textField.setText(String.valueOf(value));
        updateColor();
    }

    private void updateColor() {
        int red=(int) redSlider.getValue();
        int green=(int) greenSlider.getValue();
        int blue=(int) blueSlider.getValue();

        String hexColor= String.format("#%02X%02X%02X", red, green, blue);
        colorPanel.setStyle("-fx-background-color: rgb("+red+","+green+","+blue+");");
        hexLabel.setText(hexColor);
    }

    private void updateFromTField(TextField tField, Slider slider){
        if(isValid(tField.getText())){
            int value= Integer.parseInt(tField.getText());
            if(value<256 && value>=0){
                slider.setValue(value);
                updateColor();
            }else{
                showAlert();
        }
        }else {
            showAlert();
        }
    }

    private boolean isValid(String text){
        try {
            int value = Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void showAlert() {
        Alert alerta= new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("Color Invalido");
        alerta.setContentText("El color debe ser un numero entre 0 y 255");
        alerta.showAndWait();
    }

}
