package com.wyx.providernacosconfig038081.service;


import com.wyx.providernacosconfig038081.bean.Depart;

import java.util.List;

public interface DepartService {
    boolean saveDepart(Depart depart);
    boolean removeDepartById(int id);
    boolean modifyDepart(Depart depart);
    Depart getDepartById(int id);
    List<Depart> listAllDeparts();
}
