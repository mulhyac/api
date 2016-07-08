package com.lip.api.core.dao;

import com.lip.api.core.model.ApiMethod;
import com.lip.api.core.model.ApiMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ApiMethodMapper {
    int countByExample(ApiMethodExample example);

    int deleteByExample(ApiMethodExample example);

    @Delete({
        "delete from api_method",
        "where mid = #{mid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer mid);

    @Insert({
        "insert into api_method (mid, type)",
        "values (#{mid,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR})"
    })
    int insert(ApiMethod record);

    int insertSelective(ApiMethod record);

    List<ApiMethod> selectByExample(ApiMethodExample example);

    @Select({
        "select",
        "mid, type",
        "from api_method",
        "where mid = #{mid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lip.api.core.dao.ApiMethodMapper.BaseResultMap")
    ApiMethod selectByPrimaryKey(Integer mid);

    int updateByExampleSelective(@Param("record") ApiMethod record, @Param("example") ApiMethodExample example);

    int updateByExample(@Param("record") ApiMethod record, @Param("example") ApiMethodExample example);

    int updateByPrimaryKeySelective(ApiMethod record);

    @Update({
        "update api_method",
        "set type = #{type,jdbcType=VARCHAR}",
        "where mid = #{mid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ApiMethod record);
}