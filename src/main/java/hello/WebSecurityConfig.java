package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest().fullyAuthenticated()
				.and()
			.formLogin();
	}

	@Bean
	public ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider(){
		ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider = new
				ActiveDirectoryLdapAuthenticationProvider("pizzashop.com.us", "ldap://10.100.100.100:389/");
		return activeDirectoryLdapAuthenticationProvider;
	}

}
