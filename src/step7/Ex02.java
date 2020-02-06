package step7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//# 아티스트 관리 프로그램 2단계

class Manager {
	public List<Artist> list = new ArrayList<Artist>();
	public int listId = 0;
	
	
	public void loadJson(String filename) {
		// file명을 입력받아서 list 에 넣어준다.
		File file = new File(filename);
		String json = "";
		
		try {

			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;

				}
				json += line;

			}

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(json);
			JsonArray items = element.getAsJsonArray();
			for (JsonElement item : items) {
				Artist a = new Artist();
				listId++;
				a.setId(item.getAsJsonObject().get("id").getAsInt());
				a.setUser_id(item.getAsJsonObject().get("user_id").getAsString());
				a.setUser_pw(item.getAsJsonObject().get("user_pw").getAsString());
				a.setUser_name(item.getAsJsonObject().get("user_name").getAsString());
				a.setUser_about(item.getAsJsonObject().get("user_about").getAsString());
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러 발생");
		}
//		for (Artist a : list) {
//			System.out.println(a);
//		}

	}

	public void add(String user_id, String user_pw, String user_name, String user_about) {
		// 4개의 값을 받아 새로운 유저를 만들어서 list에 넣어준다.
		// 이때 id는 자동으로 증가되어 들어간다. json 파일에 10번까지 있으니 새로운 유저가 들어가면 11번이된다.
		// 이후 추가시에는 12번이 된다.
		Artist a = new Artist();
		listId ++;
		a.setId(listId);
		a.setUser_id(user_id);
		a.setUser_pw(user_pw);
		a.setUser_name(user_name);
		a.setUser_about(user_about);
		
		list.add(a);
		System.out.println("성공적으로추가 완료");
		
		
	}
	public void remove(String user_id) {
		for(int i =0;i < list.size(); i++) {
			if(list.get(i).getUser_id().equals(user_id)) {
				list.remove(i);
			}
		}
		
		
	}
	public void search(String user_name) {
		for(Artist a : list) {
			if(a.getUser_name().contains(user_name)) {
				System.out.println("name : " + a.getUser_name()+ " , about : " + a.getUser_about());
			}
		}
		
	}

	public void save() {
		// 현재 list에 있는 데이터를 artist.json에 다시 저장한다.
		File file = new File("data/artist.json");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			
			JsonArray arr = new JsonArray();
			
			for(Artist a : list) {
				JsonObject o = new JsonObject();
				o.addProperty("id",a.getId() );
				o.addProperty("user_id", a.getUser_id());
				o.addProperty("user_pw", a.getUser_pw());
				o.addProperty("user_name", a.getUser_name());
				o.addProperty("user_about", a.getUser_about());
				
				arr.add(o);
				
			}
			
			fos.write(arr.toString().getBytes());
			
			fos.close();
			System.out.println("파일 기록이 완료되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 쓰기 실패");
		}
	}
}

public class Ex02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Manager m = new Manager();
		m.loadJson("data/artist.json");
		
		
		while(true) {
			
			System.out.println("1.유저 추가");
			System.out.println("2.저장");
			System.out.println("3.삭제");
			System.out.println("4.검색"); 
			
			
			int sel = in.nextInt();
			
			if(sel == 1) {
				System.out.println("아이디 , 비번 , 이름 , 할말");
				String id = in.next();
				String pw = in.next();
				String name = in.next();
				String about= in.next();
				m.add(id, pw, name, about);
			}else if(sel == 2) {
				m.save();
			}else if(sel == 3) {
				System.out.println("삭제할 아디");
				String id = in.next();
				m.remove(id);
			}else if(sel == 4) {
				System.out.println("이름넣어라");
				String name = in.next();
				m.search(name);
			}else {
				System.out.println("종료");
				break;
			}
		}
		// 여기서 유저를 추가할 수 있도록 메뉴를 구성한다
		/*
		 * 1. 유저 추가 2. 저장 3. 삭제 => 삭제할 유저의 user_id를 입력하여 삭제해준다. 3. 검색 4. 종료
		 */
		// 유저 추가의 인터페이스는 자율적으로 하되 4개의 값(id,pw,name, about)을 입력받아 저장해야 한다.
		// 검색시 사용자의 이름을 입력받고 해당 이름이 포함된 사용자를 전부 출력한다. Ex01과 동일함
		// 저장시 m.save가 호출되고 현재 데이터가 저장된다.
		// 저장후 종료하고 다시 실행하면 이전데이터가 그대로 살아있어야 한다.
	}
}
