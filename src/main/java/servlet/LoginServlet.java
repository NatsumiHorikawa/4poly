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
import model.LoginLogic;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // ログイン画面にフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    boolean result = false;
	    String forwardPath ="";
	    
	 // リクエストパラメータを取得
        request.setCharacterEncoding("UTF-8");
        String userID = request.getParameter("userID");
        String pass = request.getParameter("pass");

     // リクエストパラメータの有無のチェック(不正アクセスかどうかのチェック)
        if (userID.equals(null) || userID.length() == 0 || pass.equals(null) || pass.length() == 0 ) {
            //入力値がなかった場合
          forwardPath ="/WEB-INF/jsp/LoginError.jsp";
          
            }else {

     // ログイン処理
        Login login = new Login(userID,pass);
        LoginLogic loginLogic = new LoginLogic();
        result = loginLogic.execute(login);
        
            }

        //ログイン処理の成否によって処理を分岐
        if(result) {//ログイン成功時

            //セッションスコープにユーザーIDを保存
            HttpSession session = request.getSession();
            session.setAttribute("userID", userID);

	    // ログイン成功画面にフォワード
            forwardPath="/WEB-INF/jsp/loginOK.jsp";

        }else {//ログイン失敗時
            //リダイレクト
            //response.sendRedirect("/BookShelf/");
            forwardPath="/webapp/WEB-INF/jsp/LoginError.jsp";
            
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
	}
}
