/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntp.formatter.ChucVuFormatter;
import com.ntp.formatter.GioKhamFormatter;
import com.ntp.formatter.LichTrucFormatter;
import com.ntp.formatter.LoaiThuocFormatter;
import com.ntp.formatter.NhanVienFormatter;
import com.ntp.validator.UserPassValidator;
import com.ntp.validator.WebAppValidator;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Phat Nguyen
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages =  {
    "com.ntp.controllers",
    "com.ntp.service",
    "com.ntp.repository",
    "com.ntp.formatter",
    "com.ntp.validator"
})
public class WebApplicationContextConfig implements WebMvcConfigurer{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }   
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/resources/css/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/resources/images/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/resources/js/");
    }
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new LoaiThuocFormatter());
        registry.addFormatter(new ChucVuFormatter());
        registry.addFormatter(new LichTrucFormatter());
        registry.addFormatter(new GioKhamFormatter());
        registry.addFormatter(new NhanVienFormatter());
    }
    
    

    @Override
    public Validator getValidator() {
        return validator();
    }
    
    @Bean
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        
        return v;
    }
    
    @Bean
    public WebAppValidator userPassValidator(){
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(new UserPassValidator());
        
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidators(springValidators);
        return v;
    }
    

    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver resolver
                = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    

    
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.addBasenames("benhnhan", "nhanvien", "user","thuoc");
        source.setDefaultEncoding("UTF-8");
        return source;
    }
    
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver m = new CommonsMultipartResolver();
        m.setDefaultEncoding("UTF-8");
        
        return m;
    }
    
    @Bean
    public Cloudinary cloudinary(){
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
               "cloud_name", "djfijumdi",
                "api_key", "764917583376422",
                "api_secret", "dRHvIQK9qZnTUbhFXPh3FFjh794",
                "secure", true
        ));
        return c;
    }
    
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(MyConstants.MY_EMAIL);
        mailSender.setPassword(MyConstants.MY_PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
    
    public class MyConstants {

        // Replace with your email here:  
        public static final String MY_EMAIL = "1851010096phat@ou.edu.vn";

        // Replace password!!
        public static final String MY_PASSWORD = "272732580";

        // And receiver!
        public static final String FRIEND_EMAIL = "tanphat41011@gmail.com";

    }

}
