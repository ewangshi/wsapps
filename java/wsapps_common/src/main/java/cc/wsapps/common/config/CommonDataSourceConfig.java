package cc.wsapps.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import cc.wsapps.framework.dao.TransactionService;

@MapperScan(basePackages = "cc.wsapps.common.mapper",sqlSessionFactoryRef = "commonSqlSessionFactory")
@Configuration
public class CommonDataSourceConfig {

	@Bean(name = "commonDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.common")
	public DataSource commonDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "commonSqlSessionFactory")
	public SqlSessionFactory commonSqlSessionFactory(@Qualifier("commonDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mappers/common/*.xml"));
		return bean.getObject();
	}

	@Bean(name = "commonTransactionManager")
	public DataSourceTransactionManager commonTransactionManager(@Qualifier("commonDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(name = "commonTransactionService")
	public TransactionService commonTransactionService(@Qualifier("commonTransactionManager") DataSourceTransactionManager dataSourceTransactionManager) {
		return new TransactionService(dataSourceTransactionManager);
	}

}
