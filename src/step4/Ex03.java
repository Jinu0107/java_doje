package step4;

import java.util.Arrays;
import java.util.Scanner;

/*
 * # 배열 컨트롤러(1단계)[문제]
 * 1) 추가 : 맨 끝에 삽입
 * 2) 삭제 : 삭제를 원하는 인덱스를 입력하면 삭제
 * 3) 삽입 : 삽입을 원하는 인덱스와 값을 입력하면 삽입
 * 
 * 주의 : 리스트 사용금지!
 *  
*/

public class Ex03 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {10, 20, 30, 40, 50};
		int[] temp = new int[arr.length]; 
		int cnt = 2;
		
		boolean run = true;
		while(run) {
			System.out.println(Arrays.toString(arr));
			System.out.println("[1]추가");
			System.out.println("[2]삭제");
			System.out.println("[3]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				System.out.print("추가할 값 입력 : ");
				int data = scan.nextInt();
				for(int i=0; i < arr.length; i++) {
					temp[i] = arr[i];
				}
				arr= new int[temp.length+1];
				for(int  i=0; i < arr.length; i++) {
					if(i <arr.length-1) {
						
						arr[i] = temp[i];
					}else {
						arr[i] = data;
					}
					
				}
				temp = new int[arr.length];
				
				
			}
			else if(sel == 2) {
				
				System.out.print("삭제할 위치 입력 : ");
				int idx = scan.nextInt();
				temp = new int[arr.length-1];
				for(int i =0; i < temp.length; i++) {
					if(i >= idx ) {
						temp[i] = arr[i+1];
						
					}else {
						temp[i] = arr[i];
					}
				}
				arr = new int[temp.length];
				for(int i = 0; i< arr.length; i++) {
					arr[i] = temp[i];
				}
			}
			else if(sel == 3) {
				
				System.out.print("삽입할 위치 입력 : ");
				int idx = scan.nextInt();
				
				System.out.print("삽입할 값 입력 : ");
				int data = scan.nextInt();
				temp = new int[arr.length+1];
				for(int i =0; i< temp.length; i++) {
					if(i < idx) {
						temp[i] = arr[i];
					}else if(i == idx) {
						temp[i] = data;
					}else if(i > idx) {
						temp[i] = arr[i-1];
					}
				}
				arr = new int[temp.length];
				
				for(int i =0; i < arr.length; i++) {
					arr[i] = temp[i];
				}
				
			}
			else if(sel == 0) {
				run = false;
				System.out.println("프로그램 종료");
			}
			
		}
		
		scan.close();
		
	}
}
