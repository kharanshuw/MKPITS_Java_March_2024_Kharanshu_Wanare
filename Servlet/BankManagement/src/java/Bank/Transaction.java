package Bank;

public class Transaction {

    String idString;
    String dateString;
    String uid_accno;
    String amountString;
    String transaction_typeString;

    public Transaction(String idString, String dateString, String uid_accno, String amountString, String transaction_typeString) {
	this.idString = idString;
	this.dateString = dateString;
	this.uid_accno = uid_accno;
	this.amountString = amountString;
	this.transaction_typeString = transaction_typeString;
    }

    public String getIdString() {
	return idString;
    }

    public void setIdString(String idString) {
	this.idString = idString;
    }

    public String getDateString() {
	return dateString;
    }

    public void setDateString(String dateString) {
	this.dateString = dateString;
    }

    public String getUid_accno() {
	return uid_accno;
    }

    public void setUid_accno(String uid_accno) {
	this.uid_accno = uid_accno;
    }

    public String getAmountString() {
	return amountString;
    }

    public void setAmountString(String amountString) {
	this.amountString = amountString;
    }

    public String getTransaction_typeString() {
	return transaction_typeString;
    }

    public void setTransaction_typeString(String transaction_typeString) {
	this.transaction_typeString = transaction_typeString;
    }

    public Transaction() {
    }


    
}
