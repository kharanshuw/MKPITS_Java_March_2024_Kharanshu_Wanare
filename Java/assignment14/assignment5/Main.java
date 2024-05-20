package contactListApplication;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactListApplication contactListApplication=new ContactListApplication();
		Contact contact=new Contact(1,"abc",9999999,"abc@gmail.com");
		contactListApplication.addcontact(contact);
		contactListApplication.display();
		contactListApplication.removeById(1);
		contactListApplication.display();
		
	}

}
