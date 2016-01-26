package com.potkal.bendenetteyim.spring.conf;


import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.potkal.bendenetteyim.spring.ServiceProvider;

@ComponentScan ({
	"com.potkal.bendenetteyim.spring.business"
})
@Configuration
@EnableTransactionManagement
//@PropertySource("default.properties")
//@PropertySource(value = "file:${CONF_DIR}/optional-override.properties", ignoreResourceNotFound = true)
public class MainConfiguration {

	@Bean
	public ServiceProvider serviceProvider () {
		return new ServiceProvider();
	}
	
//	public DataSource getDataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/usersdb");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("");
//		dataSource.setMinIdle(20);
//		dataSource.setMaxTotal(10);
//		dataSource.setInitialSize(100);
//		
//		return dataSource;
//	}

//	@Autowired
//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource) {
//		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//		adjustPackagesToScan(sessionBuilder);
//		adjustHibernateProperties(sessionBuilder);
//		return sessionBuilder.buildSessionFactory();
//	}
	
//	private void adjustPackagesToScan (LocalSessionFactoryBuilder sessionBuilder) {
//		String [] packages = getPackages();
//		if (ArrayUtils.isNotEmpty(packages)) {
//			sessionBuilder.addPackages(getPackages ());
//		}
//	}
	
//	private void adjustHibernateProperties (LocalSessionFactoryBuilder sessionBuilder) {
//		Properties properties = getHibernateProperties();
//		if (properties != null) {
//			sessionBuilder.setProperties(getHibernateProperties());
//		}
//	}


	protected String [] getPackages() {
		return null;
	}

	protected Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.c3p0.min_size",5);
		properties.put("hibernate.c3p0.max_size", 20);
		properties.put("hibernate.c3p0.timeout",300);
		properties.put("hibernate.c3p0.max_statements",50);
		properties.put("hibernate.c3p0.idle_test_period",3000);		
		return properties;
	}

//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//		return transactionManager;
//	}
}