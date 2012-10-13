package com.altoCloud.parsingUtility;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.altoCloud.domain.MesowestTblStationInfo;
import com.altoCloud.domain.Weather;

/**
 * @author RENISH
 * 
 */
public class ParseDataFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new ParseDataFiles().parseWeatherDataFile();
	}

	public void parseWeatherDataFile() {

		try {
			FileInputStream fstream = new FileInputStream(
					"E:\\A Set of Sample Data\\mesowest_out_Tue Oct 02 194806 PDT 2012_Tue Oct 02 194807 PDT 2012.out");

			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine;
			String pattern = "\\s{1,}";

			// Read File Line By Line
			for (int i = 0; i < 4; i++) {
				strLine = br.readLine();
			}

			// Read File Line By Line
			String data[] = null;
			String stationName = "";
			while ((strLine = br.readLine()) != null) {
				stationName = "";
				strLine = strLine.replaceAll(pattern, "|");
				System.out.println("" + strLine);
				data = strLine.split("\\|");
				// System.out.println("hUnGrY ReNiSh" + data.length);
				// PARM =
				// MNET;SLAT;SLON;SELV;TMPF;SKNT;DRCT;GUST;PMSL;ALTI;DWPF;RELH;WTHR;P24I
				// |BULLF|20121003/0215|8.00|37.52|-110.73|1128.00|78.70|2.74|264.20|3.39|-9999.00|-9999.00|46.41|32.09|-9999.00|-9999.00

				// Level-2 Weather Domain
				Weather weather = new Weather();
				// weather.setStationCode(data[1]);

				weather.setTimestamp(data[2]);
				weather.setMNET(data[3]);
				weather.setSLAT(data[4]);
				weather.setSLON(data[5]);
				weather.setSELV(data[6]);
				weather.setTMPF(Double.parseDouble(data[7]));
				weather.setSKNT(Double.parseDouble(data[8]));
				weather.setDRCT(Double.parseDouble(data[9]));
				weather.setGUST(Double.parseDouble(data[10]));
				weather.setPMSL(Double.parseDouble(data[11]));
				weather.setALTI(Double.parseDouble(data[12]));
				weather.setDWPF(Double.parseDouble(data[13]));
				weather.setRELH(Double.parseDouble(data[14]));
				weather.setWTHR(Double.parseDouble(data[15]));
				weather.setP24I(Double.parseDouble(data[16]));

				System.out.println("Weather data stored");

			}

			// Close the input stream

			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void parseMesowestTblFile() {

		try {
			FileInputStream fstream = new FileInputStream(
					"E:\\A Set of Sample Data\\mesowest_tbl_Tue Oct 02 195630 PDT 2012_Tue Oct 02 195632 PDT 2012 - Copy.out");

			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine;
			String pattern = "\\s{1,}";

			// Read File Line By Line
			String data[] = null;
			String stationName = "";
			while ((strLine = br.readLine()) != null) {
				stationName = "";
				strLine = strLine.replaceAll(pattern, "|");
				System.out.println("" + strLine);
				data = strLine.split("\\|");
				// System.out.println("renish mad" + data.length);

				MesowestTblStationInfo stationInfo = new MesowestTblStationInfo();
				stationInfo.setStationId(data[0]);
				stationInfo.setStationCode(data[1]);
				for (int i = 2; i < data.length - 7; i++) {
					stationName = stationName + data[i] + " ";
				}
				System.out.println("Station Name:" + stationName);
				stationInfo.setStationName(stationName);
				stationInfo.setState(data[data.length - 7]);
				stationInfo.setCountry(data[data.length - 6]);
				stationInfo.setLatitude(data[data.length - 5]);
				stationInfo.setLongitude(data[data.length - 4]);
				stationInfo.setElevation(data[data.length - 3]);
				stationInfo.setNetworkId(data[data.length - 2]);
				stationInfo.setStatus(data[data.length - 1]);

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
