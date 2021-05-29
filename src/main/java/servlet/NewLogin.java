package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;

/**
 * Servlet implementation class Login
 */
@WebServlet("/NewLogin")
public class NewLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	    String menu = request.getParameter("menu");
	    String forwardPath = "";
	    RequestDispatcher dispatcher = null;

	    switch(menu) {
	    case "1":
	        //新規登録画面へ
	        forwardPath = "WEB-INF/jsp/Resister.jsp";

	        break;

	    case "2":
	        //ログアウト画面へ
	        forwardPath = "WEB-INF/jsp/Logout.jsp";

            break;
	    }
	    dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

	    request.setCharacterEncoding("UTF-8");
        String userID = request.getParameter("userID");
        String pass = request.getParameter("pass");

        Login user = new Login (userID,pass);

        String forwardPath = "";

        if (userID == null || userID.length() == 0 || pass == null || pass.length() == 0 ) {
            //入力値がなかった場合
            forwardPath = "/WEB-INF/jsp/ResisterError.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
            dispatcher.forward(request, response);

        } else {
            //入力値があった場合
            // セッションインスタンスの取得
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            //成功画面へ
            forwardPath = "/WEB-INF/jsp/ResisterOK.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
            dispatcher.forward(request, response);
        }
	}

}
