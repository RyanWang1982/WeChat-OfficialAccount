package wang.yongrui.wechat.officialaccount;

import static wang.yongrui.wechat.constant.SystemConstant.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = { SYSTEM_PACKAGE })
@EnableJpaAuditing
@Configuration
@EnableSwagger2
public class WeChatOfficialAccountApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WeChatOfficialAccountApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WeChatOfficialAccountApplication.class, args);
	}

	/**
	 * @return
	 */
	@Bean
	public Docket swaggerAPI() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(SYSTEM_PACKAGE)).paths(PathSelectors.any()).build();
	}

}
