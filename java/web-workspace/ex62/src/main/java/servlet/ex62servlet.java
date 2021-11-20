package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ex62servlet
 */
@WebServlet("/ex62")
public class ex62servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ex62servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int min = 0;
		int max = 9;

		Random random = new Random();

		// 0から9までの乱数発生
		int value = random.nextInt(max + min) + min;
		if(value % 2 == 0) { // 偶数はforwarded.jspへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("forwarded.jsp");
			dispatcher.forward(request, response);
		}else {	// 奇数はredirected.jspへリダイレクト
			response.sendRedirect("redirected.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
