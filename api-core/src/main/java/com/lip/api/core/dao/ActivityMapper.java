package com.lip.api.core.dao;

import com.lip.api.core.model.Activity;
import com.lip.api.core.model.ActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ActivityMapper {
    int countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    @Delete({
        "delete from activity",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into activity (id, project_id, ",
        "user_id, api_id, api_name, ",
        "brief, action, time)",
        "values (#{id,jdbcType=INTEGER}, #{projectId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=VARCHAR}, #{apiId,jdbcType=INTEGER}, #{apiName,jdbcType=VARCHAR}, ",
        "#{brief,jdbcType=VARCHAR}, #{action,jdbcType=VARCHAR}, #{time,jdbcType=TIMESTAMP})"
    })
    int insert(Activity record);

    int insertSelective(Activity record);

    List<Activity> selectByExample(ActivityExample example);


    @Select({
        "select",
        "id, project_id, user_id, api_id, api_name, brief, action, time",
        "from activity",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.lip.api.core.dao.ActivityMapper.BaseResultMap")
    Activity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(Activity record);

    @Update({
        "update activity",
        "set project_id = #{projectId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "api_id = #{apiId,jdbcType=INTEGER},",
          "api_name = #{apiName,jdbcType=VARCHAR},",
          "brief = #{brief,jdbcType=VARCHAR},",
          "action = #{action,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Activity record);
}