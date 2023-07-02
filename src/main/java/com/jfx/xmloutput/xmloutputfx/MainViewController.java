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
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

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

    LocalDate localDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    String formattedDate = localDate.format(formatter);

    public void onDeleteIndividual(ActionEvent event) {
        transactionRefField.setText("");
        branchSortCodeField.setText("");
        accountNameField.setText("");
        accountBVNTINField.setText("");
        accountTypeField.setText("");
        accountNumberField.setText("");
        amountField.setText("");
        payeeBVNTINField.setText("");
        withdrawalChannelField.setText("");
        chargesField.setText("");
        transactionTimestampField.setText("");
        supportingFileNameField.setText("");
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
        alert.setContentText("Click Confirm to finish or Cancel to continue editing.");

        ButtonType buttonTypeConfirm = new ButtonType("Confirm");
        ButtonType buttonTypeCancel = new ButtonType("Cancel");

        alert.getButtonTypes().setAll(buttonTypeConfirm, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeConfirm) {
            try {
                // Create an instance of the JAXBContext for the target class
                JAXBContext context = JAXBContext.newInstance(XmlTagsDeclaration.class);

                // Create a Marshaller
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                //Creating List to hold each Individual object
                List<XmlTagsDeclaration> individual = new ArrayList<>();

                XmlTagsDeclaration.Header header = new XmlTagsDeclaration.Header();
                header.setDescription("DAILY WITHDRAWAL RETURNS");
                header.setInstitutionCode("90089");
                header.setInstitutionName("COOPERATIVE MORTGAGE BANK");
                header.setReportingDate(String.valueOf(LocalDate.now()));

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

                XmlTagsDeclaration xmlTagsDeclaration1 = new XmlTagsDeclaration();
                xmlTagsDeclaration1.setHeader(header);
                xmlTagsDeclaration1.setBodyPart(bodyPart);

                individual.add(xmlTagsDeclaration1);

                XmlTagsDeclaration xmlTagsDeclaration = new XmlTagsDeclaration();
                xmlTagsDeclaration.setIndividual(individual);

                // Marshalling (Object to XML)
                File outputFile = new File(formattedDate + ".xml");
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
}
