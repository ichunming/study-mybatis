package com.ichunming.study.mybatis.pagehelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ichunming.study.mybatis.dal.domain.User;
import com.ichunming.study.mybatis.dal.domain.UserExample;
import com.ichunming.study.mybatis.dal.mapper.UserMapper;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private UserMapper userMapper;
	
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
    
    @Override
	public void run(String... arg0) throws Exception {
    	LOGGER.info("*******************");
		// For Test
    	LOGGER.info("for test...");
    	pageHelperTest();
    	LOGGER.info("*******************");
	}
    
    private void pageHelperTest() {
    	// build example
    	LOGGER.info("build example...");
    	UserExample example = new UserExample();
    	example.createCriteria().andStatusEqualTo(1);
    	
    	// use pageHelper, and count total size
    	LOGGER.info("use pageHelper...");
    	Page<User> page = PageHelper.startPage(1, 2, true);
    	userMapper.selectByExample(example);
    	
    	// check result
    	LOGGER.info("check result...");
    	LOGGER.info("total size:{}", page.getTotal());
    	LOGGER.info("result size:{}", page.getResult().size());
    }
}
