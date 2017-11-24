package org.academiadecodigo.hackathon.jesusfindr;

import java.util.HashMap;
import java.util.Map;

public final class ServiceRegistry {

    private static ServiceRegistry instance = null;
    private Map<String, Service> services = new HashMap<>();

    private ServiceRegistry(){}

    public void addService(String name, Service service){
        services.put(name, service);
    }

    public Service getService(String name){
        return services.get(name);
    }

    public static synchronized ServiceRegistry getInstance() {

        if (instance == null){
            instance = new ServiceRegistry();
        }

        return instance;
    }
}