//package org.practice.springjersey.configuration;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerResponseContext;
//import javax.ws.rs.container.ContainerResponseFilter;
//import javax.ws.rs.core.MultivaluedMap;
//import java.io.IOException;
//
//@Component
//@Slf4j
//public class CORSFilter implements ContainerResponseFilter {
//
//	public CORSFilter() {
//		log.info("CORSFilter init");
//	}
//
////	@Override
////	public void filter(ServletRequest req, ServletResponse res,
////			FilterChain chain) throws IOException, ServletException {
////
////		HttpServletRequest servletRequest = (HttpServletRequest) req;
////		HttpServletResponse response = (HttpServletResponse) res;
////
////		response.addHeader("Access-Control-Allow-Origin", "*");
////	    response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
////	    response.addHeader("Access-Control-Allow-Credentials", "true");
////	    response.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, Authorization, authorization, requester-email");
////	    response.addHeader("Access-Control-Max-Age", "3600");
////
////	    if (servletRequest.getMethod() == "OPTIONS") {
////			response.setStatus(HttpServletResponse.SC_OK);
////			return;
////        }
////		chain.doFilter(req, res);
////	}
//
//	@Override
//	public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
//
//		MultivaluedMap<String, Object> headers = containerResponseContext.getHeaders();
//
//		headers.add("Access-Control-Allow-Origin", "*");
//		headers.add("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT");
//		headers.add("Access-Control-Allow-Headers", "X-Requested-With, Accept, content-type, Authorization, requester-email");
//		headers.add("Access-Control-Max-Age", "3600");
//
//		if (containerRequestContext.getMethod() == "OPTIONS") {
//			containerResponseContext.setStatus(HttpServletResponse.SC_OK);
//			return;
//        }
//	}
//}