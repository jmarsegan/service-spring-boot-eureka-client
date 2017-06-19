package com.jerem.service.eureka.client;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Path("/")
@Consumes({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
@Produces({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
public class Endpoint {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GET
    @Path("/hello")
    public String message() throws Exception {
        return "Hello World";
    }

    @GET
    @Path("/instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathParam("applicationName") String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @GET
    @Path("/services")
    public List<String> serviceList() {
        return this.discoveryClient.getServices();
    }

    @GET
    @Path("/helloremote")
    public String remote() {
        return restTemplate.getForObject("http://EurekaClient1/hello", String.class);
    }

}
