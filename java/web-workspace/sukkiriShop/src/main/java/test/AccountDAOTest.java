package test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public class AccountDAOTest {

	public static void main(String[] args) {
		// ユーザが見つかる場合のテスト
		testFindByLogin1();
		
		// ユーザが見つからない場合のテスト
		testFindByLogin2();
	}

	// ユーザが見つかる場合のテスト
	private static void testFindByLogin1() {
		Login login = new Login("minato", "1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		
		if(result != null &&
				result.getUserId().equals("minato") &&
				result.getPass().equals("1234") &&
				result.getMail().equals("minato@sukkiri.com") &&
				result.getName().equals("湊 雄輔") &&
				result.getAge() == 23) {
			System.out.println("testFindByLogin1:成功しました");
		} else {
			System.out.println("testFindByLogin1:失敗しました");
		}
	}
	
	// ユーザが見つからない場合のテスト
	private static void testFindByLogin2() {
		Login login = new Login("minato", "12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		
		if(result != null) {
			System.out.println("testFindByLogin2:成功しました");
		} else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}
}
