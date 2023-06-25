package com.jfx.xmloutput.xmloutputfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

import java.util.Optional;

public class MainViewController {
    @FXML
    private TextField transactionRefField;
    @FXML
    private TextField branchSortCodeField;
    @FXML
    private TextField accountNameField;
    @FXML
    private TextField accountBVNTINField;
    @FXML
    private TextField accountTypeField;
    @FXML
    private TextField accountNumberField;
    @FXML
    private TextField amountField;
    @FXML
    private TextField payeeBVNTINField;
    @FXML
    private TextField withdrawalChannelField;
    @FXML
    private TextField chargesField;
    @FXML
    private TextField transactionTimestampField;
    @FXML
    private TextField supportingFileNameField;

    public void onDeleteIndividual(ActionEvent event) {
        chargesField.setText("0.00");
    }

    public void onAddIndividual(ActionEvent event) {
    }

    public void onFinish(ActionEvent event) {
        String transactionRefString = transactionRefField.getText();
        String branchSortCodeString = branchSortCodeField.getText();
        String accountNameString = accountNameField.getText();
        String accountBVNTINString = accountBVNTINField.getText();
        String accountTypeString = accountTypeField.getText();
        String accountNumberString = accountNumberField.getText();
        String amountString = amountField.getText();
        String payeeBVNTINString = payeeBVNTINField.getText();
        String withdrawalChannelString = withdrawalChannelField.getText();
        String chargesString = chargesField.getText();
        String transactionTimestampString = transactionTimestampField.getText();
        String supportingFileNameString = supportingFileNameField.getText();

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to finish?");
        alert.setContentText("Click OK to finish or Cancel to continue editing.");

        ButtonType buttonTypeFinish = new ButtonType("Finish");
        ButtonType buttonTypeCancel = new ButtonType("Cancel");

        alert.getButtonTypes().setAll(buttonTypeFinish, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeFinish) {
            // User clicked Finish button
            // Perform the necessary actions
        } else {
            // User clicked Cancel or closed the dialog
            // Continue editing
        }
    }

    public void onGoToPreviousScene(ActionEvent event) {
    }
}
