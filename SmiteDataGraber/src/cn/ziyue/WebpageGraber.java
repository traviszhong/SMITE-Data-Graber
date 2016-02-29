package cn.ziyue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebpageGraber {

	public String grabByName(String playerName)throws Exception{
		
		if(!WebpageGraber.isRightForm(playerName)){
			return "";
		}
		int beginIdx;
		int endIdx;
		String resultSeg;
		String result = "";
		String begin;
		String end;
		String line = "";
		String noSpaceLine = "";
		String strURL = "http://www.smitestuff.com/players/" + playerName + "#";
		URL url = new URL(strURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
		BufferedReader bufReader = new BufferedReader(input);
		
		StringBuilder contentBuf = new StringBuilder();
		while ((line = bufReader.readLine()) != null) {
			noSpaceLine = line.replace(" ", "");
			contentBuf.append(noSpaceLine);
		}
		String buf = contentBuf.toString();
		StringBuilder resultBuf = new StringBuilder();
		
		resultBuf.append(playerName + ",");
		
		//Matches
		begin = "otalStatistics</h3></header><sectionclass=\"area\"><ulclass=\"valuestieredhalf\"><li><spanclass=\"value\">";
		end = "</span><spanclass=\"label\">Matches</span>";
		beginIdx = buf.indexOf(begin);
		endIdx = buf.indexOf(end);
		if(beginIdx < 0 || endIdx<0){
			result = "";
			return result;
		}
		resultSeg = buf.substring(beginIdx + begin.length(), endIdx);
		resultBuf.append(resultSeg + ",");
		
		//Wins
		begin = "</span><spanclass=\"label\">Matches</span></li><li><spanclass=\"value\">";
		end = "</span><spanclass=\"label\">Wins";
		beginIdx = buf.indexOf(begin);
		endIdx = buf.indexOf(end);
		if(beginIdx < 0 || endIdx<0){
			result = "";
			return result;
		}
		resultSeg = buf.substring(beginIdx + begin.length(), endIdx);
		resultBuf.append(resultSeg + ",");
		
		//Losses
		begin = "Wins</span></li><li><spanclass=\"value\">";
		end = "</span><spanclass=\"label\">Losses";
		beginIdx = buf.indexOf(begin);
		endIdx = buf.indexOf(end);
		if(beginIdx < 0 || endIdx<0){
			result = "";
			return result;
		}
		resultSeg = buf.substring(beginIdx + begin.length(), endIdx);
		resultBuf.append(resultSeg + ",");
		
		//Kills
		begin = "Losses</span></li></ul><ulclass=\"valuestieredhalf\"><li><spanclass=\"value\">";
		end = "</span><spanclass=\"label\">Kills";
		beginIdx = buf.indexOf(begin);
		endIdx = buf.indexOf(end);
		if(beginIdx < 0 || endIdx<0){
			result = "";
			return result;
		}
		resultSeg = buf.substring(beginIdx + begin.length(), endIdx);
		resultBuf.append(resultSeg + ",");
		
		//Deaths
		begin = "Kills</span></li><li><spanclass=\"value\">";
		end = "</span><spanclass=\"label\">Deaths";
		beginIdx = buf.indexOf(begin);
		endIdx = buf.indexOf(end);
		if(beginIdx < 0 || endIdx<0){
			result = "";
			return result;
		}
		resultSeg = buf.substring(beginIdx + begin.length(), endIdx);
		resultBuf.append(resultSeg + ",");
		
		//Assists
		begin = "Deaths</span></li><li><spanclass=\"value\">";
		end = "</span><spanclass=\"label\">Assists";
		beginIdx = buf.indexOf(begin);
		endIdx = buf.indexOf(end);
		if(beginIdx < 0 || endIdx<0){
			result = "";
			return result;
		}
		resultSeg = buf.substring(beginIdx + begin.length(), endIdx);
		resultBuf.append(resultSeg + ",");
		
		//KDR
		begin = "Assists</span></li></ul><ulclass=\"valuestieredhalf\"><li><spanclass=\"value\">";
		end = "</span><spanclass=\"label\">KDR";
		beginIdx = buf.indexOf(begin);
		endIdx = buf.indexOf(end);
		if(beginIdx < 0 || endIdx<0){
			result = "";
			return result;
		}
		resultSeg = buf.substring(beginIdx + begin.length(), endIdx);
		resultBuf.append(resultSeg + ",");
		
		//KDA
		begin = "KDR</span></li><li><spanclass=\"value\">";
		end = "</span><spanclass=\"label\">KDA";
		beginIdx = buf.indexOf(begin);
		endIdx = buf.indexOf(end);
		if(beginIdx < 0 || endIdx<0){
			result = "";
			return result;
		}
		resultSeg = buf.substring(beginIdx + begin.length(), endIdx);
		resultBuf.append(resultSeg + ",");
		
		//Win%
		begin = "KDA</span></li><li><spanclass=\"value\">";
		end = "%</span><spanclass=\"label\">Win%";
		beginIdx = buf.indexOf(begin);
		endIdx = buf.indexOf(end);
		if(beginIdx < 0 || endIdx<0){
			result = "";
			return result;
		}
		resultSeg = buf.substring(beginIdx + begin.length(), endIdx);
		resultBuf.append(resultSeg);
		
		
		
		result = resultBuf.toString();
		return result;
		
	}
	public static boolean isRightForm(String str){ 
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[0-9a-zA-Z_]+"); 
		java.util.regex.Matcher m = pattern.matcher(str);
		return m.matches(); 
	} 
}
