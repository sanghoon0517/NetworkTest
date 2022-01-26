package kr.co.jsh.test.network;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class NetworkTest01 {

	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		// TODO Auto-generated method stub
//		doPrintingMsg("제목", "Kakao");
		
		String internetPath = "https://news.naver.com/main/read.naver?"+"mode=LSD&mid=shm&sid1=105&oid=003&aid=0010967341";
		
		URL url = new URL(internetPath);
		URI uri = url.toURI();
		
		System.out.println("======================URL정보 출력======================");
		doPrintingMsg("String path", internetPath);
		doPrintingMsg("Protocol", url.getProtocol());
		doPrintingMsg("host", url.getHost());
		doPrintingMsg("port", url.getPort());
		doPrintingMsg("path", url.getPath());
		doPrintingMsg("file", url.getFile());
		doPrintingMsg("query", url.getQuery());
		doPrintingMsg("authority", url.getAuthority());
		doPrintingMsg("ref", url.getRef());
		doPrintingMsg("defaultPort", url.getDefaultPort());
		doPrintingMsg("toExternalForm", url.toExternalForm());
		System.out.println("========================================================\n");

		System.out.println("======================URI정보 출력======================");
		doPrintingMsg("String path", internetPath);
		doPrintingMsg("scheme", uri.getScheme());
		doPrintingMsg("host", uri.getHost());
		doPrintingMsg("port", uri.getPort());
		doPrintingMsg("path", uri.getPath());
		doPrintingMsg("rawPath", uri.getRawPath());
		doPrintingMsg("query", uri.getQuery());
		doPrintingMsg("rawQuery", uri.getRawQuery());
		doPrintingMsg("fragment", uri.getFragment());
		doPrintingMsg("rawFragment", uri.getRawFragment());
		doPrintingMsg("fragment", uri.getFragment());
		doPrintingMsg("schemSpecificPart", uri.getSchemeSpecificPart());
		doPrintingMsg("rawSchemSpecificPart", uri.getRawSchemeSpecificPart());
		doPrintingMsg("authority", uri.getAuthority());
		doPrintingMsg("rawAuthority", uri.getRawAuthority());
		doPrintingMsg("toASCIIString", uri.toASCIIString());
		doPrintingMsg("toString", uri.toString());
		System.out.println("========================================================\n");
		
	}
	
	public static void  doPrintingMsg(String title, Object value) {
		System.out.println("title : "+title+"\t\tvalue : "+value);
	}

}
