package de.broscode.wsv.connection;

import java.io.IOException;

import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.remoting.httpinvoker.CommonsHttpInvokerRequestExecutor;
import org.springframework.remoting.httpinvoker.HttpInvokerClientConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;

public class BasicAuthenticationCommonsHttpInvokerRequestExecutor extends
	CommonsHttpInvokerRequestExecutor {
	
	@Override
	protected PostMethod createPostMethod(HttpInvokerClientConfiguration config) throws IOException {
	  PostMethod postMethod = super.createPostMethod(config);
	
	  Authentication auth =
	      SecurityContextHolder.getContext().getAuthentication();
	
	  if ((auth != null) && (auth.getName() != null) &&
	        (auth.getCredentials() != null)) {
	    String base64 = auth.getName() + ":" + auth.getCredentials().toString();
	    postMethod.setRequestHeader("Authorization", "Basic " +
	        new String(Base64.encode(base64.getBytes())));
	  }
	
	  return postMethod;
	}
}