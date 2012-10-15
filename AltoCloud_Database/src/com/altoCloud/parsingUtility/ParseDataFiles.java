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

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.altoCloud.common.HibernateUtil;
import com.altoCloud.dbQuery.NetworkDetailsQuery;
import com.altoCloud.dbQuery.ProviderDetailsQuery;
import com.altoCloud.dbQuery.StationDetailsExtraQuery;
import com.altoCloud.dbQuery.StationDetailsQuery;
import com.altoCloud.dbQuery.StationStatusQuery;
import com.altoCloud.dbQuery.WeatherQuery;
import com.altoCloud.domain.level3.NetworkDetails;
import com.altoCloud.domain.level3.ProviderDetails;
import com.altoCloud.domain.level3.StationDetails;
import com.altoCloud.domain.level3.StationDetailsExtra;
import com.altoCloud.domain.level3.StationStatus;
import com.altoCloud.domain.level3.Weather;

/**
 * @author RENISH
 * 
 */
public class ParseDataFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new ParseDataFiles().initiateInsertIntoDB();
		// new ParseDataFiles().parseWeatherDataFile();
		// new ParseDataFiles().parseMesowestTblFile();
		// new ParseDataFiles().parseMesowestCSVTblFile();
		// new ParseDataFiles().parseWeatherDataFile();
	}

	public void initiateInsertIntoDB() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();

		ParseDataFiles parseDataFiles = new ParseDataFiles();
		parseDataFiles.parseMesowestCSVTblFile(session);

		transaction.commit();

	}

	public void parseMesowestCSVTblFile(Session session) {

		try {
			FileInputStream fstream = new FileInputStream(
					"E:/A Set of Sample Data/mesowest_csv_tbl_Tue Oct 02 195702 PDT 2012_Tue Oct 02 195703 PDT 2012.out");

			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine = "";
			// Read File Line By Line
			strLine = br.readLine();

			// Read File Line By Line
			String data[] = new String[22];
			StationDetailsExtraQuery stnDetExtraQuery = new StationDetailsExtraQuery();
			StationDetailsQuery stnDetQuery = new StationDetailsQuery();
			ProviderDetailsQuery providerDetailsQuery = new ProviderDetailsQuery();
			NetworkDetailsQuery networkDetailsQuery = new NetworkDetailsQuery();
			StationStatusQuery stationStatusQuery = new StationStatusQuery();
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

				/******************** Insert Provider Details ***************************/
				// List<ProviderDetails> providerDetails = new
				// ArrayList<ProviderDetails>();
				// providerDetails.add(priProDet);
				// providerDetails.add(secProDet);
				// providerDetails.add(terProDet);

				/********************* Insert Network Details *****************************/
				NetworkDetails networkDetails = new NetworkDetails();
				networkDetails.setNetworkId(data[8]);
				networkDetails.setNetworkName(data[9]);
				networkDetailsQuery.add(networkDetails, session);

				StationStatus stationStatus = new StationStatus();

				if (data[10] != null) {
					stationStatus.setStatus(data[10]);
					stationStatusQuery.add(stationStatus, session);
				}

				/********************* Insert Station Details Extra *****************************/
				StationDetailsExtra stnDetExtra = new StationDetailsExtra();
				stnDetExtra.setStnSecId(data[1]);
				stnDetExtra.setNetworkDetails(networkDetails);

				ProviderDetails priProDet = new ProviderDetails();
				if (data[11].length() > 0 && data[12].length() > 0) {
					priProDet.setProviderId(data[11]);
					priProDet.setProviderName(data[12]);
					providerDetailsQuery.add(priProDet, session);
					stnDetExtra.setPriProDetails(priProDet);
				}

				ProviderDetails secProDet = new ProviderDetails();
				if (data[13].length() > 0 && data[14].length() > 0) {
					secProDet.setProviderId(data[13]);
					secProDet.setProviderName(data[14]);
					providerDetailsQuery.add(secProDet, session);
					stnDetExtra.setSecProDetails(secProDet);
				}

				ProviderDetails terProDet = new ProviderDetails();
				if (data[15].length() > 0 && data[16].length() > 0) {
					terProDet.setProviderId(data[15]);
					terProDet.setProviderName(data[16]);
					providerDetailsQuery.add(terProDet, session);
					stnDetExtra.setTerProDetails(terProDet);
				}

				stnDetExtraQuery.add(stnDetExtra, session);
				parseMesowestTblFile(stationStatus, stnDetExtra, session);

			}

			// Close the input stream

			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}

	}

	// Parse Mesowest.out file
	public void parseMesowestOutFile(StationDetails stationDetails,
			Session session) {

		try {
			FileInputStream fstream = new FileInputStream(
					"E:/A Set of Sample Data/mesowest_out_Tue Oct 02 194806 PDT 2012_Tue Oct 02 194807 PDT 2012.out");

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
			String INPUT1 = "yyyyMMdd/HHmm";
			String OUTPUT1 = "yyyy-MM-dd HH.mm";

			WeatherQuery weatherQuery = new WeatherQuery();

			while ((strLine = br.readLine()) != null) {
				stationName = "";
				strLine = strLine.replaceAll(pattern, "|");
				System.out.println("" + strLine);
				data = strLine.split("\\|");
				// System.out.println("hUnGrY ReNiSh" + data.length);

				java.util.Date date = null;
				try {
					date = (new SimpleDateFormat(INPUT1)).parse(data[2]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Timestamp timeStamp = new Timestamp(date.getTime());
				// System.out.println("TimeStamp :" + t);
				// weather.setDate(t);

				// PARM =
				// MNET;SLAT;SLON;SELV;TMPF;SKNT;DRCT;GUST;PMSL;ALTI;DWPF;RELH;WTHR;P24I
				// |BULLF|20121003/0215|8.00|37.52|-110.73|1128.00|78.70|2.74|264.20|3.39|-9999.00|-9999.00|46.41|32.09|-9999.00|-9999.00

				// Level-2 Weather Domain
				Weather weather = new Weather();
				// weather.setStationCode(data[1]);
				weather.setTimestamp(timeStamp);
				weather.setTMPF(Double.parseDouble(data[7]));
				weather.setSKNT(Double.parseDouble(data[8]));
				weather.setDRCT(Double.parseDouble(data[9]));
				weather.setGUST(Double.parseDouble(data[10]));
				weather.setPMSL(Double.parseDouble(data[11]));
				weather.setALTI(Double.parseDouble(data[12]));
				weather.setDWPF(Double.parseDouble(data[13]));
				// System.out.println(data[14]);
				weather.setRELH(Double.parseDouble(data[14]));
				weather.setWTHR(Double.parseDouble(data[15]));
				weather.setP24I(Double.parseDouble(data[16]));

				/*********************** Add Station Details Object ************************/
				if (stationDetails != null)
					weather.setStationDetails(stationDetails);

				weatherQuery.add(weather, session);

				System.out.println("Weather data stored");

			}

			// Close the input stream

			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void parseMesowestTblFile(StationStatus stationStatus,
			StationDetailsExtra stnDetailsExtra, Session session) {

		try {

			FileInputStream fstream = new FileInputStream(
					"E:/A Set of Sample Data/mesowest_tbl_Tue Oct 02 195630 PDT 2012_Tue Oct 02 195632 PDT 2012 - Copy (2).out");
			// StationDetailsQuery sq = new StationDetailsQuery();
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine;
			String pattern = "\\s{1,}";

			// Read File Line By Line
			String data[] = null;
			String stationName = "";
			// String temp="";
			StationDetailsQuery stationDetailsQuery = new StationDetailsQuery();
			while ((strLine = br.readLine()) != null) {
				stationName = "";
				strLine = strLine.replaceAll(pattern, "|");
				System.out.println("" + strLine);
				data = strLine.split("\\|");
				// System.out.println("renish mad" + data.length);

				StationDetails stationDetails = new StationDetails();
				stationDetails.setStnCode(data[0]);
				stationDetails.setOtherId(Long.parseLong(data[1]));
				for (int i = 2; i < data.length - 7; i++) {
					stationName = stationName + data[i] + " ";
				}
				System.out.println("Station Name:" + stationName);
				stationDetails.setStnName(stationName);

				stationDetails.setState(data[data.length - 7]);
				stationDetails.setCountry(data[data.length - 6]);
				stationDetails
						.setLat(Double.parseDouble(data[data.length - 5]));
				stationDetails
						.setLon(Double.parseDouble(data[data.length - 4]));
				stationDetails.setElev(Double
						.parseDouble(data[data.length - 3]));
				// stationDetails.setMnet(Integer.parseInt(data[data.length -
				// 2]));
				// stationDetails.setStatus(data[data.length - 1]);
				if (stationStatus != null)
					stationDetails.setStationStatus(stationStatus);
				if (stnDetailsExtra != null)
					stationDetails.setStnDetailsExtra(stnDetailsExtra);

				stationDetailsQuery.add(stationDetails, session);
				System.out.println("Station Details stored");

				parseMesowestOutFile(stationDetails, session);
			}

			// Close the input stream

			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
