package jdonee.mybatis.springboot.conf;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import jdonee.mybatis.springboot.util.interceptor.PerformanceInterceptor;
import lombok.extern.slf4j.Slf4j;

/**
 * 我调整啦
 * 
 * @author Frank.Zeng
 *
 */
@Configuration
@ConditionalOnClass({ SqlSessionFactory.class, SqlSessionFactoryBean.class })
// @ConditionalOnBean(DataSource.class)
@EnableConfigurationProperties(MybatisProperties.class)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
@Slf4j
public class MybatisAutoConfiguration {

	@Autowired
	private MybatisProperties properties;

	@Autowired(required = false)
	private Interceptor[] interceptors;

	@Autowired
	private ResourceLoader resourceLoader = new DefaultResourceLoader();

	@PostConstruct
	public void checkConfigFileExists() {
		if (this.properties.isCheckConfigLocation()) {
			Resource resource = this.resourceLoader.getResource(this.properties.getConfig());
			Assert.state(resource.exists(), "Cannot find config location: " + resource
					+ " (please add config file or check your Mybatis " + "configuration)");
		}
	}

	@Bean(name = "sqlSessionFactory")
	@ConditionalOnMissingBean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		if (StringUtils.hasText(this.properties.getConfig())) {
			factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfig()));
		} else {
			log.debug("拦截器数量：" + this.interceptors.length);
			if (this.interceptors != null && this.interceptors.length > 0) {
				factory.setPlugins(this.interceptors);
			}
			factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
			factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
			factory.setMapperLocations(this.properties.getMapperLocations());
		}
		return factory.getObject();
	}

	@Bean
	@ConditionalOnMissingBean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory, this.properties.getExecutorType());
	}

	/**
	 * 性能分析器
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public PerformanceInterceptor performanceInterceptor(DataSource dataSource) {
		log.info("注册MyBatis性能拦截器，用于输出每条 SQL 语句及其执行时间，会影响性能，仅推荐开发环境使用");
		return new PerformanceInterceptor();
	}

	/**
	 * 分页插件
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public PageHelper pageHelper(DataSource dataSource) {
		log.info("注册MyBatis分页插件PageHelper");
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		// p.setProperty("offsetAsPageNum", "true");
		// p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		p.setProperty("supportMethodsArguments", "true");
		p.setProperty("returnPageInfo", "check");
		p.setProperty("params", "count=countSql");
		pageHelper.setProperties(p);
		return pageHelper;
	}

}
