package network.week1;

import java.net.*;
import java.util.*;

public class MyProxy extends PrivacyProxy {

    //////////////////////////////////////////////////////////////////////////
    //
    // Enhance your proxy by implementing the following three methods:
    //   - manipulateRequestHeaders
    //   - onRequest
    //   - onResponse
    //
    //////////////////////////////////////////////////////////////////////////

    protected HashMap<String, String> onRequest(HashMap<String, String> requestHeaders){
    	
    	if(requestHeaders.get("Accept").equals("*/*") || requestHeaders.get("Accept").contains("javascript")){
    		return null;
    	}
    	requestHeaders.remove("Cookie");
    	
        // print all the request headers 
        for (String header : requestHeaders.keySet()) {
        	if(header.equals("User-Agent")){
        		requestHeaders.replace(header, "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Acoo Browser; GTB5; Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1) ; Maxthon; InfoPath.1; .NET CLR 3.5.30729; .NET CLR 3.0.30618");
        	}
        	if(header.equals("Accept-Encoding")){
        		requestHeaders.replace(header, "identity");
        	}
        	
            log("  REQ: " + header + ": " + requestHeaders.get(header));
        }

        return requestHeaders;

        // return the (manipulated) headers, or
        // alternatively, drop this request by returning null
        // return null;
    }


    // The number of valid bytes in the buffer is expressed by the inOctets instance variable
    // e.g. log("I received " + this.inOctets + " bytes");
    protected byte[] onResponse(byte[] originalBytes){
        byte[] alteredBytes = originalBytes;
        log("I received " + this.inOctets + " bytes");

        for (String header : responseHeaders.keySet()) {
            log("  RSP: " + header + ": " + responseHeaders.get(header));

//            if (header.equals("Content-Type") && responseHeaders.get("Content-Type").startsWith("text/html")) {
               String s = new String(originalBytes);
               String s2 = s.replaceAll("iframe", "superaids");
               s2 = s2.replaceAll("navigator","superaids");
               alteredBytes = s2.getBytes();
//            }

        }

        // alter the original response and return it
        
        return alteredBytes;
    }

    
    // Constructor, no need to touch this
    public MyProxy(Socket socket, Boolean autoFlush) {
        super(socket, autoFlush);
    }
}