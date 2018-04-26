package alexLiu.exercise;

import java.io.*;
import java.util.ArrayList;
public class TransferReader{
	
  public static void main(String[] args)throws Exception{
	  
	  File readfile = new File("src/transfers");
	  
	  BufferedReader br = new BufferedReader(new FileReader(readfile));
	 
	  ArrayList<TransferPlayer> transfers = new ArrayList<TransferPlayer>();
	  String st;
	  while ((st = br.readLine()) != null){
		if(st.contains("YES")){
			TransferPlayer tp = new TransferPlayer(st);
			transfers.add(tp);
		}
	  }
  	 ExcelWriter.write(transfers);
  	 
  }
  
}
