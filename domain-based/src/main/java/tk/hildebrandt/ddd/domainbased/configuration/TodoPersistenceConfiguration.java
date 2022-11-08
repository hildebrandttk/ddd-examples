package tk.hildebrandt.ddd.domainbased.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"tk.hildebrandt.ddd.domainbased.todo", "tk.hildebrandt.ddd.domainbased.user"})
public class TodoPersistenceConfiguration {
}
