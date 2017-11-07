package com.quest.webservice;

import com.quest.entity.User;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Quest on 2017/10/19.
 */
@WebService
public interface HelloWorld {
    String sayHi(@WebParam(name = "text") String text);
    String sayHiToUser(User user);
    String[] sayHiToUserList(List<User> userList);
}
