package step3;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * # 영수증 출력(2단계)[문제]
 * 1. 메뉴판의 번호를 입력받아 주문을 받는다.
 * 2. 계산하기를 선택하면, 영수증을 출력한다. (영수증의 형태는 아래 주석 참조)
 * 3. 영수증에 표기된 금액에 따라 돈을 입력하면 부족하면 부족한 분량만큼의 메시지를 띄운다.
 *  -> 돈이 X원 부족합니다.
 *    남는다면 다음과 같이 잔돈 메시지가 출력된다.
 *  -> 계산후 거스름돈은 X원입니다.
 *  
 *  
 *  영수증은 만약 싸이버거 2개, 감자튀김 3개를 주문했다면 다음과 같이 출력된다.
 *  
 *  -------  영수증  ---------
 *  싸이버거		2개 (6,800원)
 *  감자튀김		3개(5,100원)
 *  =====================
 *  총계			11,900원
 */

public class Ex02 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		DecimalFormat fo = new DecimalFormat("###,###");

		int price1 = 3400;
		int price2 = 4100;
		int price3 = 1700;

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;

		int hap = 0;

		int money = 0;
		while (true) {

			System.out.println("[Moms Burger Menu]");
			System.out.println("[1]싸이버거 : " + price1 + "원");
			System.out.println("[2]포테이토버거 : " + price2 + "원");
			System.out.println("[3]감자튀김 : " + price3 + "원");
			System.out.println("[0]계산하기");
			System.out.print("메뉴를 선택하세요 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				hap += price1;
				count1++;
				System.out.println("[메세지]싸이버거 1개 주문하였습니다.");
			} else if (sel == 2) {
				hap += price2;
				count2++;
				System.out.println("[메세지]포테이토버거 1개 주문하였습니다.");
			} else if (sel == 3) {
				hap += price3;
				count3++;
				System.out.println("[메세지]감자튀김 1개 주문하였습니다.");
			} else if (sel == 0) {
				System.out.println(" -------  영수증  ---------");
				if (count1 != 0) {
					System.out.println("싸이버거          " + count1 + "개(" + fo.format(price1 * count1) + "원)");
				}
				if (count2 != 0) {
					System.out.println("포테이토버거          " + count2 + "개(" + fo.format(price3 * count2) + "원)");
				}
				if (count3 != 0) {
					System.out.println("감자튀김          " + count3 + "개(" + fo.format(price3 * count3) + "원)");
				}
				System.out.println("=====================");
				System.out.println("총계                              " + fo.format(hap) + "원");
				System.out.println("돈을 내세요");
				money = scan.nextInt();
				if (money >= hap) {
					System.out.println("계산후 거스름돈은 " + fo.format(money - hap) + "원입니다");
				} else {
					System.out.println("돈이 " + fo.format(hap - money) + "원 부족합니다");
				}

				break;
			}

		}

		scan.close();
	}

}
