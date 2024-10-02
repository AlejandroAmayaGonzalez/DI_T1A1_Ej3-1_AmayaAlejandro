package ieslosmontecillos.di_t1a1_ej5_amayaalejandro;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlCircle extends Application {

    CirclePane circle_pane = new CirclePane();

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("ControlCircle");

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);

        Button bt_big = new Button("Agrandar");
        Button bt_small = new Button("Disminuir");

        hbox.getChildren().add(bt_big);
        hbox.getChildren().add(bt_small);

        bt_big.setOnAction( new AgrandarHandler());
        bt_small.setOnAction( new DisminuirHandler());

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(circle_pane);
        borderPane.setCenter(hbox);
        BorderPane.setAlignment(hbox, Pos.BOTTOM_CENTER);

        Scene scene = new Scene(borderPane, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    class CirclePane extends StackPane {
        Circle c = new Circle(50);

        public CirclePane() {
            getChildren().add(c);
            c.setStroke(Color.BLACK);
            c.setFill(Color.WHITE);
        }

        public void aumentar(){
            c.setRadius(c.getRadius() + 2);
        }

        public void disminuir(){
            c.setRadius(c.getRadius() - 2);
        }
    }

    //Manejador para agrandar y disminuir
    class AgrandarHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            circle_pane.aumentar();
        }
    }

    class DisminuirHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            circle_pane.disminuir();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}