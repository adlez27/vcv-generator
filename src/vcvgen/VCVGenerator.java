package vcvgen;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class VCVGenerator {
	static ArrayList<String[]> reclist;
	static int numOfVVs;
	
	public static void reclist(String cons, String vows, int maxSyl){
		String[] consonants = cons.split(" ");
		String[] vowels = vows.split(" ");
		String[][] initVowelStrings = new String[vowels.length][vowels.length+1];
		
		// Constructing vowel strings
		for (int i = 0; i < vowels.length; i++){
			String[] vv = new String[vowels.length+1];
			vv[0] = vowels[i];
			for (int j = 1; j < vowels.length+1; j++){
				if (j%2 == 0){
					vv[j] = vowels[(i+j/2)%vowels.length];
				}else{
					vv[j] = vowels[i];
				}
			}
			initVowelStrings[i] = vv;
		}
		
		// Splitting vowel strings up
		ArrayList<String[]> finVowelStrings = new ArrayList<String[]>();
		for (String[] line : initVowelStrings){
			int start = 0;
			int end = maxSyl;
			if (line.length < maxSyl){
				finVowelStrings.add(line);
			} else {
				boolean first = true;
				boolean last = false;
				while (!last){
					
					if (first){
						String[] firstBatch = new String[maxSyl];
						for (int i = 0; i < end; i++){
							firstBatch[i] = line[i];
						}
						finVowelStrings.add(firstBatch);
						first = false;
					}
					
					if (line.length-start > maxSyl){
						String[] midBatch = new String[maxSyl];
						for (int i = start, j = 0; i < end; i++, j++){
							midBatch[j] = line[i];
						}
						finVowelStrings.add(midBatch);
					} else {
						String[] finBatch = new String[line.length-start];
						for (int i = start, j = 0; i < line.length; i++, j++){
							finBatch[j] = line[i];
						}
						finVowelStrings.add(finBatch);
						last = true;
					}
					
					start = end-1;
					end = end + maxSyl-1;
				}
			}
		}
		
		numOfVVs = finVowelStrings.size();
		
		reclist = new ArrayList<String[]>();
		for (String[] line : finVowelStrings){
			reclist.add(line);
		}
		for (String con : consonants){
			for (String[] line : finVowelStrings){
				String[] vcv = new String[line.length*2];
				for (int i = 0; i < line.length; i++){
					vcv[i*2] = con;
					vcv[i*2+1] = line[i];
				}
				reclist.add(vcv);
			}
		}
		
		try {
            PrintWriter writer = new PrintWriter(new File("./result/reclist.txt"));
            
            for (int i = 0; i < reclist.size(); i++){
            	writer.println(getFilename(i));
    		}
            
            writer.close();
         } catch (Exception ex) {
        	 ex.printStackTrace();
         }
	}
	
	public static void oto(int initOff, int tempo, int maxDups){
		ArrayList<String[]> oto = new ArrayList<String[]>();
		String cons = Integer.toString((int)((10000/tempo)*4.5));
		String cutoff = Integer.toString(0-(10000/tempo)*7);
		String preutt = Integer.toString((10000/tempo)*3);
		String overlap= Integer.toString(10000/tempo);
		int offInc = (10000/tempo)*6;
		
		for (int i = 0; i < numOfVVs; i++){
			int currentOff = initOff;
			String[] recArr = reclist.get(i);
			String recLine = getFilename(i);
			
			String[] firstV = {recLine,"alias","offset",cons,cutoff,preutt,overlap};
			String alias1 = "- " + recArr[0];
			firstV[1] = alias1;
			firstV[2] = Integer.toString(currentOff);
			oto.add(firstV);
			currentOff += offInc;
			
			for (int j = 0; j < recArr.length-1; j++){
				String[] otoLine = {recLine,"alias","offset",cons,cutoff,preutt,overlap};
				String alias = recArr[j] + " " + recArr[j+1];
				otoLine[1] = alias;
				otoLine[2] = Integer.toString(currentOff);
				oto.add(otoLine);
				currentOff += offInc;
			}
		}
		for (int i = numOfVVs; i<reclist.size(); i++){
			int currentOff = initOff;
			String[] recArr = reclist.get(i);
			String recLine = getFilename(i);
			
			String[] firstCV = {recLine,"alias","offset",cons,cutoff,preutt,overlap};
			String alias1 = "- "+ recArr[0] + recArr[1];
			firstCV[1] = alias1;
			firstCV[2] = Integer.toString(currentOff);
			oto.add(firstCV);
			currentOff += offInc;
			
			for (int j = 2; j < recArr.length-1; j+=2){
				String[] otoLine = {recLine,"alias","offset",cons,cutoff,preutt,overlap};
				String alias = recArr[j-1] + " " + recArr[j] + recArr[j+1];
				otoLine[1] = alias;
				otoLine[2] = Integer.toString(currentOff);
				oto.add(otoLine);
				currentOff += offInc;
			}
		}
		
		try {
			HashMap<String,Integer> aliasCount = new HashMap<String,Integer>();
			PrintWriter writer = new PrintWriter(new File("./result/oto.ini"));
			for (String[] line : oto){
				if (aliasCount.containsKey(line[1]) && aliasCount.get(line[1]) < maxDups){
					aliasCount.replace(line[1],aliasCount.get(line[1])+1);
					line[1] += aliasCount.get(line[1]);
					writer.println(line[0]+".wav="+line[1]+","+line[2]+","+line[3]+","+line[4]+","+line[5]+","+line[6]);
				} else if (! aliasCount.containsKey(line[1])) {
					aliasCount.put(line[1],0);
					writer.println(line[0]+".wav="+line[1]+","+line[2]+","+line[3]+","+line[4]+","+line[5]+","+line[6]);
				}
			}
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static String getFilename(int index){
		String fn = "";
		String[] line = reclist.get(index);
		
		if (index < numOfVVs){
    		for (int i = 0; i < line.length; i++){
				String ch = line[i];
				if (i == line.length-1){
					fn += ch;
				} else {
					fn += ch + "-";
				}
			}
    	} else {
    		int cvCounter = 0;
			for (int i = 0; i < line.length; i++){
				String ch = line[i];
				if (cvCounter == 0 || i == line.length-1){
					fn += ch;
					cvCounter++;
				} else {
					fn += ch + "-";
					cvCounter = 0;
				}
			}
    	}
		
		return fn;
	}
}
