package jdonee.mybatis.springboot.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web环境配置
 * 
 * @author Frank.Zeng
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	// @Override
	// public void configureViewResolvers(ViewResolverRegistry registry) {
	// registry.enableContentNegotiation(new MappingJackson2JsonView());
	// registry.freeMarker().cache(false);
	// }

}
