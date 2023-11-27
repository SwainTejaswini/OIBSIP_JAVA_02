

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		String address=request.getParameter("addr");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ghdb","ghdb");
	        PreparedStatement ps=con.prepareStatement("update exam set password=?,email=?,address=? where user_name=?");	
		   
		    ps.setString(1,password);
		    ps.setString(2,email);
		    ps.setString(3,address);
		    ps.setString(4,user_name);
		    
		int i=ps.executeUpdate();
		out.print(i+" User Updated Successfully");
		con.close();
		}
		catch(Exception e)
		{
			out.print(e);
		}


	}

}
