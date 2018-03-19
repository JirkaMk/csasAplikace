package tasks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SpringSchedullerConfig {

    //prirazuje pod spravu Spring scheduleru tridu BranchBussinessUpdate
	@Bean
    public BranchBussinessUpdate bean() {
        return new BranchBussinessUpdate();
    }
}
