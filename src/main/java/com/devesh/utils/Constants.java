package com.devesh.utils;

public class Constants {
	
	public static final String generalSettingsTimeZone = "India Standard Time";
	public static final String CHANGE_TIMEZONE_CMD = "cmd.exe /c tzutil /s \"%s\"";
	public static final String CHANGE_TIMEZONE_CMD1 = "cmd.exe /c tzutil /s \"" + generalSettingsTimeZone + "\"";
	public static final String TIMEZONE_LIST_ALL_CMD = "cmd.exe /c tzutil /l ";
	
	public static final String LANGUAGE_KEY = "LanguageTag     : ";
	public static final String ANTONYM_KEY = "Autonym         : ";
	public static final String INSTALLED_LANGUAGE_LIST_PS = "powershell.exe Get-WinUserLanguageList";


	static String driveName = "V:";
	static String drivePath = "\\\\DESKTOP-Q0FUS1Q\\Songs";
	String username = "DOMAIN-NAME\\USERNAME";
	String password = "PASSWORD";

	public static final String MAP_CORNELLAD_NETWORK_DRIVE = "cmd.exe /c net use "+driveName+" "+drivePath+" /persisten:yes";
	public static final String MAP_NON_CORNELLAD_NETWORK_DRIVE = "cmd.exe /c net use R: \\\\CEPSNYLPENG4511\\Home PASSWORD /user:DOMAIN-NAME\\USERNAME /persisten:yes";
	public static final String DELETE_NETWORK_DRIVE = "cmd.exe /c net use "+driveName+" /delete";
}
