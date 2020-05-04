package com.lin.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.pojo.User;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义JSON响应结构
 */
@Component
public class JsonUtils {

    // 定义jackson对象
    private final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     * @param data
     * @return
     */
    public String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @param clazz 对象中的object类型
     * @return
     */
    public <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     * @param jsonData
     * @param beanType
     * @return
     */
    public <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

    	return null;
    }


    @Test
    public void testToJson(){
        List<User> list = new ArrayList<>();
        User user1 = new User(1001,"pass1","name1", (byte) 1);
        User user2 = new User(1002,"pass2","name2", (byte) 0);
        User user3 = new User(1003,"pass3","name3", (byte) 0);
        User user4 = new User(1004,"pass4","name4", (byte) 1);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        String json = objectToJson(user1);
        System.out.println(json);

//        List<User> users = jsonToList(json, User.class);
//        for(User user:users){
//            System.out.println(user);
//        }
    }
}
