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

    @Insert({
        "insert into api (id, group_id, ",
        "name, brief, url, ",
        "method, output, ",
        "parameter, remark)",
        "values (#{id,jdbcType=INTEGER}, #{groupId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{brief,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{method,jdbcType=VARCHAR}, #{output,jdbcType=VARCHAR}, ",
        "#{parameter,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(Api record);

    int insertSelective(Api record);

    List<Api> selectByExample(ApiExample example);

    @Select({
        "select",
        "id, group_id, name, brief, url, method, output, parameter, remark",
        "from api",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.lip.api.core.dao.ApiMapper.BaseResultMap")
    Api selectByPrimaryKey(Integer id);

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
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Api record);
}