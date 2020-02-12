package nl.cinqict.workshop.graphql;

import graphql.language.ScalarTypeDefinition;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLDirective;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class GraphQLDate extends GraphQLScalarType implements Serializable {

    private static final String DEFAULT_NAME = "Date";
    private static final String DD_MM_YYYY = "dd/MM/yyyy";

    public GraphQLDate() {
        super(DEFAULT_NAME, DEFAULT_NAME, new Coercing() {

            @Override
            public Object serialize(Object o) throws CoercingSerializeException {
                if (o instanceof LocalDate) {
                    return ((LocalDate) o).format(DateTimeFormatter.ofPattern(DD_MM_YYYY));
                }

                throw new CoercingParseValueException("Invalid value '" + o + "' for LocalDate");
            }

            @Override
            public LocalDate parseValue(Object o) throws CoercingParseValueException {
                if (o instanceof String) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DD_MM_YYYY);
                    LocalDate result = LocalDate.parse((String) o, formatter);

                    if (result != null) {
                        return result;
                    }
                }

                throw new CoercingParseValueException("Invalid value '" + o + "' for LocalDate");

            }

            @Override
            public LocalDate parseLiteral(Object o) throws CoercingParseLiteralException {
                if (!(o instanceof StringValue)) return null;
                String value = ((StringValue) o).getValue();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DD_MM_YYYY);
                LocalDate result = LocalDate.parse(value, formatter);
                return result;
            }
        });
    }

    public GraphQLDate(String name, String description, Coercing coercing, List<GraphQLDirective> directives, ScalarTypeDefinition definition) {
        super(name, description, coercing, directives, definition);
    }

}
