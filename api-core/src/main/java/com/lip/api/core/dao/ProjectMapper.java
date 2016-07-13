package com.lip.api.core.dao;

import com.lip.api.core.model.Project;
import com.lip.api.core.model.ProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProjectMapper {
    int countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    @Delete({
        "delete from project",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
    @Select({
            "select last_insert_id()"
    })
    int getInsertId();
    @Insert({
        "insert into project (id, name, ",
        "description, type, ",
        "logo, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{logo,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExample(ProjectExample example);

    @Select({
        "select",
        "id, name, description, type, logo, create_time, update_time",
        "from project",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.lip.api.core.dao.ProjectMapper.BaseResultMap")
    Project selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    @Update({
        "update project",
        "set name = #{name,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "logo = #{logo,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Project record);
    @Select({
            "select count(*)from api where group_id in (select id from api_group where pid=#{pid}) "
    })
    int getApiNum(Integer pid);

    @Select({
            "select count(*) from api_group where pid=#{pid} "
    })
    int getApiGroupNum(Integer pid);
}