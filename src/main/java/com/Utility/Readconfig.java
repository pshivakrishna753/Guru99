package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	public Readconfig() {		
		File src=new File("./configuration/Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("The Exception is "+ e.getMessage());	
		}
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("Baseurl");
		return url;
	}
	
	public String getUsername() {
		String uname=pro.getProperty("username");
		return uname;
	}
	public String getPassword() {
		String pwd=pro.getProperty("password");
		return pwd;
	}
	public String getFirefoxpath() {
		String firefox=pro.getProperty("firefoxpath");
		return firefox;
	}
	public String getChromepath() {
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	public String getIepath() {
		String ie=pro.getProperty("iepath");
		return ie;
	}
	public String getedgepath() {
		String edge=pro.getProperty("edgepath");
		return edge;
	}

}
