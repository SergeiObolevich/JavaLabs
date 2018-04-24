package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.*;
import java.util.concurrent.*;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 850, 150);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        TextField a = new TextField();
        gridpane.add(a, 0, 0);
        gridpane.add(new Label("x^2 +"), 1, 0);

        TextField b = new TextField();
        gridpane.add(b, 2, 0);
        gridpane.add(new Label("x + "), 3, 0);

        TextField c = new TextField();
        gridpane.add(c, 4, 0);
        gridpane.add(new Label("= 0"), 5, 0);

        gridpane.add(new Label("Lower limit: "), 0, 1);
        gridpane.add(new Label("Upper limit: "), 0, 2);

        TextField lowerLimit = new TextField();
        gridpane.add(lowerLimit, 1, 1);

        TextField upperLimit = new TextField();
        gridpane.add(upperLimit, 1, 2);

        Button pickUp = new Button("Pick up");
        gridpane.add(pickUp, 0, 3);

        pickUp.setOnAction(e -> {
            try {
                if (lowerLimit.getText().isEmpty() || upperLimit.getText().isEmpty() || a.getText().isEmpty()
                        || b.getText().isEmpty() || c.getText().isEmpty()) {
                    new Alert(Alert.AlertType.ERROR).showAndWait();
                    return;
                }

                int aValue = Integer.parseInt(a.getText());
                if (aValue < -10000 || aValue > 10000) {
                    String message = "The value of first factor, bigger than 10000 and smaller than -10000, is too hard.";
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Wrong input data!");
                    alert.setContentText("Description: " + message);
                    alert.showAndWait();
                    return;
                }

                int bValue = Integer.parseInt(b.getText());
                if (bValue < -10000 || bValue > 10000) {
                    String message = "The value of second factor, bigger than 10000 and smaller than -10000, is too hard.";
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Wrong input data!");
                    alert.setContentText("Description: " + message);
                    alert.showAndWait();
                    return;
                }

                int cValue = Integer.parseInt(c.getText());
                if (cValue < -10000 || cValue > 10000) {
                    String message = "The value of second factor, bigger than 10000 and smaller than -10000, is too hard.";
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Wrong input data!");
                    alert.setContentText("Description: " + message);
                    alert.showAndWait();
                    return;
                }

                int lowerLimitValue = Integer.parseInt(lowerLimit.getText());
                if (lowerLimitValue < -1000 || lowerLimitValue > 1000) {
                    String message = "The value of lower limit, bigger than 100 and smaller than -100, is too hard.";
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Wrong input data!");
                    alert.setContentText("Description: " + message);
                    alert.showAndWait();
                    return;
                }

                int upperLimitValue = Integer.parseInt(upperLimit.getText());
                if (upperLimitValue < -1000 || upperLimitValue > 1000 || upperLimitValue < lowerLimitValue) {
                    String message = new String();
                    if (upperLimitValue < lowerLimitValue) {
                        message = "The value of upper limit must be bigger that lower limit value.";
                    } else {
                        message = "The value of upper limit, bigger than 300 and smaller than -100, is too hard.";
                    }
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Wrong input data!");
                    alert.setContentText("Description: " + message);
                    alert.showAndWait();
                    return;
                }

                Integer finalResult[] = {};
                finalResult = PickingRoot.picking(aValue, bValue, cValue, lowerLimitValue, upperLimitValue);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Result");
                alert.setHeaderText(Arrays.toString(finalResult));

                alert.showAndWait();
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Exception caught!");
                alert.setContentText("Description: " + exception.getMessage());

                alert.showAndWait();
            }
        });
        root.setCenter(gridpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}