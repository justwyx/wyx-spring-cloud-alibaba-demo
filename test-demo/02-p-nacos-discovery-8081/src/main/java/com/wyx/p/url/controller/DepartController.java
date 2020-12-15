package com.wyx.p.url.controller;

import com.wyx.p.url.bean.Depart;
import com.wyx.p.url.service.DepartService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;


@RequestMapping("/provider/depart")
@RestController
public class DepartController {
    @Resource
    private DepartService service;

    @Resource
    private DiscoveryClient client;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        return service.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id) {
        return service.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandle(@RequestBody Depart depart) {
        return service.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return service.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return service.listAllDeparts();
    }

    // http://localhost:8081/provider/depart/discovery
    @GetMapping("/discovery")
    public List<String> discoveryHandle() {
        List<String> services = client.getServices();
        for (String serviceName : services) {
            List<ServiceInstance> instances = client.getInstances(serviceName);
            for (ServiceInstance instance : instances) {
                String serviceId = instance.getServiceId();
                String host = instance.getHost();
                int port = instance.getPort();
                URI uri = instance.getUri();
                System.out.println("serviceId = " + serviceId);
                System.out.println("host = " + host);
                System.out.println("port = " + port);
                System.out.println("uri = " + uri);
            }
        }
        return services;
    }
}
