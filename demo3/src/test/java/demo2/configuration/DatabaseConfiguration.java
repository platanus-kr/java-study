package demo2.configuration;

import javax.activation.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {
	
	@Bean 
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	@Bean
	public DataSource dataSource() throws Exception{
		DataSource dataSource = (DataSource) new HikariDataSource(hikariConfig());
		System.out.println(dataSource.toString());
		return dataSource;
		
	}
	
}
