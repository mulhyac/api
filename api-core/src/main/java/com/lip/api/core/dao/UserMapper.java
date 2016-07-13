package com.lip.api.core.dao;

import com.lip.api.core.model.User;
import com.lip.api.core.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    @Delete({
        "delete from user",
        "where name = #{name,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String name);

    @Insert({
        "insert into user (name, email, ",
        "password, gravater)",
        "values (#{name,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{gravater,jdbcType=VARCHAR})"
    })
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "name, email, password, gravater",
        "from user",
        "where name = #{name,jdbcType=VARCHAR}"
    })
    @ResultMap("com.lip.api.core.dao.UserMapper.BaseResultMap")
    User selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set email = #{email,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "gravater = #{gravater,jdbcType=VARCHAR}",
        "where name = #{name,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}