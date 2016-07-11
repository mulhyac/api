package com.lip.api.core.dao;

import com.lip.api.core.model.Api;
import com.lip.api.core.model.ApiExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ApiMapper {
    int countByExample(ApiExample example);

    int deleteByExample(ApiExample example);

    @Delete({
        "delete from api",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Delete({
            "delete from api ",
            "where group_id in (select id from api_group where pid=#{pid,jdbcType=INTEGER})"
    })
    int deleteByProjectId(Integer pid);

    @Insert({
        "insert into api (id, group_id, ",
        "name, brief, url, ",
        "method, output, ",
        "parameter, remark, ",
        "update_time, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{groupId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{brief,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{method,jdbcType=VARCHAR}, #{output,jdbcType=VARCHAR}, ",
        "#{parameter,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Api record);

    int insertSelective(Api record);
    @Select({
            "select last_insert_id()"
    })
    int getInsertId();

    List<Api> selectByExample(ApiExample example);

    @Select({
        "select",
        "id, group_id, name, brief, url, method, output, parameter, remark, update_time, ",
        "create_time",
        "from api",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.lip.api.core.dao.ApiMapper.BaseResultMap")
    Api selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, group_id, name, brief, url, method, output, parameter, remark, update_time, ",
            "create_time",
            "from api",
            "where (name like #{key} or brief like #{key} or url like #{key} " +
                    "or output like #{key} or parameter like #{key} " +
                    "or remark like #{key}) and group_id=#{id}"
    })
    @ResultMap("com.lip.api.core.dao.ApiMapper.BaseResultMap")
    List<Api> selectByKeyWord(@Param("id")Integer id,@Param("key")String key);

    int updateByExampleSelective(@Param("record") Api record, @Param("example") ApiExample example);

    int updateByExample(@Param("record") Api record, @Param("example") ApiExample example);

    int updateByPrimaryKeySelective(Api record);

    @Update({
        "update api",
        "set group_id = #{groupId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "brief = #{brief,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "method = #{method,jdbcType=VARCHAR},",
          "output = #{output,jdbcType=VARCHAR},",
          "parameter = #{parameter,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Api record);
}