package com.flycat.service;

import com.flycat.dao.AdminDao;
import com.flycat.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {
    @Resource
    private AdminDao adminDao;
    public List<Admin> getAll(){
        return adminDao.getAll();
    }
}
