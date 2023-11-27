
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		 PrintWriter out=response.getWriter();
		  String user_name=request.getParameter("uname");
		  String password=request.getParameter("psw");  
		  String email=request.getParameter("mail"); 
		  String gender=request.getParameter("gender");
		  String address=request.getParameter("addrs");
		  String country=request.getParameter("country");  
		  try  
		  {
		   Class.forName("oracle.jdbc.driver.OracleDriver");  
		   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ghdb","ghdb");
		   PreparedStatement ps=con.prepareStatement("Insert into exam values(?,?,?,?,?,?)");
		   ps.setString(1,user_name);   
		   ps.setString(2,password);
		   ps.setString(3, email);
		   ps.setString(4, gender);
		   ps.setString(5, address);
		   ps.setString(6, country);
		   
		   int i=ps.executeUpdate();
		   out.print(i+"New user register successfully");		   
		   //response.sendRedirect("home.html");
		   con.close();   
		   }
		  catch(Exception ex)  {
		   out.print(ex);  
		   }
	}

}
