package kom.conn.menu;

public class clothsMenu {
	
	public String login() {
		String l = ""
				+ "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n"
				+ "┃           로그인 화면           ┃\n"
				+ "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫\n"
				+ "┃     1.    관리자 회원가입       ┃\n"
				+ "┃     2.      관리자 로그인       ┃\n"
				+ "┃     3.        관리자 삭제       ┃\n"
				+ "┃     4.      프로그램 종료       ┃\n"
				+ "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";
		return l;
	}	
	
	public String loginMenu() {
		String lm = ""
				+ "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n"
				+ "┃            프로그램 선택           ┃\n"
				+ "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫\n"
				+ "┃     1.     재고 관리프로그램       ┃\n"
				+ "┃     2.   거래처 관리프로그램       ┃\n"
				+ "┃     3.              이전화면       ┃\n"
				+ "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";
		return lm;
	}	
	
	public  String programMenu() {
	String s = ""
			+ "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n"
			+ "┃        재고 관리 프로그램       ┃\n"
			+ "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫\n"
			+ "┃     1.          제품 등록       ┃\n"
			+ "┃     2.          제품 수정       ┃\n"
			+ "┃     3.          제품 삭제       ┃\n"
			+ "┃     4.          제품 조회       ┃\n"
			+ "┃     5.           이전화면       ┃\n"
			+ "┃     6.      프로그램 종료       ┃\n"
			+ "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";
	return s;
	}
	
	public String BrandMenu() {
		String b = ""
				+ "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n"
				+ "┃       거래처 관리 프로그램      ┃\n"
				+ "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫\n"
				+ "┃     1.        거래처 등록       ┃\n"
				+ "┃     2.        거래처 수정       ┃\n"
				+ "┃     3.        거래처 삭제       ┃\n"
				+ "┃     4.          이전 메뉴       ┃\n"
				+ "┃     5.      프로그램 종료       ┃\n"
				+ "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";
		return b;
	}
}