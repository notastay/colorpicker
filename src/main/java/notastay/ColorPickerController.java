package notastay;

import javafx.fxml.FXML;
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

}
