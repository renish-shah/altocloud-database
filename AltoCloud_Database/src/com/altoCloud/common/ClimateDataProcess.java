package com.altoCloud.common;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

import com.altoCloud.domain.StationDetailsExtra;
import com.altoCloud.domain.Weather;


public class ClimateDataProcess {
	
	private final int bufferSize=1024000;
	
	static private ClimateDataProcess ref;
		
	private ClimateDataProcess(){
		
	}
	public static ClimateDataProcess getInstance()
	{
		if (ref == null)
			// it's ok, we can call this constructor
			ref = new ClimateDataProcess();		
		return ref;
	}

	public void processStationDetailsExtra(String fileName) throws IOException{
		
		File inputFile = new File(fileName);
		Scanner scanner=null;
		scanner = new Scanner(new FileReader(inputFile));
		int i=0;
		while (scanner.hasNext()){
		    	String str=scanner.nextLine();
				System.out.println(str);
				
				if(i==0){
					i=-1;
					continue;
				}
				parseStationDetailsExtraValues(str);
		}
	}
	
	
	public void parseStationDetailsExtraValues(String line){
		String[] strArr=line.split(",");
		try{	
		StationDetailsExtra s =new StationDetailsExtra();
		//Need to add parsed value of type StationDetail from file mesowest.tbl
		//ms.setStnID(strArr[0].trim());
		s.setSecondary_id(strArr[1].trim());
		s.setNetwork_id(strArr[8].trim());
		s.setNetwork_name(strArr[9].trim());
		s.setStatus(strArr[10].trim());
		
		s.setPrimary_provider_id(strArr[11].length()==0?null:Integer.parseInt(strArr[11].trim()));
		s.setPrimary_provider(strArr[12].length()==0?null:strArr[12].trim());
		s.setSecondary_provider_id(strArr[13].length()==0?null:Integer.parseInt(strArr[13].trim()));
		s.setSecondary_provider(strArr[14].length()==0?null:strArr[14].trim());
		s.setTertiary_provider_id(strArr[15].length()==0?null:Integer.parseInt(strArr[15].trim()));
		s.setTertiary_provider(strArr[16].length()==1?null:(strArr[16].substring(0,strArr[16].length()-1)).trim());
		
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			return;
		}
	} 
	
public void processClimateData(String fileName) throws IOException{
		
		File inputFile = new File(fileName);
		Scanner scanner=null;
		scanner = new Scanner(new FileReader(inputFile));
		int i=0;
		
		//changes made here
		while (scanner.hasNext()){
		    	String str=scanner.nextLine();
				System.out.println(str);
				if(i++==0 || str.length()==0)
					continue;
				this.parseRealValues(str);
		}
	}
	
	public void parseRealValues(String line){
		try {
		line=line.concat("#");
		String[] strArr=line.split(",");
	
		Weather w=new Weather();
		//Station Details needs to be passed after parsing mesowest.tbl
		//w.setStnDetails(strArr[0]);
		
		//Temporary solution is to make timestamp string, need to fix it for comparation later 
		w.setTimestamp(strArr[5]);
		
		/** Code for timeStamp**/

		/*DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd/HHmm");

		Date ts;

		ts = (Date)dateFormat.parse(strArr[5].trim());

		//System.out.println("Date is"+ts.toString());
		long time=ts.getTime();
		Timestamp t=new Timestamp(time);


		ms.setTs(t);
		ms.setCr(new Timestamp(System.currentTimeMillis())); */
				
		w.setTMPF(strArr[6].length()==0?0.0:Double.valueOf(strArr[6].toString()));
		w.setRELH(strArr[7].length()==0?0.0:Double.valueOf(strArr[7]));
		w.setSKNT(strArr[8].length()==0?0:Double.valueOf(strArr[8]));
		w.setGUST(strArr[9].length()==0?0:Double.valueOf(strArr[9]));
		w.setDRCT(strArr[10].length()==0?0:Double.valueOf(strArr[10]));
		//w.setQFLG(strArr[11].length()==0?0:Double.valueOf(strArr[11]));
		w.setDWPF(strArr[12].length()==0?0.0:Double.valueOf(strArr[12]));
		//w.setPRES(strArr[13].length()==0?0.0:Double.valueOf(strArr[13]));
		w.setPMSL(strArr[14].length()==0?0.0:Double.valueOf(strArr[14]));
		w.setP24I(strArr[15].length()==0?0.0:Double.valueOf(strArr[14]));
				
		} catch (Throwable e) {
			System.out.println(e.getMessage());
			return;
		}
		
	}
	
	public String unzipArchieve(String inFilename) throws IOException{
		System.out.println("Opening the gzip file.......................... :  opened");
		GZIPInputStream gzipInputStream = null;
		gzipInputStream = new GZIPInputStream(new FileInputStream(inFilename));
		//String unzipFileName=inFilename.length()-3;
		String outFilename = inFilename.substring(0,inFilename.length()-3);
		OutputStream out = new FileOutputStream(outFilename);
		System.out.println("Trsansferring bytes from the compressed file to the output file........:  Transfer successful");
		byte[] buf = new byte[bufferSize];  //size can be changed according to programmer's need.
		int len;
		while ((len = gzipInputStream.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		System.out.println("The file and stream is ......closing.......... : closed"); 
		gzipInputStream.close();
		out.close();	
		return outFilename;
	}
	
}
