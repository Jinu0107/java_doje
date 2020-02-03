package step2;

import java.util.Scanner;

/*
 * # ATM[문제]
 * [1]로그인
 * . 계좌번호와 비밀번호를 입력받아 로그인을 처리한다.
 * . 이미 로그인 된 상태에서 다시 이용할 수 없다.
 * [2]로그아웃
 * . 로그아웃 상태에서 이용할 수 없다.
 * [3]입금
 * . 로그인 상태에서 이용할 수 있다.
 * . 입금할 금액을 입력받아 입금을 진행한다.
 * [4]출금
 * . 로그인 상태에서 이용할 수 있다.
 * . 출금할 금액이 계좌잔액을 초과할 경우 출금을 진행할 수 없다.
 * [5]이체
 * . 로그인 상태에서 이용할 수 있다.
 * . 이체할 계좌번호를 입력받아 처리한다.
 * . 이체할 금액이 계좌잔액을 초과할 경우 이체를 진행할 수 없다.
 * [6]잔액조회
 * . 로그인 상태에서 이용할 수 있다.
 * . 로그인 된 회원의 계좌잔액을 출력한다.
 */

public class Ex03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String acc1 = "gondr";
		String pw1 = "1234";
		int money1 = 10000;

		String acc2 = "yydh";
		String pw2 = "1234";
		int money2 = 20000;

		/*
		 * 이곳에 필요한 변수를 선언하세요. (Hint. 로그인상태를 저장하거나 누가 로그인되었는지를 저장하는 변수가 필요합니다.)
		 */
		boolean login = false;
		String loginId = "";

		while (true) {
			System.out.println("[MEGA ATM]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]입금");
			System.out.println("[4]출금");
			System.out.println("[5]이체");
			System.out.println("[6]잔액조회");
			System.out.println("[0]종료");

			System.out.print("메뉴를 선택하세요 : ");
			int sel = scan.nextInt();

			/* 아래의 중괄호에 알맞은 코드를 작성하세요 */
			if (sel == 1) {
				if (login) {
					System.out.println("이미 로그인 되어 있습니다.");
					continue;
				}
				System.out.println("로그인 하실 아이디를 입력하세요");
				String id = scan.next();
				System.out.println("로그인 하실 비밀번호를 입력하세요");
				String pass = scan.next();
				if ((id.equals(acc1) && pass.equals(pw1)) || (id.equals(acc2) && pass.equals(pw2))) {
					System.out.println("성공적으로 로그인 되었습니다.");
					login = true;
					loginId = id;
				} else {
					System.out.println("아이디 혹은 비밀번호를 확인해주세요");
					continue;
				}
			} else if (sel == 2) {
				if (login) {
					login = false;
					System.out.println("성공적으로 로그아웃 됐습니다.");
				} else {
					System.out.println("이미 로그아웃 돼 있습니다.");
				}
			} else if (sel == 3) {
				if (!login) {
					System.out.println("로그인상태에서 이용하실 수 있습니다.");
					continue;
				}
				System.out.println("입금하실 금액을 입력하세요");
				int money = scan.nextInt();
				if (loginId.equals(acc1)) {
					money1 += money;
					System.out.println("입금이 완료되었습니다.");
					System.out.println("남은 잔액 : " + money1);
				} else {
					money2 += money;
					System.out.println("입금이 완료되었습니다.");
					System.out.println("남은 잔액 : " + money2);
				}
			} else if (sel == 4) {
				if (!login) {
					System.out.println("로그인상태에서 이용하실 수 있습니다.");
					continue;
				}
				System.out.println("출금하실 금액을 입력하세요");
				int money = scan.nextInt();
				
				if (loginId.equals(acc1)) {
					if(money > money1) {
						System.out.println("출금할 돈이 없습니다.");
						continue;
					}
					money1 -= money;
					System.out.println("출금이 완료되었습니다.");
					System.out.println("남은 잔액 : " + money1);
				} else {
					if(money > money2) {
						System.out.println("출금할 돈이 없습니다.");
						continue;
					}
					money2 -= money;
					System.out.println("출금이 완료되었습니다.");
					System.out.println("남은 잔액 : " + money2);
				}

			} else if (sel == 5) {
				if (!login) {
					System.out.println("로그인상태에서 이용하실 수 있습니다.");
					continue;
				}
				System.out.println("이체하실 금액을 입력하세요");
				int money = scan.nextInt();
				System.out.println("이체하실 계좌번호를 입력하세요");
				String toss = scan.next();
				if (toss.equals(loginId)) {
					System.out.println("자신의 계좌로는 이체가 불가능합니다");
					continue;
				}
				if (loginId.equals(acc1)) {
					if(money > money1) {
						System.out.println("출금할 돈이 없습니다.");
						continue;
					}
					money1 -= money;
					money2 += money;
					System.out.println("출금이 완료되었습니다.");
					System.out.println("남은 잔액 : " + money1);
				} else {
					if(money > money2) {
						System.out.println("출금할 돈이 없습니다.");
						continue;
					}
					money2 -= money;
					money1 += money;
					System.out.println("출금이 완료되었습니다.");
					System.out.println("남은 잔액 : " + money2);
				}
			} else if (sel == 6) {
				if (!login) {
					System.out.println("로그인상태에서 이용하실 수 있습니다.");
					continue;
				}
				if (loginId.equals(acc1)) {
					
					System.out.println("남은 잔액 : " + money1);
				} else {
					
					System.out.println("남은 잔액 : " + money2);
				}
				
			} else if (sel == 0) {
				System.out.println("[메세지]프로그램 종료");
				break;
			}

		}

		scan.close();
	}
}
