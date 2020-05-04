package com.lin.mapper;

import com.lin.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select({"select * from tb_users"})
    public List<User> findAll();

    @Select("select count(*) from tb_users")
    public Long count();

    @Select("select * from tb_users where uno = #{uno}")
    public User findByNo(int uno);

    @Insert({"insert into tb_users(uno,upass,uname,sex) values(#{uno},#{upass},#{uname},#{sex})"})
    public int addUser(User user);

    @Update("update tb_users set upass = #{upass},uname=#{uname},sex=#{sex} where uno=#{uno}")
    public boolean update(User user);

    @Delete("delete from tb_users where uno=#{uno}")
    public boolean removeUser(int uno);
}

