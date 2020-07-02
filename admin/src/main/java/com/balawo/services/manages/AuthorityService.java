package com.balawo.services.manages;

import com.balawo.models.Authority;
import com.balawo.repository.manages.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    //获取所有的权限
    public HashSet getAllAuthorities() {
        var urls = new HashSet<String>();
        var allAuthorities = authorityRepository.findAll();
        for (Authority auth: allAuthorities) {
            urls.add(auth.getAction());
        }
        return urls;
    }

    //根据type把所有权限分组{1=[{id:1,name: '权限名称',action: 'url'}]}
    public HashMap getAllAuthoritiesGroupByType(){
        var authorities =  authorityRepository.findAll(Sort.by(Sort.Direction.ASC, "type"));

        HashMap<Integer, List<Authority>> hashMap = new HashMap<Integer, List<Authority>>();
        for(Authority auth: authorities){
            if(!hashMap.containsKey(auth.getType())){
                List<Authority> list = new ArrayList<Authority>();
                list.add(auth);
                hashMap.put(auth.getType(),list);
            }else{
                hashMap.get(auth.getType()).add(auth);
            }
        }
        return hashMap;
    }

}
