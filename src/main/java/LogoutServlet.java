import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalidate the session (log out the user)
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Respond with a JSON message (optional)
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String message = "{\"message\": \"Logout successful\"}";
        response.getWriter().write(message);
    }
}
