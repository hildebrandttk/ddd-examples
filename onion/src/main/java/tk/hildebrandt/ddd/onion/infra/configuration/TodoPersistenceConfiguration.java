package tk.hildebrandt.ddd.onion.infra.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "tk.hildebrandt.ddd.onion.infra.jpa")
public class TodoPersistenceConfiguration {
}
