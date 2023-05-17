package adiekurniawan.demo.crud.config;

import jakarta.persistence.Entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "adiekurniawan.demo.crud.repository", repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
public class JPARepositoryConfig {
}
