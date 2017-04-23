package evolution.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import evolution.mybatis.entity.AnyEntity;
import evolution.mybatis.sql.AnySql;

@Mapper// Scanned by @MapperScan in DaoConfiguration.
public interface AnyMapper {
	@Select("SELECT * FROM any_table WHERE NAME = #{name}")
	public List<AnyEntity> selectByName(@Param("name") String name);
	
	@SelectProvider(type = AnySql.class, method = "selectById")
	public AnyEntity selectById(@Param("id") Integer id);
}
