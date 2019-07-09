package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML private Button clickMeButton;

    public void initialize() {
        /* #1 without using lambda */
//        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("You clicked me!");
//            }
//        });

        /* #2 using lambda expression
        * NOTE: we do not use parenthesis if there is only one parameter */
        clickMeButton.setOnAction(actionEvent -> System.out.println("You clicked me!"));
    }
}
