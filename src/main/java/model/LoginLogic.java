package model;

import dao.AccountDAO;

public class LoginLogic {

    public boolean execute(Login login) {
        AccountDAO dao = new AccountDAO();
        Login  account = dao.findByLogin(login);
        return account != null;
    }

}
