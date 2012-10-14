package com.altoCloud.parsingUtility;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.altoCloud.dbQuery.StationDetailsExtraQuery;
import com.altoCloud.dbQuery.StationDetailsQuery;
import com.altoCloud.dbQuery.WeatherQuery;

import data.Weather;
//import com.altoCloud.domain.level3.StationDetailsExtra;

import data.Station_Details;
import data.Station_Details_extra;

/**
 * @author RENISH
 * 
 */
public class ParseDataFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// new ParseDataFiles().parseWeatherDataFile();
		// new ParseDataFiles().parseMesowestTblFile();
		// new ParseDataFiles().parseMesowestCSVTblFile();
		// new ParseDataFiles().parseWeatherDataFile();
		WeatherQuery wr = new WeatherQuery();
		List<Weather> r = wr.getAllByState("UT");
		for (int i = 0; i < r.size(); i++) {
			System.out.println(r.get(0).getTMPF());
			System.out.print(r.get(0).getStn_id().getStn());
		}
	}

	public void parseMesowestCSVTblFile() {

		try {
			FileInputStream fstream = new FileInputStream(
					"c:/testfolder/mesowest_csv_tbl_Fri Oct 12 182339 PDT 2012.out");

			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine = "";
			// Read File Line By Line
			strLine = br.readLine();

			// Read File Line By Line
			String data[] = new String[22];
			StationDetailsExtraQuery query = new StationDetailsExtraQuery();
			StationDetailsQuery sq = new StationDetailsQuery();
			while ((strLine = br.readLine()) != null) {

				System.out.println("" + strLine);
				data = strLine.split(",");
				// System.out.println("hUnGrY ReNiSh" + data.length);

				// 0-1-2 // primary id,secondary id,station name,
				// 3,4,5 //state,country,latitude,
				// 6,7,8 //longitude,elevation,mesowest network id,
				// 9,10,11 //network name,status,primary provider id,
				// 12,13,14 //primary provider,secondary provider
				// id,secondaryprovider,
				// 15,16,17 //tertiary provider id,tertiary provider,wims_id;

				// KIYA,,Abbeville Chris Crusta Memorial
				// Airport,LA,US,29.97578,-92.08422,
				// 4.9,1,NWS/FAA,ACTIVE,2,National Weather Service,,,,,;
				// Level-2 Weather Domain

				// StationDetailsExtra detailsExtra = new StationDetailsExtra();
				//
				// detailsExtra.setStnSecId(data[1]);
				// detailsExtra.setPriProId(data[11]);
				// detailsExtra.setSecProId(data[13]);
				// detailsExtra.setNetworkId(data[8]);
				// detailsExtra.setTerProId(data[15]);

				Station_Details_extra detailsExtra = new Station_Details_extra();
				Station_Details station_Details = new Station_Details();

				station_Details = sq.findById(data[0]);

				// detailsExtra.setStnSecId(data[1]);
				detailsExtra.setStn_details(station_Details);
				detailsExtra.setSecondary_id(data[1]);
				detailsExtra.setNetwork_name(data[9]);
				if (data[11].length() != 0)
					detailsExtra.setPrimary_provider_id(Integer
							.parseInt(data[11]));
				if (data[12].length() != 0)
					detailsExtra.setPrimary_provider(data[12]);

				if (data[13].length() != 0) {
					detailsExtra.setSecondary_provider_id(Integer
							.parseInt(data[13]));
				}
				if (data[14].length() != 0) {
					detailsExtra.setSecondary_provider(data[14]);
				}
				if (data[15].length() != 0) {
					detailsExtra.setTertiary_provider_id(Integer
							.parseInt(data[15]));
				}
				if (data[16].length() != 0) {
					detailsExtra.setTertiary_provider(data[16]);
				}
				query.add(detailsExtra);
				System.out.println("Station Extra details stored");

			}

			// Close the input stream

			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}

	}

	public void parseWeatherDataFile() {
		StationDetailsQuery sq = new StationDetailsQuery();
		WeatherQuery wq = new WeatherQuery();
		try {
			FileInputStream fstream = new FileInputStream(
					"c:/testfolder/mesowest_out_Fri Oct 12 183726 PDT 2012.out");

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
				// sq.findById(data[1]);
				weather.setStn_id(sq.findById(data[1]));
				// SimpleDateFormat dateFormat = new SimpleDateFormat(
				// "yy-MM-dd hh:mm");
				// java.util.Date parsedDate = null;
				// try {
				// parsedDate = dateFormat.parse(data[2]);
				// } catch (ParseException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
				// java.sql.Timestamp timestamp = new java.sql.Timestamp(
				// parsedDate.getTime());
				// weather.setDate(timestamp);
				// weather.setTimestamp(data[2]);

				// weather.setMNET(data[3]);
				// weather.setSLAT(data[4]);
				// weather.setSLON(data[5]);
				// weather.setSELV(data[6]);
				weather.setTMPF(Double.parseDouble(data[7]));
				weather.setSKNT(Double.parseDouble(data[8]));
				weather.setDRCT(Double.parseDouble(data[9]));
				weather.setGUST(Double.parseDouble(data[10]));
				weather.setPMSL(Double.parseDouble(data[11]));
				weather.setALTI(Double.parseDouble(data[12]));
				weather.setDWPF(Double.parseDouble(data[13]));
				System.out.println(data[14]);
				weather.setRELH(Double.parseDouble(data[14]));
				weather.setWTHR(Double.parseDouble(data[15]));
				weather.setP24I(Double.parseDouble(data[16]));

				System.out.println("Weather data stored");
				wq.add(weather);
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
					"c:/testfolder/mesowest_tbl_Fri Oct 12 182346 PDT 2012.out");
			StationDetailsQuery sq = new StationDetailsQuery();
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

				// MesowestTblStationInfo stationInfo = new
				// MesowestTblStationInfo();
				Station_Details stationInfo = new Station_Details();
				stationInfo.setStn(data[0]);
				stationInfo.setOther_id(Long.parseLong(data[1]));
				for (int i = 2; i < data.length - 7; i++) {
					stationName = stationName + data[i] + " ";
				}
				System.out.println("Station Name:" + stationName);
				stationInfo.setStn_name(stationName);
				stationInfo.setState(data[data.length - 7]);
				stationInfo.setCountry(data[data.length - 6]);
				stationInfo.setLat(Double.parseDouble(data[data.length - 5]));
				stationInfo.setLon(Double.parseDouble(data[data.length - 4]));
				stationInfo.setElev(Double.parseDouble(data[data.length - 3]));
				stationInfo.setMnet(Integer.parseInt(data[data.length - 2]));
				stationInfo.setStatus(data[data.length - 1]);

				System.out.println("Station Details stored");
				sq.add(stationInfo);
			}

			// Close the input stream

			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
