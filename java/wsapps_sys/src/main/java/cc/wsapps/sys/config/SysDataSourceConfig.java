package cc.wsapps.sys.config;

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

@MapperScan(basePackages = "cc.wsapps.sys.mapper", sqlSessionFactoryRef = "sysSqlSessionFactory")
@Configuration
public class SysDataSourceConfig {

	@Bean(name = "sysDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.sys")
	public DataSource sysDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "sysSqlSessionFactory")
	public SqlSessionFactory sysSqlSessionFactory(@Qualifier("sysDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mappers/sys/*.xml"));
		return bean.getObject();
	}

	@Bean(name = "sysTransactionManager")
	public DataSourceTransactionManager sysTransactionManager(@Qualifier("sysDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
