package com.balawo.config.menus;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import javax.annotation.Resource;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class sideMenuConfig {


    //springboot+thymeleaf后端设置全局变量前端接收,配置项目的左侧菜单数据,只要放在spring能扫描到的地方就可以了.
    @Resource
    private void sideMenus(ThymeleafViewResolver viewResolver) throws IOException {
        if(viewResolver != null) {
            String path = sideMenuConfig.class.getClassLoader().getResource("static/data/menus/side_menus.json").getPath();
            String s = readJsonFile(path);
            JSONArray allMenus = JSONObject.parseArray(s.replace(" ",""));
            //((JSONObject) list.get(0)).get("parent")
            Map<String, Object> sideMenus = new HashMap();
            sideMenus.put("sideMenus", allMenus);
            viewResolver.setStaticVariables(sideMenus);
        }
    }

    /**
     * 读取json文件，返回json串
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }





}
