/** 
 * @className:DatasourceConfig
 * @date:     2017年11月20日 下午1:17:56
 * @author    ming
 */
package com.ichunming.study.mybatis.pagehelper.configuration;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
@MapperScan(basePackages = "com.ichunming.study.mybatis.dal.mapper.**", sqlSessionTemplateRef  = "sqlSessionTemplate")
public class DatasourceConfig {
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
