package com.feng.yaxin.authority;

import org.hibernate.validator.HibernateValidator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.validation.Validation;
import javax.validation.Validator;

@MapperScan("com.feng.yaxin.authority.mapper")
@SpringBootApplication
public class AuthorityApplication {

    public static void main(String[] args) {

        SpringApplication.run(AuthorityApplication.class, args);
    }

    /**
     * 验证器
     */
    @Bean
    public Validator validator() {
        return Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
    }

}
