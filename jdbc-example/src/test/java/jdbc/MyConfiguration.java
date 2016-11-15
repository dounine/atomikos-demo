package jdbc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by huanghuanlai on 2016/11/12.
 */
@Configuration
@PropertySource("classpath:config.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.dounine.jta","jdbc"},
        excludeFilters = {@ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                value = {Configuration.class})})
public class MyConfiguration {
}
