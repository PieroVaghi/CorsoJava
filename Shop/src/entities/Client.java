package entities;

public class Client extends Person {
	
	private String mail, interest;

	public String getMail() {
		return mail;
	}

	public String getInterest() {
		return interest;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return super.toString() + (mail != null ? "mail: " + mail + ",\n" : "") + (interest != null ? "interest: " + interest : "")+ "\n--------------------------------\n";
	}
	
	@Override
	public boolean valid()
	{
		return 
				super.valid()					&&
				mail!=null						&&
				!mail.contains("")				&&
				interest!=null					&&
				!interest.contains("");

	}

}
