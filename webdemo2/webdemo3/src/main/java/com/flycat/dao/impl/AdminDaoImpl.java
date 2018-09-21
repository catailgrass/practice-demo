package com.flycat.dao.impl;

import com.flycat.dao.base.MyBatisRepository;
import com.flycat.model.Admin;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by flycat on 2018/7/20.
 */
@Component
@MyBatisRepository
public interface AdminDaoImpl {
    List<Admin> selectAll();
}
