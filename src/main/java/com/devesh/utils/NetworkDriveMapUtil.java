package com.devesh.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NetworkDriveMapUtil {
	
	static String driveName = "V:";
	static String drivePath = "\\\\DESKTOP-Q0FUS1Q\\Songs";
	String username = "CEPHEID.PRI\\\\aditya.dasari";
	String password = "Cepheid2021!!";

	public static final String MAP_CORNELLAD_NETWORK_DRIVE = "cmd.exe /c net use "+driveName+" "+drivePath+" /persisten:yes";
	
	public static final String MAP_NON_CORNELLAD_NETWORK_DRIVE = "cmd.exe /c net use R: \\\\CEPSNYLPENG4511\\Home Cepheid2021!! /user:CEPHEID.PRI\\aditya.dasari /persisten:yes";
	public static final String DELETE_NETWORK_DRIVE = "cmd.exe /c net use "+driveName+" /delete";
		
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String networkDriveResponse = mapNetworkDrive(DELETE_NETWORK_DRIVE);
		if (networkDriveResponse  != null) {
			System.out.println("Network Drive Connected Successfully!");
		} else {
			System.out.println("Not abel to reach out to network drive!");
		}
		

	}
	
	/*
	 * This method is being used to map a network drive via windows CMD command networkDriveCommand
	 */
	public static String mapNetworkDrive(String networkDriveCommand) throws IOException, InterruptedException {
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(networkDriveCommand);
		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = in.readLine();
		System.out.println("Line : " + line);
		return line;
	}
	
	/*
	 * This method is being used to delete the  mapped network drive via windows CMD command networkDriveCommand
	 */
	public static String deleteMapedNetworkDrive(String networkDriveCommand) throws IOException, InterruptedException {
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(networkDriveCommand);
		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = in.readLine();
		System.out.println("Line" + line);
		return line;
	}
}
