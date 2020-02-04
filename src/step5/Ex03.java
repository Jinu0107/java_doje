package step5;

import java.util.Arrays;
import java.util.Scanner;

// # 관리비[문제]

public class Ex03 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean no = false;
		int max = 0;
		int maxhome = 0;
		int min = 23132132;
		int minhome = 0;
		int[][] apt = {
			{101, 102, 103},	
			{201, 202, 203},	
			{301, 302, 303}	
		};
			
		int[][] pay = {
			{1000, 2100, 1300},	
			{4100, 2000, 1000},	
			{3000, 1600,  800}
		};
		int[] payhap = new int[3];
			
		// 문제 1) 각층별 관리비 합 출력
		// 정답 1) 4400, 7100, 5400
		for(int i=0; i < 3; i++) {
			for(int j =0; j < 3; j++) {
				payhap[i] += pay[i][j];
				if(max < pay[i][j]) {
					max = pay[i][j];
					maxhome = apt[i][j];
				}
				if(min > pay[i][j]) {
					min = pay[i][j];
					minhome = apt[i][j];
				}
				
			}
		}
		System.out.println(Arrays.toString(payhap));
		
		// 문제 2) 호를 입력하면 관리비 출력
		// 예    2) 입력 : 202	관리비 출력 : 2000
		System.out.println("호수 입력");
		int ho = in.nextInt();
		for(int i=0; i < 3; i++) {
			for(int j =0; j< 3; j++) {
				if(apt[i][j] == ho) {
					System.out.println("관리비 출력 : " + pay[i][j]);
					no = true;
					break;
				}
			}
		}
		if(!no) {
			System.out.println("올바르지 않은 호수 입력");
			
		}
		
		// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
		// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)
		System.out.println("가장많이" + maxhome + ", 가장적게 : " +minhome);
		
		
		// 문제 4) 호 2개를 입력하면 관리비 교체
		System.out.println("처음");
		int f = in.nextInt();
		System.out.println("둘째");
		int s = in.nextInt();
		int[][] idxtme = new int[2][2];
		int temppay = 0;
		for(int i=0; i < 3; i++) {
			for(int j =0; j< 3; j++) {
				if(apt[i][j] == f) {
					idxtme[0][0] = i;
					idxtme[0][1] = j;
				}
				if(apt[i][j] == s) {
					idxtme[1][0] = i;
					idxtme[1][1] = j;
				}
			}
			
		}
		
		temppay = pay[idxtme[0][0]][idxtme[0][1]];
		pay[idxtme[0][0]][idxtme[0][1]] = pay[idxtme[1][0]][idxtme[1][1]];
		pay[idxtme[1][0]][idxtme[1][1]] = temppay;
		
		
		for(int i =0; i < 3; i++) {
			for(int j =0; j< 3; j++) {
				System.out.print(pay[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
	}
}
