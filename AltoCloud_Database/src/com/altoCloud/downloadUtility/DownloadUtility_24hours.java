package com.altoCloud.downloadUtility;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.zip.GZIPInputStream;

import sun.swing.FilePane;

public class DownloadUtility_24hours {

	static String filepath1 = "";
	String dir = "";

	public static void main(String[] args) {

		DownloadUtility_24hours utility = new DownloadUtility_24hours();
		while (true) {

			//every 24 hours
			utility.downloadData("mesowest_tbl",
					"http://mesowest.utah.edu/data/mesowest.tbl.gz");
			utility.extractData(filepath1);

//			utility.downloadData("mesowest_out",
//					"http://mesowest.utah.edu/data/mesowest.out.gz");
//			utility.extractData(filepath1);
//			utility.downloadData("mesowest_csv_tbl",
//					"http://mesowest.utah.edu/data/mesowest_csv.tbl.gz");
//			utility.extractData(filepath1);
//			utility.downloadData("mesowest_dat",
//					"http://mesowest.utah.edu/data/mesowest.dat.gz");
//			utility.extractData(filepath1);

			try {
				Thread.sleep(1440 * 60 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("InterruptedException :" + e);
				e.printStackTrace();
			}

		}
	}

	public void downloadData(String outputFileName, String urlPath) {
		try {

			String envVar = System.getenv("JAVA_HOME");
			// String environmentVariable="C:/Program Files/Java/jdk1.7.0";
			System.out.print("Environment Variable is =>" + envVar);

			// String dir = envVar + "/WMS";
			dir = envVar + "WMS";
			if (!(new File(dir)).exists())
				new File(dir).mkdirs();

			// URL url = new
			// URL("http://mesowest.utah.edu/data/mesowest.out.gz");
			// URL url = new
			// URL("http://mesowest.utah.edu/data/mesowest.tbl.gz");
			// URL url = new
			// URL("http://www.met.utah.edu/cgi-bin/database/variable_select.cgi");
			// - this is not available

			URL url = new URL(urlPath);

			URLConnection con = url.openConnection();
			BufferedInputStream in = new BufferedInputStream(
					con.getInputStream());

			filepath1 = dir + "\\" + outputFileName;
			System.out.println("\nFilePath is: " + filepath1);

			// FileOutputStream out = new FileOutputStream(dir + "/"
			// + outputFileName);
			FileOutputStream out = new FileOutputStream(dir + "\\"
					+ outputFileName);

			int i = 0;
			byte[] bytesIn = new byte[3000000];
			while ((i = in.read(bytesIn)) >= 0) {
				out.write(bytesIn, 0, i);
			}
			out.close();
			in.close();

		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}

	}

	public void extractData(String inFilename) {

		try {

			// inFilename = "E://Test//mnet_no.cgi";
			System.out.println("Opening the gzip file....:  opened");

			GZIPInputStream gzipInputStream = null;
			// FileInputStream fileInputStream = null;
			gzipInputStream = new GZIPInputStream(new FileInputStream(
					inFilename));
			System.out.println("Opening the output file...: opened");

			String dateTime = "" + new Date();
			dateTime = dateTime.replaceAll(":", "");

			System.out.println("\nInfileName:" + inFilename);
			String[] fileNames = inFilename.replace("\\", "/").split("/");
			String finalName = fileNames[fileNames.length - 1];

			System.out.println("\nInfileName:" + inFilename);
			// String outFilename = inFilename.substring(0,
			// inFilename.length() - 7) + "_" + dateTime + ".out";
			String outFilename = dir + "/" + finalName + "_" + dateTime
					+ ".out";

			System.out.println("\nOutfileName:" + outFilename);

			// String outFilename="E://Test//mesowest_renish.out";

			OutputStream out = new FileOutputStream(outFilename);

			System.out
					.println("Transferring bytes from the compressed file to the output file........:Transfer successful");
			byte[] buf = new byte[1024]; // size can be changed according to
											// programmer's need.
			int len;
			while ((len = gzipInputStream.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			System.out
					.println("The file and stream is ......closing.......... : closed");

			gzipInputStream.close();
			out.close();
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}

	}

}
