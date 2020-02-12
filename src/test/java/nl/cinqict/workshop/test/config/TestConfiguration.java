package nl.cinqict.workshop.test.config;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class TestConfiguration {

    @MockBean
    private ServerEndpointExporter serverEndpointExporter;

}

