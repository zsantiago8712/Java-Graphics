package com.szs.javagraphics;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        CategoryAxis yAxis = new CategoryAxis();
        yAxis.setLabel("Palabras");

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Frecuencia");


        BarChart<Number, String> chart = new BarChart<Number, String>(xAxis, yAxis);
        chart.setTitle("Prueba Ventana MFG");
        // agregamos datos
        chart.setData(obtenerDatos());

        // Paneles
        StackPane root = new StackPane();
        root.getChildren().add(chart);

        // Tamaño del Frame
        Scene scene = new Scene(root, 640, 427);

        primaryStage.setTitle("Prueba MFg");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @SuppressWarnings("unchecked")
    public static ObservableList<XYChart.Series<Number, String>> obtenerDatos() {

        Analizer anlz = new Analizer();
        XYChart.Series<Number, String> frecuenciasPalabras = new XYChart.Series<>();
        frecuenciasPalabras.setName("Cantidad Palabras");
        ArrayList<String> words = new ArrayList<String>();
        words = anlz.getWordsList();
        int i = 0;

        for(String word : words) {
            i+= 10;
            frecuenciasPalabras.getData().add(new XYChart.Data<>(i, word));
        }


        /*frecuenciasPalabras.getData().addAll(
                new XYChart.Data<>(358, "Good"),
                new XYChart.Data<>(54, "Feel"),
                new XYChart.Data<>(50, "bad"),
                new XYChart.Data<>(158, "plus"));*/


        ObservableList<XYChart.Series<Number, String>> data = FXCollections.observableArrayList();
        data.addAll(frecuenciasPalabras);

        return data;
    }

    public static void main(String[] args) {
        launch();
    }
}





