package evolution.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import evolution.mybatis.entity.AnyEntity;
import evolution.mybatis.mapper.AnyMapper;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private AnyMapper anyMapper;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public static void main(String[] args)  {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		List<AnyEntity> anyEntities = anyMapper.selectByName("Chen");// The SQL statement is written within @Select. 
		System.out.println(anyEntities);
		Object anyEntity0 = sqlSessionTemplate.selectOne(AnyMapper.class.getName() + ".selectByName", "Chen");// Call selectByName() manually in AnyMapper by SqlSessionTemplate. 
		System.out.println(anyEntity0);																																				
		AnyEntity anyEntity1 = anyMapper.selectById(1);
		System.out.println(anyEntity1);
	}
}
