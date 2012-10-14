package com.altoCloud.Test;
import java.util.Date;

public class Reminder {

	public static void main(String[] args) throws InterruptedException {

		while (true) {
			System.out.println(new Date() + "\007");
			Thread.sleep(2 * 60 * 1000);
		}
		//test paridhi
	}

	public void reminderAt5Min() throws InterruptedException {

		while (true) {
			System.out.println(new Date() + "\007");
			Thread.sleep(2 * 60 * 1000);
		}

		//       System.out.println(new Date() + "\007");
		//       Thread.sleep(5 * 60 * 1000);

	}
}