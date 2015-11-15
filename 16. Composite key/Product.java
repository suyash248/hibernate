package hibernate2;

// Java POJO class to map to the DB 'contact' table

public class Product implements java.io.Serializable
{

	private String proName;
	private double proPrice;
	private int proId;
	
	// GETTERS 
	public String getProName()
	{
		return proName;
	}
	
	public double getProPrice()
	{
		return proPrice;
	}
	public int getProId()
	{
		return proId;
	}

	// SETTERS
	public void setProName(String pn)
	{
		proName=pn; 
	}
	public void setProPrice(double p)
	{
		proPrice=p; 
	}
	public void setProId(int i)
	{
		proId=i; 
	}
}