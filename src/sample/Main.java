package sample;

import com.sun.javafx.geom.Rectangle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/*
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
*/

public class Main extends Application {

    StackPane[][] screen_buttons = new StackPane[9][9];

    @Override
    public void start(Stage primaryStage) {

        //container for game


        BorderPane root = new BorderPane();


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        for (int y=0;y<screen_buttons.length;y++) {
            for (int x=0;x<screen_buttons[y].length;x++) {
                screen_buttons[y][x] = new StackPane();
                /*Rectangle rec = new Rectangle(30,30);
                rec.setFill(Color.WHITE);
                rec.setStyle("-fx-arc-height: 10; -fx-arc-width: 10;");*/
                TextField textField = new TextField("");
                //Label label = new Label("0");
               // screen_buttons[y][x].getChildren().addAll(rec, label);
                screen_buttons[y][x].getChildren().addAll( textField);
                textField.setText(x+"");
                grid.add(screen_buttons[y][x], x, y);
            }
        }

    //container for controls
        GridPane controls = new GridPane();

        Button[] function_buttons = new Button[4];
        String[] function_id = {"Hint", "Clear", "Pause", "Check"};
        int pos = 0;
        for (Button b : function_buttons) {
            if (function_id[pos] == "Hint") {
                b = new Button(function_id[pos]);
                controls.add(b, 1, pos+10);
            } else if (function_id[pos] == "Clear"){
                b = new Button(function_id[pos]);
                controls.add(b, 1, pos+10);
            } else if (function_id[pos] == "Pause"){
                b = new Button(function_id[pos]);
                controls.add(b, 1, pos+10);
            } else {
                b = new Button(function_id[pos]);
                controls.add(b, 6, 11);
            }
            b.setStyle("-fx-pref-width: 100px; -fx-pref-height: 50px;");
            pos++;
        }

        Button[] click_buttons = new Button[9];
        pos = 1;
        for (int y=10;y<=12;y++) {
            for (int x=2;x<=4;x++) {
                click_buttons[pos-1] = new Button(Integer.toString(pos));
                controls.add(click_buttons[pos-1], x, y);
                click_buttons[pos-1].setStyle("-fx-pref-width: 50px; -fx-pref-height: 50px;");
                pos++;
            }
        }

        root.setCenter(grid);
        root.setBottom(controls);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}