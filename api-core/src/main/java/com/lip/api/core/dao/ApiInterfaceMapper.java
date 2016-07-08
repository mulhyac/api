package com.lip.api.core.dao;

import com.lip.api.core.model.ApiInterface;
import com.lip.api.core.model.ApiInterfaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ApiInterfaceMapper {
    int countByExample(ApiInterfaceExample example);

    int deleteByExample(ApiInterfaceExample example);

    @Delete({
        "delete from api_interface",
        "where aid = #{aid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer aid);

    @Insert({
        "insert into api_interface (aid, cid, ",
        "url, method, description, ",
        "add_time, update_time)",
        "values (#{aid,jdbcType=INTEGER}, #{cid,jdbcType=INTEGER}, ",
        "#{url,jdbcType=VARCHAR}, #{method,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{addTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(ApiInterface record);

    int insertSelective(ApiInterface record);

    List<ApiInterface> selectByExample(ApiInterfaceExample example);

    @Select({
        "select",
        "aid, cid, url, method, description, add_time, update_time",
        "from api_interface",
        "where aid = #{aid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lip.api.core.dao.ApiInterfaceMapper.BaseResultMap")
    ApiInterface selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") ApiInterface record, @Param("example") ApiInterfaceExample example);

    int updateByExample(@Param("record") ApiInterface record, @Param("example") ApiInterfaceExample example);

    int updateByPrimaryKeySelective(ApiInterface record);

    @Update({
        "update api_interface",
        "set cid = #{cid,jdbcType=INTEGER},",
          "url = #{url,jdbcType=VARCHAR},",
          "method = #{method,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where aid = #{aid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ApiInterface record);
}