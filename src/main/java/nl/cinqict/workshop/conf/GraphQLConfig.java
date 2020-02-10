package nl.cinqict.workshop.conf;

import com.coxautodev.graphql.tools.SchemaParserOptions;
import nl.cinqict.workshop.graphql.CustomObjectMapperConfigurer;
import nl.cinqict.workshop.graphql.GraphQLDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {
    @Bean
    public SchemaParserOptions schemaParserOptions(CustomObjectMapperConfigurer customObjectMapperConfigurer) {
        return SchemaParserOptions.newOptions()
                .objectMapperConfigurer(customObjectMapperConfigurer)
                .build();
    }

    @Bean
    public GraphQLDate graphQLLocalDate() {
        return new GraphQLDate();
    }
}
