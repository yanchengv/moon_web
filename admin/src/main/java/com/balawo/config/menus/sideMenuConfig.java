package com.balawo.config.menus;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.Resource;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class sideMenuConfig {


    //springboot+thymeleaf后端设置全局变量前端接收,配置项目的左侧菜单数据,只要放在spring能扫描到的地方就可以了.
    @Resource
    private void sideMenus(ThymeleafViewResolver viewResolver) {
        if(viewResolver != null) {
            Map<String, Object> sideMenus = new HashMap();
            sideMenus.put("sideMenu", "yan");
            viewResolver.setStaticVariables(sideMenus);
        }
    }




}
