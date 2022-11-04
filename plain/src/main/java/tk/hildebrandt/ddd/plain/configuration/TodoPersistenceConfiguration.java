package tk.hildebrandt.ddd.plain.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "tk.hildebrandt.ddd.plain.todo")
public class TodoPersistenceConfiguration {
}
