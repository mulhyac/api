package com.lip.api.core.dao;

import com.lip.api.core.model.ApiClass;
import com.lip.api.core.model.ApiClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ApiClassMapper {
    int countByExample(ApiClassExample example);

    int deleteByExample(ApiClassExample example);

    @Delete({
        "delete from api_class",
        "where cid = #{cid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer cid);

    @Insert({
        "insert into api_class (cid, pcid, ",
        "lcid, name)",
        "values (#{cid,jdbcType=INTEGER}, #{pcid,jdbcType=INTEGER}, ",
        "#{lcid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(ApiClass record);

    int insertSelective(ApiClass record);

    List<ApiClass> selectByExample(ApiClassExample example);

    @Select({
        "select",
        "cid, pcid, lcid, name",
        "from api_class",
        "where cid = #{cid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lip.api.core.dao.ApiClassMapper.BaseResultMap")
    ApiClass selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") ApiClass record, @Param("example") ApiClassExample example);

    int updateByExample(@Param("record") ApiClass record, @Param("example") ApiClassExample example);

    int updateByPrimaryKeySelective(ApiClass record);

    @Update({
        "update api_class",
        "set pcid = #{pcid,jdbcType=INTEGER},",
          "lcid = #{lcid,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR}",
        "where cid = #{cid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ApiClass record);
}