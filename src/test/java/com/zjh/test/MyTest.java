package com.zjh.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjh.mapper.MyMapper;
import com.zjh.pojo.Book;

import utils.IOUtils;
import utils.StringUtil;

public class MyTest {
	
	@Test
	public void test() {
		ClassPathXmlApplicationContext cax=new ClassPathXmlApplicationContext("applicationContext.xml");
		MyMapper bean = cax.getBean(MyMapper.class);
		List<Object[]> readFile = IOUtils.readFile("src/main/resources/file.txt", "\\\\t");
		Book book = new Book();
		for (Object[] objects : readFile) {
			//System.out.println(Arrays.toString(objects));
			if(!StringUtil.isEmpty(objects[1]+"")&&StringUtil.isNumber(objects[2]+"")
					&&StringUtil.isPhone(objects[3]+"")&&!StringUtil.isEmpty(objects[4]+"")) {
				book.setName(objects[1]+"");
				book.setSales(Integer.parseInt(objects[2]+""));
				book.setPhone(objects[3]+"");
				book.setType(objects[4]+"");
				System.out.println(book);
				int add = bean.add(book);
				System.out.println(add);
			}
		}
	}
}
