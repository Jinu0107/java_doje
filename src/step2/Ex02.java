package step2;

import java.util.Scanner;

/*
 * # 놀이기구 이용제한[문제]
 * 1. 키를 입력받는다.
 * 2. 키가 110 이상이면, 놀이기구 이용이 가능하다.
 * 3. 키가 110 미만이면, 놀이기구를 이용할 수 없다.
 * 4. 단, 부모님과 함께 온 경우에는 놀이기구를 이용할 수 있다.
 * 5. 부모님과의 동행여부를 1(yes) 또는 0(no)을 입력받아 확인한다.
 */

public class Ex02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("키");
		int key = in.nextInt();
		System.out.println("동행여부");
		int bumo = in.nextInt();

		if (key >= 110) {
			System.out.println("이용가능");
		}else if(key < 110 && bumo == 1) {
			System.out.println("이용가능");
		}else {
			System.out.println("이용 불가");
		}
	}
}
