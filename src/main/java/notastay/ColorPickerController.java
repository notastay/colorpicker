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

}
