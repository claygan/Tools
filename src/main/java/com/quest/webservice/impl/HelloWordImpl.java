package com.quest.webservice.impl;

import com.quest.entity.User;
import com.quest.webservice.HelloWorld;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Quest on 2017/10/19.
 */
@WebService(endpointInterface = "com.quest.webservice.HelloWorld",serviceName = "helloWorld")
public class HelloWordImpl implements HelloWorld {
    Map<Integer, User> users = new LinkedHashMap<Integer, User>();

    @Override
    public String sayHi(@WebParam(name = "text") String text) {
        return "Hello,"+text;
    }

    @Override
    public String sayHiToUser(User user) {
        users.put(users.size() + 1, user);
        return "Hello,"+user.getUsername();
    }

    @Override
    public String[] sayHiToUserList(List<User> userList) {
        String[] result = new String[userList.size()];
        int i = 0;
        for(User u:userList){
            result[i] = "Hello " + u.getUsername();
            i++;
        }
        return result;
    }
}
