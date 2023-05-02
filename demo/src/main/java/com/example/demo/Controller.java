package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label text1;
    @FXML
    private Label text2;
    @FXML
    private Label text3;
    @FXML
    private Label text4;
    @FXML
    private Label text5;
    @FXML
    private TextField bField;
    @FXML
    private TextField step;
    @FXML
    private TextField end;
    @FXML
    private TextField begin;
    @FXML
    private Label welcomeText;
    Tabulate tabulate;
    Point point;
    int stepCount;
    double maximum;
    double minimum;
    double sum;
    double average;

    public void initialize (){
    tabulate= new Tabulate();


    }

    private void init () {
       try {
           double a = Double.parseDouble(begin.getText());
           double b = Double.parseDouble(end.getText());
           double h = Double.parseDouble(step.getText());
           double b1 = Double.parseDouble(bField.getText());
           stepCount = tabulate.calculateStepCount(a, b, h);
           point = new Point(stepCount);
           point.setX(tabulate.createXArray(a,b,h));
           point.setY(tabulate.createYArray(b1,point.getX()));
           maximum = tabulate.findMaxIndex(point.y);
           minimum= tabulate.findMinIndex(point.x);
           sum=tabulate.calculateSum(point.y);
           average= tabulate.calculateAverage(point.y);
       }
       catch (NumberFormatException error){
           showAlertWithHeaderText();
       }

    }

    public void onCountButtonClick(ActionEvent actionEvent) {
        init ();
    text1.setText("кількість кроків табуляції="+stepCount);

    }

    public void onMaxButtonClick(ActionEvent actionEvent) {
        init ();
text2.setText("максимальне значення="+maximum);
    }

    public void onMinButtonClick(ActionEvent actionEvent) {
        text3.setText("мінімальне значення="+minimum);
    }

    public void onSumButtonClick(ActionEvent actionEvent) {
        text4.setText("сума елементів="+sum);
    }

    public void onAverageButtonClick(ActionEvent actionEvent) {
        text5.setText("середнє арифметичне="+average);
    }
    private void showAlertWithHeaderText() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Results:");
        alert.setContentText("uncorrected data");

        alert.showAndWait();
    }
}