package hibernate2;

// Java POJO class to map to the DB 'contact' table

public class Contact
{

	private String firstName;
	private String lastName;
	private String email;
	private int id;
	
	public Contact(){}
	public Contact(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	// GETTERS 
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getEmail()
	{
		return email;
	}
	public int getId()
	{
		return id;
	}

	// SETTERS
	public void setFirstName(String st)
	{
		firstName=st; 
	}
	public void setLastName(String st)
	{
		lastName=st; 
	}
	public void setEmail(String st)
	{
		email=st; 
	}
	public void setId(int i)
	{
		id=i; 
	}
}