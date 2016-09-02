package jdonee.mybatis.springboot.conf;

import org.apache.ibatis.session.ExecutorType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import lombok.Data;

/**
 * Mybatis属性配置
 * 
 * @author Frank.Zeng
 *
 */
@Data
@ConfigurationProperties(prefix = "mybatis")
public class MybatisProperties {

	/**
	 * Config file path.
	 */
	private String config;

	/**
	 * Location of mybatis mapper files.
	 */
	private Resource[] mapperLocations;

	/**
	 * Package to scan domain objects.
	 */
	private String typeAliasesPackage;

	/**
	 * Package to scan handlers.
	 */
	private String typeHandlersPackage;

	/**
	 * Check the config file exists.
	 */
	private boolean checkConfigLocation = false;

	/**
	 * Execution mode.
	 */
	private ExecutorType executorType = ExecutorType.SIMPLE;
}
