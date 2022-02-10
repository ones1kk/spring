package hello.core.scan;

import hello.core.AutoAppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            AutoAppConfig.class);

        AutoAppConfig bean = ac.getBean(AutoAppConfig.class);

        Assertions.assertThat(bean).isInstanceOf(AutoAppConfig.class);
    }

}
