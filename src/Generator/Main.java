package Generator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {
    Button generatePassword;
    Button copyPassword;
    ChoiceBox passwordLength;
    Label length;
    Label password;
    Clipboard clip = Clipboard.getSystemClipboard();
    ClipboardContent content = new ClipboardContent();

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Password Generator");
        generatePassword = new Button("Generate Password");
        copyPassword = new Button(("Copy Password"));
        length = new Label("Choose password length: ");
        passwordLength = new ChoiceBox();
        password = new Label();
        for (int i = 8; i <= 18; i++){
            passwordLength.getItems().add(i);
        }
        passwordLength.getSelectionModel().selectFirst();
        length.setLayoutX(111);
        length.setLayoutY(60);
        passwordLength.setLayoutX(155);
        passwordLength.setLayoutY(80);
        generatePassword.setLayoutX(120);
        generatePassword.setLayoutY(120);

        generatePassword.setOnAction(this);
        copyPassword.setOnAction(this);

        Pane layout = new Pane();
        password.layoutXProperty().bind(layout.widthProperty().subtract(password.widthProperty()).divide(2));
        password.setLayoutY(160);
        password.setFont(new Font(33));
        copyPassword.setLayoutX(130);
        copyPassword.setLayoutY(220);
        layout.getChildren().addAll(generatePassword, passwordLength, length, password, copyPassword);
        Scene scene = new Scene(layout, 340, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    @Override
    public void handle(ActionEvent click) {
        if (click.getSource() == generatePassword){
            password.setText(Generator.generatePassword.createPassword((Integer) passwordLength.getValue()).toString());
        }
        if (click.getSource() == copyPassword){
            content.putString(password.getText());
            clip.setContent(content);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
