import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String q1Answer = request.getParameter("q1");
        String q2Answer = request.getParameter("q2");
        String q3Answer = request.getParameter("q3");
        String q4Answer = request.getParameter("q4");
        String q5Answer = request.getParameter("q5");

        // Process selected answers (save to database, validate, etc.)
        // For simplicity, let's just print the selected answers
        out.println("Selected Answers: ");
        out.println("Question 1: " + q1Answer);
        out.println("Question 2: " + q2Answer);
        out.println("Question 1: " + q3Answer);
        out.println("Question 2: " + q4Answer);
        out.println("Question 1: " + q5Answer);
        
        

        // Redirect to a thank-you page
        response.sendRedirect("thankyou.jsp");

        out.close();
    }
}
