package com.altoCloud.parsingUtility;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.altoCloud.domain.MesowestTblStationInfo;

/**
 * @author RENISH
 * 
 */
public class ParseTblFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ParseTblFile().parseFile();
	}

	public void parseFile() {

		try {
			// FileInputStream fstream = new FileInputStream(
			// "F:\\SJSU_aCAdEMICS\\CMPE_275_JohnGash\\Data\\8.26\\mesowest.out\\mesowest.out");
			FileInputStream fstream = new FileInputStream(
					"E:\\A Set of Sample Data\\mesowest_tbl_Tue Oct 02 195630 PDT 2012_Tue Oct 02 195632 PDT 2012 - Copy.out");

			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine;
			String pattern = "\\s{1,}";

			// Read File Line By Line
			String data[] = null;
			String stationName="";
			while ((strLine = br.readLine()) != null) {
				stationName="";
				strLine = strLine.replaceAll(pattern, "|");
				System.out.println("" + strLine);
				data = strLine.split("\\|");
				//System.out.println("renish mad" + data.length);

				MesowestTblStationInfo stationInfo = new MesowestTblStationInfo();
				stationInfo.setStationId(data[0]);
				stationInfo.setStationCode(data[1]);
				for(int i=2;i<data.length-7;i++)
				{
					stationName=stationName+data[i]+" ";
				}
				System.out.println("Station Name:"+stationName);
				stationInfo.setStationName(stationName);
				stationInfo.setState(data[data.length-7]);
				stationInfo.setCountry(data[data.length-6]);
				stationInfo.setLatitude(data[data.length-5]);
				stationInfo.setLongitude(data[data.length-4]);
				stationInfo.setElevation(data[data.length-3]);
				stationInfo.setNetworkId(data[data.length-2]);
				stationInfo.setStatus(data[data.length-1]);
				
				System.out.println("Station Details stored");

			}

			// Close the input stream

			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
