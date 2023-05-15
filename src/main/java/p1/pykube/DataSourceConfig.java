package p1.pykube;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

	/**
	 * this object is manage by spring container -is known as spring bean
	 * @return
	 */
	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSourceBuilder = new DriverManagerDataSource();
		dataSourceBuilder.setUsername("root");
		dataSourceBuilder.setPassword("mysql@1234");
		dataSourceBuilder.setUrl("jdbc:mysql://localhost:3306/batch100_db");
		dataSourceBuilder.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSourceBuilder;
	}
	
	//@Bean - is used to create a bean define inside java based configuration file

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate createJdbcTenplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.mysqlDataSource());
		return jdbcTemplate;
	}

}
