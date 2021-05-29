package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;

public class AccountDAO {

    // データベース接続に使用する情報
    private final String JDBC_URL = "jdbc:mysql://172.16.71.104:3306/management";
    private final String DB_USER = "user18";
    private final String DB_PASS = "user18pass";

    public AccountDAO() {

        // JDBCドライバのクラスをロード
        try {
            // JDBCドライバのクラスをロード
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO 自動生成された catch ブロック
            e1.printStackTrace();
        }
    }

    public Login findByLogin(Login login) {
        Login account = null;

        // データベースへ接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

            // SELECT文の準備
            String sql = "SELECT USER_ID,PASS FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);


            // INSERT文の「?」に使用する値を設定しSQLを完成
            pStmt.setString(1, login.getUserID());
            pStmt.setString(2, login.getPass());


            // SELECTを実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();


            // 一致したユーザーが存在した場合
            // そのユーザーを表すAccountインスタンス生成
            if (rs.next()) {
                // 結果表からデータを取得
                String userID = rs.getString("USER_ID");
                String pass = rs.getString("PASS");

                account = new Login(userID, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        // 見つかったユーザーまたはnullを返す
        return account;
    }
}
