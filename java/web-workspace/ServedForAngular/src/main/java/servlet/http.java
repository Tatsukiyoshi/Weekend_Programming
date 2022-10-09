package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class http
 */
@WebServlet("/http")
public class http extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public http() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		response.setContentType("text/html; charset=UTF-8");
		if(name.length() > 0) {
			response.setStatus(HttpServletResponse.SC_OK);
			PrintWriter writer = response.getWriter();
			writer.println("<!DOCTYPE html>");
			writer.println("<html lang=\"ja\">");
			writer.println("<head>");
			writer.println("<meta charset=\"UTF-8\">");
			writer.println("<title>Angularからのリクエスト</title>");
			writer.println("</head>");
			writer.println("<body>");
			writer.println("<p>こんにちは、" + name + "さん</p>");
			writer.println("</body>");
			writer.println("</html>");
			writer.close();
		} else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Http/1.1 500 Internal Service Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
