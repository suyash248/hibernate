// We are inserting a record in a table by calling the procedure of that database.

import java.sql.*;
import java.io.*;
class Callp
{
	public static void main(String... w)
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","permanent");
			Statement s=c.createStatement();
			CallableStatement cs=c.prepareCall("{call GetMail(?,?,?,?)}");
			cs.setInt(1,123);
			cs.setString(2,"india");
			cs.setString(3,"bharat");
			cs.setString(4,"hindustan@gmail.com");
			cs.executeUpdate();
			ResultSet result1=s.executeQuery("select * from contact");
			while(result1.next())
			{
				System.out.println(result1.getString(1));
				System.out.println(result1.getString(2));
				System.out.println(result1.getString(3));
				System.out.println(result1.getString(4));
			}
		}catch(Exception e){System.out.println(e);}
	}
}


/*  

SQL query for creating the procedure-
create procedure recins65(id in emp13.id%type,name in emp13.name%type) as
  begin
  insert into emp13
  values(id,name);
  end;
  /



ANOTHER procedure -
create or replace procedure GetMail (id in contact.id%type,firstname contact.firstname%type,lastname contact.lastname%type,email contact.email%type) as
  begin
  insert into contact
  values(id,firstname,lastname,email);
  end;
/


drop procedure GetMail;	// drop procedure



begin
  GetMail(4,'sunny','soni','suyash248');     // for executing/calling stored procedure in oracle
end;

*/