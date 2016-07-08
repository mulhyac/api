package com.lip.api.core.dao;

import com.lip.api.core.model.ApiParameter;
import com.lip.api.core.model.ApiParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ApiParameterMapper {
    int countByExample(ApiParameterExample example);

    int deleteByExample(ApiParameterExample example);

    @Delete({
        "delete from api_parameter",
        "where pid = #{pid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer pid);

    @Insert({
        "insert into api_parameter (pid, aid, ",
        "name, type, description)",
        "values (#{pid,jdbcType=INTEGER}, #{aid,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})"
    })
    int insert(ApiParameter record);

    int insertSelective(ApiParameter record);

    List<ApiParameter> selectByExample(ApiParameterExample example);

    @Select({
        "select",
        "pid, aid, name, type, description",
        "from api_parameter",
        "where pid = #{pid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lip.api.core.dao.ApiParameterMapper.BaseResultMap")
    ApiParameter selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") ApiParameter record, @Param("example") ApiParameterExample example);

    int updateByExample(@Param("record") ApiParameter record, @Param("example") ApiParameterExample example);

    int updateByPrimaryKeySelective(ApiParameter record);

    @Update({
        "update api_parameter",
        "set aid = #{aid,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR}",
        "where pid = #{pid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ApiParameter record);
}