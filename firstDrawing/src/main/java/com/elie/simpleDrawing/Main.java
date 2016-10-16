package com.elie.simpleDrawing;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.stage.Stage;

public class Main extends Application {
    public final double CANVAS_WIDTH = 400;
    public final double CANVAS_HEIGHT = 400;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simple Java Drawing");

        Group rootGroup = new Group();
        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        // Draw a border around the width and height we've set
        drawCanvasAxis(graphics);

        // Drawing the shapes
        drawRandomCircleOnCanvas(graphics);
        drawRandomCircleNoCanvas(rootGroup);
        drawRandomCircleNoCanvasWithBuilder(rootGroup);
        drawRandomSquare(graphics);
        rootGroup.getChildren().add(canvas);
        primaryStage.setScene(new Scene(rootGroup));
        primaryStage.show();
    }

    public void drawCanvasAxis(GraphicsContext graphics) {
        // draw line representing the canvas width
        graphics.strokeLine(0, CANVAS_HEIGHT / 2, CANVAS_WIDTH, CANVAS_HEIGHT / 2);
        graphics.strokeLine(CANVAS_WIDTH / 2, 0, CANVAS_WIDTH / 2, CANVAS_HEIGHT);
    }


    public void drawRandomCircleOnCanvas(GraphicsContext graphics) {
        graphics.fillOval(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, CANVAS_HEIGHT / 4, CANVAS_HEIGHT / 4);
    }

    public void drawRandomCircleNoCanvas(Group rootGroup) {
        Circle circle = new Circle();
        circle.setCenterX(CANVAS_HEIGHT / 2);
        circle.setCenterY(CANVAS_WIDTH / 2);
        circle.setRadius(CANVAS_WIDTH / 10);
        circle.setFill(Color.GREEN);
        rootGroup.getChildren().add(circle);
    }

    public void drawRandomCircleNoCanvasWithBuilder(Group rootGroup) {
        // CircleBuiler seems to be deprecated starting with JavaFX 2
        Circle circleFromBuilder = CircleBuilder.create()
                .centerX(CANVAS_WIDTH/4)
                .centerY(CANVAS_HEIGHT/4)
                .radius(CANVAS_WIDTH/8)
                .fill(Color.PURPLE)
                .build();
        rootGroup.getChildren().add(circleFromBuilder);
    }

    public void drawRandomSquare(GraphicsContext graphics) {

    }
}
