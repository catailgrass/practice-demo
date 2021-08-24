package com.flycat.controller;

import com.flycat.model.Admin;
import com.flycat.service.AdminService;
import com.flycat.util.JsonUtils;
import com.google.gson.JsonArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by flycat on 2018/7/20.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    private Logger logger = Logger.getLogger(AdminController.class);
    @RequestMapping(value = "/getAll")
    public String getAllAdmin(Model model){
        try {
            List<Admin> adminList = adminService.getAll();
            for (Admin admin:adminList){
                logger.debug("=============admin log============"+admin.getuName());
                logger.error("=============admin error============"+admin.getuName());
            }
            return JsonUtils.list2Json(adminList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
