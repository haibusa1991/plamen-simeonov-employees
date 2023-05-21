package com.employees.controllers;

import com.employees.core.Parser;
import com.employees.model.TableDataEmployeePair;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class WindowController implements Initializable {
    @FXML
    public TableView<TableDataEmployeePair> resultsTable;

    @FXML
    protected void onOpenCsvButtonClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a CSV file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV file", "*.csv"));

        Node eventSource = (Node) event.getSource();
        File file = fileChooser.showOpenDialog(eventSource.getScene().getWindow());

        if (file != null) {
            Parser parser = new Parser(file);
            try {
                ObservableList<TableDataEmployeePair> rows = this.resultsTable.getItems();
                rows.remove(0, rows.size());

                Set<TableDataEmployeePair> employeePairs = parser.getEmployeePairs();

                if(employeePairs.size()==0){
                    this.resultsTable.setPlaceholder(new Label("This file contains no records of people working together."));
                }

                rows.addAll(parser.getEmployeePairs());
            } catch (Exception e) {
                this.resultsTable.setPlaceholder(new Label("No CSV file loaded."));
                showErrorDialog(e.getMessage());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resultsTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("employeeId1"));
        this.resultsTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("employeeId2"));
        this.resultsTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("projectId"));
        this.resultsTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("daysWorked"));
        this.resultsTable.setPlaceholder(new Label("No CSV file loaded."));
    }

    private void showErrorDialog(String message) {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error");
        error.setHeaderText(null);
        error.setContentText(message);
        error.showAndWait();
    }

}