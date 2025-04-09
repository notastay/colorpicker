module notastay {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens notastay to javafx.fxml;
    exports notastay;
}
