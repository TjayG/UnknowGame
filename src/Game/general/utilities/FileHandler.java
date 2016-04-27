package Game.general.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
	
	public static String readWholeFile(File file) throws FileNotFoundException{
		FileReader freader = new FileReader(file);
		BufferedReader br = new BufferedReader(freader);
		StringBuilder sb = new StringBuilder();
		String line;
		try{
		line = br.readLine();
		
		while(line != null){
			sb.append(line + "\n");
			line = br.readLine();
		}
		}catch(IOException e){
			return ("Can't read File");
		}
		return sb.toString();
	}
}