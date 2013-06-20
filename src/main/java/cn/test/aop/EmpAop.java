package cn.test.aop;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;


/**
 * 用于测试更改主页内容后对主页重新生成静态文件
 * @author byht
 */
public class EmpAop {

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfig;
	
	public void init(){
		System.out.println("测试测试");
	}
	
	public void updateIndex()throws Exception{
		Configuration cfg = freeMarkerConfig.getConfiguration();
		cfg.setDefaultEncoding("utf-8");
		cfg.setClassForTemplateLoading(EmpAop.class, "/");
		Template template = cfg.getTemplate("hello.ftl");
		Map root = new HashMap();
		root.put("username", "zhangsan");
		System.out.println();System.out.println();
		System.out.println("===我要生成模板文件了，你准备好了没有");
		template.process(root, new PrintWriter(System.out));
		System.out.println();System.out.println();
		
	}
	
	
}
