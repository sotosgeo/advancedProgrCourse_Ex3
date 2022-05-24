package simpleREST;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Scanner;


public class TestRequest {
	
	
	 public static void main(String[] args) {
	        try {
	        	String url = "http://localhost:8080/echo";
	        	String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
	        	String message = "This is the test message";
	        	
	        	// ...

	        	String query = String.format("message=%s",
	        	    URLEncoder.encode(message, charset));
	        	   
	  
	        	
	        	  URLConnection connection = new URL(url).openConnection();
	        	  //InputStream response = connection.getInputStream();
	        	  InputStream response = new URL(url).openStream();
	        	 // URLConnection connection2 = new URL(url).openConnection();
	        	 // connection2.setDoOutput(true); // Triggers POST.
	        	  //connection2.setRequestProperty("Accept-Charset", charset);
	        	 // connection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
       
	        	  	  
	        	 try (Scanner scanner = new Scanner(response)) {
	  	           String responseBody = scanner.useDelimiter("\\A").next();
	  	           System.out.println(responseBody);
	  	        }
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
	    }
	}
