package com.jfx.xmloutput.xmloutputfx;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

import java.io.File;
import java.util.Date;
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
        alert.setHeaderText("Compute to XML");
        alert.setContentText("Click OK to finish or Cancel to continue editing.");

        ButtonType buttonTypeConfirm = new ButtonType("Confirm");
        ButtonType buttonTypeCancel = new ButtonType("Cancel");

        alert.getButtonTypes().setAll(buttonTypeConfirm, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeConfirm) {
            Date date = new Date();
            String convertedDate = date.toString();
            String finishedDate = convertedDate.replaceAll(":", "");
            System.out.println(convertedDate);
            try {
                // Create an instance of the JAXBContext for the target class
                JAXBContext context = JAXBContext.newInstance(XmlTagsDeclaration.class);

                // Create a Marshaller
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                // Create an Unmarshaller
                Unmarshaller unmarshaller = context.createUnmarshaller();

                // Create a XmlTagsDeclaration instance
                XmlTagsDeclaration xmlTagsDeclaration = new XmlTagsDeclaration();

                XmlTagsDeclaration.Header header = new XmlTagsDeclaration.Header();
                header.setDescription("DAILY WITHDRAWAL RETURNS");
                header.setInstitutionCode("90089");
                header.setInstitutionName("COOPERATIVE MORTGAGE BANK");
                header.setReportingDate("2023-05-09");
                xmlTagsDeclaration.setHeader(header);

                XmlTagsDeclaration.BodyPart bodyPart = new XmlTagsDeclaration.BodyPart();
                XmlTagsDeclaration.TransactionItem transactionItem = new XmlTagsDeclaration.TransactionItem();
                bodyPart.setTransactionItem(transactionItem);
                transactionItem.setTransactionRef(transactionRefString);
                transactionItem.setBranchSortCode(branchSortCodeString);
                transactionItem.setAccountName(accountNameString);
                transactionItem.setAccountBvnTin(accountBVNTINString);
                transactionItem.setAccountType(accountTypeString);
                transactionItem.setAccountNumber(accountNumberString);
                transactionItem.setAmount(amountString);
                transactionItem.setPayeeBvnTin(payeeBVNTINString);
                transactionItem.setWithdrawalChannel(withdrawalChannelString);
                transactionItem.setCharges(chargesString);
                transactionItem.setTransactionTimestamp(transactionTimestampString);
                transactionItem.setSupportingFileName(supportingFileNameString);

                xmlTagsDeclaration.setBodyPart(bodyPart);

                // Marshalling (Object to XML)
                File outputFile = new File(finishedDate + ".xml");
                marshaller.marshal(xmlTagsDeclaration, outputFile);
                alert.close();
                System.out.println("Object marshalled to XML successfully.");
            }

            catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            alert.close();
        }
    }

    public void onGoToPreviousScene(ActionEvent event) {
    }
}
