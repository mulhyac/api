package com.lip.api.core.dao;

import com.lip.api.core.model.ApiGroup;
import com.lip.api.core.model.ApiGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ApiGroupMapper {
    int countByExample(ApiGroupExample example);

    int deleteByExample(ApiGroupExample example);

    @Delete({
        "delete from api_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into api_group (id, name, ",
        "title)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR})"
    })
    int insert(ApiGroup record);

    int insertSelective(ApiGroup record);

    List<ApiGroup> selectByExample(ApiGroupExample example);

    @Select({
        "select",
        "id, name, title",
        "from api_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.lip.api.core.dao.ApiGroupMapper.BaseResultMap")
    ApiGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApiGroup record, @Param("example") ApiGroupExample example);

    int updateByExample(@Param("record") ApiGroup record, @Param("example") ApiGroupExample example);

    int updateByPrimaryKeySelective(ApiGroup record);

    @Update({
        "update api_group",
        "set name = #{name,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ApiGroup record);
}