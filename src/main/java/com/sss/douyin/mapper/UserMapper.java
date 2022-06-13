package com.sss.douyin.mapper;

import com.sss.douyin.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);

    @Select("select * from user where username = #{username}")
    User findUserByUsername(String username);

    /*增*/
    @Insert("INSERT into user(username, password) "
            +"value(#{username}, #{password})")
    /*主键回填*/
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    int addUser(User user);

}
