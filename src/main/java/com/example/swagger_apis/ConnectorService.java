package com.example.swagger_apis;

import com.example.swagger_apis.Connector;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ConnectorService {
    private final ConcurrentHashMap<String, Connector> connectors = new ConcurrentHashMap<>();

    public Connector createConnector(Connector connector) {
        connector.setId(UUID.randomUUID().toString()); // Auto-generate ID
        connectors.put(connector.getId(), connector);
        return connector;
    }
}
