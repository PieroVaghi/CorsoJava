package entities;

public class Client extends Person
{
	String email, interests;

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getInterests() 
	{
		return interests;
	}

	public void setInterests(String interests) 
	{
		this.interests = interests;
	}
	
	@Override
	public boolean valid()
	{
		return super.valid() && notVoid(interests) && notVoid(email) && validEmail(email);
	}

	@Override
	public String toString() {
		return "Client [email=" + email + ", interests=" + interests + ", name=" + name + ", surname=" + surname
				+ ", dob=" + dob + ", id=" + id + "]";
	}
	
	
	
	
	
	
}