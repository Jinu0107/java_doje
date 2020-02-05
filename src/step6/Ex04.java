package step6;

import java.util.Scanner;

/*
 * # 영화관 좌석예매[문제]
 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
 * 4. 한 좌석당 예매 가격은 12000원이다.
 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
 * 
 * 좌석예매는 행(알파벳)과 열(숫자)을 입력받아서 예매를 한다.
 *    0  1  2  3  4 
 * A  1  0  0  0  0
 * B  0  1  0  0  0
 * C  1  1  0  0  0
 * D  0  0  0  0  0
 * E  0  0  0  0  0
 * 
 * 예매할 행과 열을 입력하세요.
 * 
 */

class Movie {
	int[][] seat = new int[5][5]; // 25개의 자리
	String[] abc = { "A", "B", "C", "D", "E" };
	int money = 0;

	public boolean setSeat(String row, int col) {
		// 좌석 예매 매서드
		// 성공시 true, 실패시 false를 반환
		int r = -1;
		if (row.equals("A") || row.equals("a")) {
			r = 0;
		} else if (row.equals("B") || row.equals("b")) {
			r = 1;
		} else if (row.equals("C") || row.equals("c")) {
			r = 2;
		} else if (row.equals("D") || row.equals("d")) {
			r = 3;
		} else if (row.equals("E") || row.equals("e")) {
			r = 4;
		} else {
			System.out.println("없는 좌삭띠");
			return false;
		}
		if (seat[r][col] == 1) {
			System.out.println("중복된 좌석띠");
			return false;
		}
		System.out.println("예매가 성공적 완료띠");
		seat[r][col] = 1;
		money += 12000;
		return true;

	}

	public void printResult() {
		// 영화관 현재 총매출액을 출력하는 매서드
		System.out.println("매출액 : " + money);
	}

	public void printSeat() {
		System.out.println("  0 1 2 3 4");
		for (int i = 0; i < 5; i++) {
			System.out.print(abc[i] + " ");
			for (int j = 0; j < 5; j++) {
				System.out.print(seat[i][j] + " ");
			}
			System.out.println();
		}
		// 영화관의 현재 좌석 예매 현황을 출력하는 매서드
	}
}

public class Ex04 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Movie mega = new Movie();

		while (true) {

			System.out.println("[MEGA MOVIE]");
			System.out.println("[1]좌석예매");
			System.out.println("[2]종료하기");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				mega.printSeat();
				System.out.println("열입력");
				int a = scan.nextInt();
				System.out.println("행입력");
				String b = scan.next();
				mega.setSeat(b, a);
			} else if (sel == 2) {
				mega.printResult();
				break;
			}
		}

		scan.close();

	}
}
