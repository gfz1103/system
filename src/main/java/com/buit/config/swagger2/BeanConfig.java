package com.buit.config.swagger2;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
* @ClassName: BeanConfig
* @Description: 接口文档配置
* @author 神算子
* @date 2020年4月26日 下午4:09:06
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class BeanConfig {

	@Bean(value = "defaultApi1")
    public Docket defaultApi1() {
		ParameterBuilder ticketPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		ticketPar.name("token").description("token")//name表示名称，description表示描述
				.modelRef(new ModelRef("string")).parameterType("header")
				.required(false).defaultValue("").build();//required表示是否必填，defaultvalue表示默认值
		pars.add(ticketPar.build());//添加完此处一定要把下边的带***的也加上否则不生效
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.directModelSubstitute(Timestamp.class, String.class)
				.directModelSubstitute(Date.class, String.class)
				.apiInfo(apiInfo())
				.groupName("用户")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.buit.his.user.controller"))
				.paths(PathSelectors.any())
				.build().globalOperationParameters(pars);
		return docket;
	}
	@Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
        		.directModelSubstitute(Timestamp.class, String.class)
        		.directModelSubstitute(Date.class, String.class)
                .apiInfo(apiInfo())
                .groupName("参数配置")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.buit.his.param.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
	@Bean(value = "defaultApi3")
	public Docket defaultApi3() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.directModelSubstitute(Timestamp.class, String.class)
				.directModelSubstitute(Date.class, String.class)
				.apiInfo(apiInfo())
				.groupName("通用查询")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.buit.his.sys.adminms.controller"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}
	@Bean(value = "defaultApi4")
	public Docket defaultApi4() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.directModelSubstitute(Timestamp.class, String.class)
				.directModelSubstitute(Date.class, String.class)
				.apiInfo(apiInfo())
				.groupName("中心维护")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.buit.his.sys.centermaintenance.controller"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}
	@Bean(value = "defaultApi5")
	public Docket defaultApi5() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.directModelSubstitute(Timestamp.class, String.class)
				.directModelSubstitute(Date.class, String.class)
				.apiInfo(apiInfo())
				.groupName("系统消息")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.buit.his.sys.msg.controller"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}

	@Bean(value = "defaultApi6")
	public Docket defaultApi6() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.directModelSubstitute(Timestamp.class, String.class)
				.directModelSubstitute(Date.class, String.class)
				.apiInfo(apiInfo())
				.groupName("物资OPEN API")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.buit.his.sys.openapi.rest"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}

	@Bean(value = "defaultApi7")
	public Docket defaultApi7() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.directModelSubstitute(Timestamp.class, String.class)
				.directModelSubstitute(Date.class, String.class)
				.apiInfo(apiInfo())
				.groupName("医院字典 API")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.buit.his.dic.controller"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("云his系统").description("敢不敢做一个能上生产的系统，没有撤退可言。。兽人永不为奴。。")
				.termsOfServiceUrl("http://hisdev.51app.com/api").version("1.0").build();
	}

}
