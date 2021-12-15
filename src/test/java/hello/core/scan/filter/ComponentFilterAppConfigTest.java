package hello.core.scan.filter;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            ComponentFilterAppConfig.class);
        ComponentFilterAppConfig beanA = ac.getBean(ComponentFilterAppConfig.class);

        assertThat(beanA).isNotNull();

        assertThrows(NoSuchBeanDefinitionException.class,
            () -> ac.getBean("beanB", BeanB.class));
    }

    @Configuration
    @ComponentScan(
        includeFilters = @Filter(classes = MyIncludeComponent.class),
        excludeFilters = @Filter(classes = MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {

    }
}
