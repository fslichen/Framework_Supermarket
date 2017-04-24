package evolution.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
// The configuration class name should be unique otherwise there will be a class name conflict.
public class FilterConfiguration {
	@Bean// Define a Servlet by creating a FilterRegistrationBean.
	public FilterRegistrationBean anyFilterRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(new AnyFilter());
	    registration.addUrlPatterns("/*");// URL Pattern
	    registration.addInitParameter("anyName", "anyValue");
	    registration.setName("anyFilter");// Filter Name
	    registration.setOrder(1);// Lower number corresponds to higher priority.
	    return registration;
	} 
	
	@Bean
	public FilterRegistrationBean anotherFilterRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(new AnotherFilter());
	    registration.addUrlPatterns("/*");
	    registration.addInitParameter("anyName", "anyValue");
	    registration.setName("anotherFileter");
	    registration.setOrder(2);
	    return registration;
	} 
	
	@Bean
	public FilterRegistrationBean characterEncodingFilter() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setName("characterEncodingFilter");
	    registration.setFilter(new CharacterEncodingFilter());
	    registration.addInitParameter("encoding", "UTF-8");
	    registration.addInitParameter("forceEncoding", "true");
	    registration.addUrlPatterns("/*");
	    registration.setOrder(0);
	    return registration;
	} 
}
