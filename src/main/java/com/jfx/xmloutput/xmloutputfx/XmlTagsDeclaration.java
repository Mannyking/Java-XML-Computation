package com.jfx.xmloutput.xmloutputfx;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.List;

public class XmlTagsDeclaration {
    @XmlElementWrapper(name = "WITHDRAWALREPORTS")
    @XmlElement(name = "WITHDRAWALREPORT")
    private List<XmlTagsDeclaration> individual;
    @XmlElement(name = "HEADER")
    private Header header;
    @XmlElement(name = "BODY")
    private BodyPart bodyPart;

    public List<XmlTagsDeclaration> getIndividual() {
        return individual;
    }

    public void setIndividual(List<XmlTagsDeclaration> newIndividual) {
        this.individual = newIndividual;
    }

    public void getHeader(){

    }
    public void setHeader(Header newHeader) {
        this.header = newHeader;
    }

    public void getBodyPart(){

    }
    public void setBodyPart(BodyPart newBodyPart) {
        this.bodyPart = newBodyPart;
    }

    public static class Header {
        @XmlElement(name = "WITHDRAWALREPORT_DESC")
        private String description;
        public String getDescription(){
            return description;
        }
        public void setDescription(String newDescription) {
            this.description = newDescription;
        }

        @XmlElement(name = "INSTITUTION_CODE")
        private String institutionCode;
        public void getInstitutionCode(){

        }
        public void setInstitutionCode(String newInstitutionCode) {
            this.institutionCode = newInstitutionCode;
        }

        @XmlElement(name = "INSTITUTION_NAME")
        private String institutionName;
        public void getInstitutionName(){

        }

        public void setInstitutionName(String newInstitutionName) {
            this.institutionName = newInstitutionName;
        }

        @XmlElement(name = "REPORTING_DATE")
        private String reportingDate;
        public void getReportingDate(){

        }

        public void setReportingDate(String newReportingDate) {
            this.reportingDate = newReportingDate;
        }
    }

    public static class BodyPart {
        @XmlElement(name = "TRANSACTIONITEM")
        private TransactionItem transactionItem;

        public TransactionItem getTransactionItem() {
            return transactionItem;
        }

        public void setTransactionItem(TransactionItem newTransactionItem) {
            this.transactionItem = newTransactionItem;
        }
    }

    public static class TransactionItem {
        @XmlElement(name = "TransactionRef")
        private String transactionRef;

        @XmlElement(name = "BranchSortCode")
        private String branchSortCode;

        @XmlElement(name = "AccountName")
        private String accountName;

        @XmlElement(name = "Account_BVN_TIN")
        private String accountBvnTin;

        @XmlElement(name = "AccountType")
        private String accountType;

        @XmlElement(name = "AccountNumber")
        private String accountNumber;

        @XmlElement(name = "Amount")
        private String amount;

        @XmlElement(name = "Payee_BVN_TIN")
        private String payeeBvnTin;

        @XmlElement(name = "WithdrawalChannel")
        private String withdrawalChannel;

        @XmlElement(name = "Charges")
        private String charges;

        @XmlElement(name = "TransactionTimestamp")
        private String transactionTimestamp;

        @XmlElement(name = "SupportingFileName")
        private String supportingFileName;

        public void setTransactionRef(String newTransactionRef){
            this.transactionRef = newTransactionRef;
        }

        public void setBranchSortCode(String newBranchSortCode){
            this.branchSortCode = newBranchSortCode;
        }

        public void setAccountName(String newAccountName) {
            this.accountName = newAccountName;
        }

        public void setAccountBvnTin(String newAccountBvnTin) {
            accountBvnTin = newAccountBvnTin;
        }

        public void setAccountType(String newAccountType) {
            accountType = newAccountType;
        }

        public void setAccountNumber(String newAccountNumber) {
            accountNumber = newAccountNumber;
        }

        public void setAmount(String newAmount) {
            amount = newAmount;
        }

        public void setPayeeBvnTin(String newPayeeBvnTin) {
            payeeBvnTin = newPayeeBvnTin;
        }

        public void setWithdrawalChannel(String newWithdrawalChannel) {
            withdrawalChannel = newWithdrawalChannel;
        }

        public void setCharges(String newCharges) {
            charges = newCharges;
        }

        public void setTransactionTimestamp(String newTransactionTimestamp) {
            transactionTimestamp = newTransactionTimestamp;
        }

        public void setSupportingFileName(String newSupportingFileName) {
            supportingFileName = newSupportingFileName;
        }
    }
}
