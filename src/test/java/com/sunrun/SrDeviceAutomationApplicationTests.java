package com.sunrun;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunrun.mapper.CommondMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SrDeviceAutomationApplicationTests {

	@Resource
	private CommondMapper commondMapper;

	@Test
	public void contextLoads() {
		String table = "scores";
		String field = "name, sex, subject, score, createTime";
		String value = "'judy', '女', '语文', 80, now()";
		//commondMapper.insert(table, field, value);
		 
		field = "score=80, name='judy'";
		String condition = "name = 'judy'";
		commondMapper.update(table, field, condition);
		
		field = "score,name,subject";
		PageHelper.startPage(1, 10);
		List<Map<String, Object>> map = commondMapper.select(table, field, null);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(map);
		System.out.println("第几页："+page.getPageNum());  
        System.out.println("页面大小："+page.getPageSize());  
        System.out.println("索引下表开始："+page.getStartRow());  
        System.out.println("索引小标结束："+page.getEndRow());  
        System.out.println("总数："+page.getTotal());  
        System.out.println("总页数："+page.getPages());  
        System.out.println("第一页："+page.getFirstPage());  
        System.out.println("最后一页："+page.getLastPage());  
        System.out.println("是否有前一页："+page.isHasPreviousPage());  
        System.out.println("是否有后一页："+page.isHasNextPage());  
		System.out.println("map:"+map.toString());
		System.out.println("page.getList()="+page.getList().toString());
		int count = page.getList().size();
		System.out.println(count); 
		//commondMapper.delete(table, condition);
	}
	
	public static void main(String[] args) {

	}

	
}
