package step3;

import java.util.Random;

/*
 * # 랜덤학생[문제]
 * 1. 10회 반복을 한다.
 * 2. 1~100 사이의 랜덤 숫자를 저장한다.
 * 3. 위 숫자가 60점 이상이면, 합격생이다.
 * ------------------------------
 * 4. 10명 학생의 총점과 평균을 출력한다.
 * 5. 합격생 수를 출력한다.
 * 6. 1등학생의 번호와 성적을 출력한다.
 * 
 * 예) 87 11 92 42 100 23 68 33 8 75
 * [1] 총점 = 539점
 * [2] 평균 = 53.9점
 * [3] 합격생 수 = 5명
 * [4] 1등 = 100점(5번)
 */

public class Ex03 {
	public static void main(String[] args) {
		Random r = new Random();
		int[] arr = new int[10];
		int max = 0;
		int maxIdx = 0;
		int count = 0;
		int hap = 0;
		
		for (int i = 0; i < 10; i++) {
			arr[i] = r.nextInt(100) + 1;
			if(max < arr[i]) {
				max = arr[i];
				maxIdx = i;
			}
			if(arr[i] >= 60) {
				count ++;
			}
			hap += arr[i];
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n총점 == " + hap+"점" );
		System.out.println("평균 == " + (double)hap / arr.length + "점");
		System.out.println("합경생 수 == " + count +"명");
		System.out.println("1등 == " + arr[maxIdx]+"점("+maxIdx+"번)");
		

	}
}
