package com.flycat.dao;

import com.flycat.dao.base.BaseDao;
import com.flycat.dao.impl.AdminDaoImpl;
import com.flycat.model.Admin;
import com.flycat.util.JsonUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by flycat on 2018/7/20.
 */
@Repository
public class AdminDao extends BaseDao{
    private static String KEY_CACH_ADMIN = "KEY_CACH_ADMIN";
    @Resource
    private AdminDaoImpl adminDaoImpl;
    @Resource
    private BaseDao baseDao;
    private static Logger logger = Logger.getLogger(AdminDao.class);
    @PostConstruct
    public void init(){
        System.out.println("admin init");
    }
    public List<Admin> getAll(){
        List<Admin> adminList = null;
        String field = KEY_CACH_ADMIN+"_All";
        String value = baseDao.getHash(KEY_CACH_ADMIN,field);
        if(null==value || "".equals(value)){
            adminList = adminDaoImpl.selectAll();
            baseDao.putHash(KEY_CACH_ADMIN,field,JsonUtils.list2Json(adminList));
        }else {
            try {
                adminList = JsonUtils.json2List(value,Admin.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logger.info("List<Admin> "+JsonUtils.list2Json(adminList));
        return adminList;
    }
}
