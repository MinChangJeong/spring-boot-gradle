package backend.boot.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.sql.DataSource;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"backend.boot.business", "backend.boot.model", "backend.boot.common"})
public class MvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
    }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // Connection Pool
    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:13306/[DB Name]?serverTimezone=UTC");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");

        return new HikariDataSource(hikariConfig);
    }

    // mybatis
    @Bean
    public SqlSessionFactory sessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver pmrpr = new PathMatchingResourcePatternResolver();
        Resource resource_path = pmrpr.getResource("classpath:sql-map-config.xml");

        sessionFactoryBean.setConfigLocation(resource_path);
        return sessionFactoryBean.getObject();
    }


    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sessionFactory());
    }
}