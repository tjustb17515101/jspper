package com.lin.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.mapper.impl.UserDao;
import com.lin.pojo.User;
import com.lin.utils.JsonUtils;
import com.lin.utils.PageResult;
import com.lin.utils.jedis.impl.JedisClientSingle;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JedisClientSingle jedisClient;

    @Autowired
    private JsonUtils jsonUtils;

    /**
     * @param num       :页数
     * @param size      :每一页显示的数据条数
     * @param key       :排序字段
     * @param optionNum :连续出现几个页码
     * @return
     */
    public PageInfo findAll(Integer num, int size, String key, int optionNum) {
        if (num == null || num < 0) {
            num = 1;
        }
        List<User> userList = new ArrayList<>();
        PageHelper.startPage(num, size, key);
        userList = userDao.findAll();
        PageInfo<User> userPageInfo = new PageInfo<>(userList, optionNum);
        return userPageInfo;
    }


    public Integer addUser(User user) {
        int res = 0;
        if(user!=null){
            if((res = userDao.addUser(user))>0){
                String json = jsonUtils.objectToJson(user);
                jedisClient.hset("tbUsers","findByUno_"+user.getUno(),json);
            }
        }
        return res;
    }

    public Boolean delete(Integer uno) {
        String json = jedisClient.hget("tbUsers", "findByUno_" + uno);
        System.out.println("delete:" + json);
        if (!StringUtils.isEmpty(json)) {
            jedisClient.hdel("tbUsers", "findByUno_" + uno);
        }
        return userDao.removeUser(uno);
    }

    public User findByUno(int uno) {
        User user = null;
        String json = jedisClient.hget("tbUsers", "findByUno_" + uno);
        if (!StringUtils.isEmpty(json)) {
            user = jsonUtils.jsonToPojo(json, User.class);
        } else {
            user = userDao.findByNo(uno);
            if(user!=null)
                jedisClient.hset("tbUsers", "findByUno_" + uno, jsonUtils.objectToJson(user));
        }
        return user;
    }

    @Test
    public void test() {
        System.out.println(StringUtils.isEmpty(null));
    }
}
