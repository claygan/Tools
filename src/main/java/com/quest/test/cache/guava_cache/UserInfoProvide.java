package com.quest.test.cache.guava_cache;

import com.quest.entity.User;

/**
 * Created by Quest on 2018/5/15.
 */
public class UserInfoProvide extends BaseProvide<User> {
    @Override
    User loadData(String key) {
        switch (key){
            case "1":
                User u = new User();
                u.setUsername("库里");
                u.setTel("1111111");
                return u;
            case "2":
                User u1 = new User();
                u1.setUsername("詹姆斯");
                u1.setTel("2222222");
                return u1;
            case "3":
                User u2 = new User();
                u2.setUsername("杜兰特");
                u2.setTel("3333333");
                return u2;
            case "4":
                User u3 = new User();
                u3.setUsername("哈登");
                u3.setTel("4444444");
                return u3;
        }
        return null;
    }
}
