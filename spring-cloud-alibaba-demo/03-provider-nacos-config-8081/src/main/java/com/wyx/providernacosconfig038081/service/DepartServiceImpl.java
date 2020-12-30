package com.wyx.providernacosconfig038081.service;

import com.wyx.providernacosconfig038081.bean.Depart;
import com.wyx.providernacosconfig038081.config.WyxConfig;
import com.wyx.providernacosconfig038081.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.List;

@RefreshScope // 如果想要实现动太配置需要加上这个注解
@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository repository;

    @Value("${depart.name}")
    private String departName;
    @Autowired
    private WyxConfig wyxConfig;

    @Override
    public boolean saveDepart(Depart depart) {
        Depart obj = repository.save(depart);
        if(obj != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDepartById(int id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart obj = repository.save(depart);
        if(obj != null) {
            return true;
        }
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
        if(repository.existsById(id)) {
            Depart depart = repository.getOne(id);
            depart.setName(depart.getName() + departName + "--" + wyxConfig.getName() + wyxConfig.getAge());
            return depart;
        }
        Depart depart = new Depart();
        depart.setName("no this depart " + departName + "--" + wyxConfig.getName() + wyxConfig.getAge());
        return depart;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return repository.findAll();
    }
}
