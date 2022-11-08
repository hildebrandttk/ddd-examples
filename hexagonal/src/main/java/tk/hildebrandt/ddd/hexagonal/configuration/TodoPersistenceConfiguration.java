package tk.hildebrandt.ddd.hexagonal.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "tk.hildebrandt.ddd.hexagonal")
public class TodoPersistenceConfiguration {
}
