package contactListApplication;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactListApplication contactListApplication=new ContactListApplication();
		Contact contact1=new Contact(1,"zbc",9999999,"abc@gmail.com");
		Contact contact2=new Contact(1,"d",9999999,"abc@gmail.com");
		Contact contact3=new Contact(1,"a",9999999,"abc@gmail.com");
		Contact contact4=new Contact(1,"c",9999999,"abc@gmail.com");
		contactListApplication.addcontact(contact1);
		contactListApplication.addcontact(contact2);
		contactListApplication.addcontact(contact3);
		contactListApplication.addcontact(contact4);
		contactListApplication.displaybysort();
	}

}
