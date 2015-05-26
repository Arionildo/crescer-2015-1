package filmator;

import javax.inject.Inject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.MustacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;


@SpringBootApplication
public class ServidorWeb {
	
	
	@Inject
	private MustacheProperties mustache;

	@Bean
	public CustomMustacheViewResolver viewResolver(com.samskivert.mustache.Mustache.Compiler mustacheCompiler){
		CustomMustacheViewResolver resolver = new CustomMustacheViewResolver();
		resolver.setPrefix(this.mustache.getPrefix());
		resolver.setSuffix(this.mustache.getSuffix());
		resolver.setCache(this.mustache.isCache());
		resolver.setViewNames(this.mustache.getViewNames());
		resolver.setContentType(this.mustache.getContentType());
		resolver.setCharset(this.mustache.getCharset());
		resolver.setCompiler(mustacheCompiler);
		resolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
		return resolver;
	}

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServidorWeb.class, args);
	}
}
