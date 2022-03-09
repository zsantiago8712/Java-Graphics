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


public class HelloApplication  extends Application{

    @Override
    public void start(Stage primaryStage) throws IOException {

        CategoryAxis yAxis = new CategoryAxis();
        Files file = new Files();
        Analizer anlz = new Analizer();
        ArrayList<String> tweets = new ArrayList();
        ArrayList<String> wordsToSearch = new ArrayList();
        tweets = file.readFile("/Users/randymarsh/Documents/Java-Graphics/NeuralLink_tweets_clean2.csv");
        wordsToSearch = file.readFile("/Users/randymarsh/Documents/Java-Graphics/words.csv");


        yAxis.setLabel("Palabras");

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Frecuencia");


        BarChart<Number, String> chart = new BarChart<Number, String>(xAxis, yAxis);
        chart.setTitle("NeuraLink Tweets");
        // agregamos datos


        tweets = anlz.cleanTweets(tweets);
        chart.setData(setTableData(anlz.countWordsInTweet(tweets, wordsToSearch), wordsToSearch));

        // Paneles
        StackPane root = new StackPane();
        root.getChildren().add(chart);

        // Tamaño del Frame
        Scene scene = new Scene(root, 640, 427);

        primaryStage.setTitle("Prueba MFg");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Setea los datos en las gráfica
     * @param contador
     * @param words
     * @return
     */
    public static ObservableList<XYChart.Series<Number, String>> setTableData(int[] contador, ArrayList<String> words){

        XYChart.Series<Number, String> frecuenciasPalabras = new XYChart.Series<>();
        frecuenciasPalabras.setName("Cantidad Palabras");

        for(int i = 0; i < contador.length; i++){
            frecuenciasPalabras.getData().add(new XYChart.Data<>(contador[i], words.get(i)));
            System.out.println(words.get(i) + " -> " + contador[i]);
        }

        ObservableList<XYChart.Series<Number, String>> data = FXCollections.observableArrayList();
        data.addAll(frecuenciasPalabras);

        return data;
    }

    public static void main(String[] args) { launch();}

}
