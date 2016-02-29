package cn.ziyue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class GrabThemAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebpageGraber wg = new WebpageGraber();
		String fileName = "C:/Users/Administrator/Desktop/namelist.txt";
		File file = new File(fileName);
		String tempString = "";
		String answer = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			while ((tempString = reader.readLine()) != null){
				for(int i = 0; i < 50; i++){
					if(!("".equals(answer))){
						break;
					}
					answer = wg.grabByName(tempString.toLowerCase());
				}
//				answer = wg.grabByName(tempString.toLowerCase());
				if(!("".equalsIgnoreCase(answer))){
					System.out.println(answer);
				}
				answer = "";
//				System.out.println(tempString);
			}
			
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
