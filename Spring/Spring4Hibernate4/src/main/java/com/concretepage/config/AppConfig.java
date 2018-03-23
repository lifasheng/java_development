package com.concretepage.config;  

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import java.util.Properties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.concretepage.dao.IPersonDao;
import com.concretepage.dao.PersonDao;
import com.concretepage.entity.Person;
  
@Configuration 
@EnableTransactionManagement // equiv to <tx:annotation-driven/>
// @EnableAspectJAutoProxy(proxyTargetClass=true) // equiv to <aop:aspectj-autoproxy/>
public class AppConfig {  
	@Bean  
    public IPersonDao personDao() {  
        return new PersonDao();  
    }
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(getDataSource());
		builder.addAnnotatedClasses(Person.class);
		builder.addProperties(buildHibernateProperties());
		return builder.buildSessionFactory();
	}
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/concretepage");
	    dataSource.setUsername("root");
	    dataSource.setPassword("root");
	 
	    return dataSource;
	}

	@Bean
	public HibernateTransactionManager transactionManager(){
		return new HibernateTransactionManager(sessionFactory());
	}

	/**
	 * These were taken, with comments, from application-config conversion
	 */
	private Properties buildHibernateProperties() {
		Properties props = new Properties();

		// Set the default-schema for Hibernate to use.
		props.setProperty("hibernate.default_schema", "concretepage");

		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		// Sets the DEBUG Level of the hibernate: SQL generation layer.
		props.setProperty("hibernate.show_sql", "true");

		props.setProperty("hibernate.generate_statistics", "false");

		props.setProperty("hibernate.order_updates", "true");
		props.setProperty("hibernate.order_inserts", "true");

		// Not needed as we have Spring: http://stackoverflow.com/questions/4293098/how-to-integrate-spring-with-hibernate-session-and-transaction-management
		// props.setProperty("hibernate.current_session_context_class", "org.hibernate.context.internal.ThreadLocalSessionContext");

		props.setProperty("hibernate.cache.use_query_cache", "false");
		props.setProperty("hibernate.cache.use_second_level_cache", "false");
		return props;
	}
}
 