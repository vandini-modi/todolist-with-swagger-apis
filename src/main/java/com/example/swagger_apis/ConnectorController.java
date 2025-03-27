package com.example.swagger_apis;


import com.example.swagger_apis.Connector;
import com.example.swagger_apis.ConnectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/connectors") // This is the base URL path
public class ConnectorController {

    private final ConnectorService connectorService;

    public ConnectorController(ConnectorService connectorService) {
        this.connectorService = connectorService;
    }

    @PostMapping
    public ResponseEntity<Connector> createConnector(@RequestBody Connector connector) {
        Connector createdConnector = connectorService.createConnector(connector);
        return new ResponseEntity<>(createdConnector, HttpStatus.CREATED);
    }
}
