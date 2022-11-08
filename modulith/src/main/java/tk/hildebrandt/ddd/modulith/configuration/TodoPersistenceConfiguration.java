package tk.hildebrandt.ddd.modulith.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"tk.hildebrandt.ddd.modulith.todo", "tk.hildebrandt.ddd.modulith.user"})
public class TodoPersistenceConfiguration {
}
