package step7;

import java.util.Scanner;

class Application {
	Manager m = new Manager();
//	public int login_id = 0;
	public Artist loginA = new Artist();

	public Application() {

		m.loadJson("data/artist.json");
	}

	public boolean login(String id, String pw) {
		// 아이디와 비밀번호가 존재하는 사람의 경우 true,
		// 그렇지 않으면 false를 반환
		for (Artist a : m.list) {
			if (a.getUser_id().equals(id)) {
				if (a.getUser_pw().equals(pw)) {
//					login_id = a.getId();
					loginA = a;
					return true;
				}
			}
		}
		return false;
	}

	public void printUserInfo() {

		for (Artist a : m.list) {
			if (a.getId() == loginA.getId()) {
				System.out.println("id : " + a.getId());
				System.out.println("user_id : " + a.getUser_id());
				System.out.println("user_pw : " + a.getUser_pw());
				System.out.println("user_name : " + a.getUser_name());
				System.out.println("user_about : " + a.getUser_about());

			}
		}
		// 현재 로그인된 유저의 정보를 출력한다.(형식은 다음과 같이)
		/*
		 * "id": 9, "user_id": "hoc660115", "user_pw": "Whang1111", "user_name": "황영철",
		 * "user_about": "만천리에 인정받는 그날까지"
		 */
	}

	public void adjustInfo(Artist artist) {
		m.remove(loginA.getUser_id());
		m.add(artist.getUser_id(), artist.getUser_pw(), artist.getUser_name(), artist.getUser_about());
		artist.setId(m.listId);
		m.save();
		loginA = artist;
		System.out.println("수정후 저장 완료");
		
		// 아티스트 정보를 받아서 해당 정보로 수정한다.
		// 자동으로 m.save()를 호출하여 저장한다.
	}

	public void logout() {
		// 로그아웃 처리
		loginA = new Artist();
	}
}

public class Ex03 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean login = false;
		Application app = new Application();

		while (true) {
			System.out.println("==============================");
			if (!login) {
				System.out.println("1. 로그인");
			} else {
				System.out.println("2. 정보보기");
				System.out.println("3. 정보수정");
				System.out.println("4. 로그아웃");
			}
			System.out.println("5. 종료");
			int sel = in.nextInt();
			System.out.println("==============================");
			if (!login) {
				if (sel == 1) {
					System.out.println("로그인하실 id를 입력하세요");
					String id = in.next();
					System.out.println("로그인하실 비밀번호를 입력하세요");
					String pw = in.next();
					if (app.login(id, pw)) {
						System.out.println("성공적으로 로그인 완료");
						login = true;
					} else {
						System.out.println("아이디 또는 비밀번호를 확인해주세요");
					}
				}
			} else {
				if(sel == 2) {
					app.printUserInfo();
				}else if(sel == 3){
					Artist a = new Artist();
					System.out.println("수정하실 id");
					a.setUser_id(in.next());
					System.out.println("수정하실 비번");
					a.setUser_pw(in.next());
					System.out.println("수정하실 이름");
					a.setUser_name(in.next());
					System.out.println("수정하실 어바웃");
					a.setUser_about(in.next());
					app.adjustInfo(a);
					
				}else if(sel == 4) {
					app.logout();
					login = false;
				}

			}
			 if(sel == 5){
					System.out.println("프로그램 종료");
					break;
				}
		}

		/*
		 * 다음과 같이 메뉴를 구성한다. 1. 로그인 => 로그인되지 않은 사람만 뜬다. 2. 정보보기 => 로그인 한 사람만 뜬다. 3. 정보수정
		 * => 로그인 한 사람만 뜬다. 4. 로그아웃 => 로그인 한 사람만 뜬다. 5. 종료
		 */

		// 로그인 후에 정보보기 시
	}
}
