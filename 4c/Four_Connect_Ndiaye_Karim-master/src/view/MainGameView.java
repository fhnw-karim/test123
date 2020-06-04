package view;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Board;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static model.Board.COLUMNS;


public class MainGameView extends BorderPane {


    private Stage stage;
    private BorderPane root;



    public MainGameView(Stage stage) {

        this.root = new BorderPane();
        this.stage = stage;

    }
    public void startGame(String player1,String player2) {
        this.setId("FC_View");

        Board gameBoard = new Board();
        gameBoard.primary_stage =stage;
        gameBoard.player1 = player1;
        gameBoard.player2 = player2;
        BorderPane rootPane = new BorderPane();



        Pane root = new Pane();
        root.getChildren().add(gameBoard.discRoot);

        Shape gridShape = gameBoard.generateBoard();


        rootPane.setBackground(new Background(new BackgroundFill(Color.rgb(0, 212, 255,1), CornerRadii.EMPTY, Insets.EMPTY)));

        root.getChildren().add(gridShape);

        root.getChildren().addAll(gameBoard.makeColumns());

        rootPane.getChildren().addAll(root);

        Scene scene = new Scene(rootPane, (gameBoard.COLUMNS + 1) * gameBoard.TILE_SIZE, (gameBoard.ROWS + 1) * gameBoard.TILE_SIZE);
        stage.setScene(scene);
        stage.setTitle("Main Game");
        stage.show();
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }




}



/**

 GridPane grid = new GridPane();
 grid.setHgap(10);
 grid.setVgap(10);





 //gererate my circles, later they should be white and then turn yellow/red when clicked
 //Put into Board or field class.. whatever fits!
 int column = 0;
 for (int i = 0; i < 7; i++) {
 for (int j = 0; j < 6; j++) {
 Circle c = new Circle(40);
 grid.add(c, column, j);
 c.setId("circleID");
 }
 column++;
 }


 }


 public void stop(){
 stage.hide();
 }


 public void startGame(){
 Scene scene = new Scene(grid, 550, 640);
 stage.setScene(scene);
 stage.setResizable(false);
 stage.setTitle("Four_Connect by Karim");
 stage.show();

 */