package cn.test.ctrl;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import cn.test.service.EmpService;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 控制层
 * @author yuezhihua
 *
 */
@Controller
//@RequestMapping("/emp")
public class EmpCtrl {
	
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfig;
	
	@Resource
	private EmpService service;
	
	/**
	 * 测试aop方法生成新的模板文件
	 */
	@RequestMapping(value="/aop")
	public void testAop()throws Exception{
		service.add();
	}
	
	/**
	 * maven-jetty测试
	 */
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public void test(){
		System.out.println("这个是测试");
	}

	/**
	 * 测试生成模板
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String getInfo(Model model)throws Exception{
		Configuration cfg = freeMarkerConfig.getConfiguration();
		cfg.setDefaultEncoding("utf-8");
		cfg.setClassForTemplateLoading(EmpCtrl.class, "/");
		Template template = cfg.getTemplate("hello.ftl");
		Map root = new HashMap();
		root.put("username", "zhangsan");
		template.process(root, new PrintWriter(System.out));
		model.addAttribute("username", "laoklui");
		return "hello";
	}
	
	
	/**
	 * 
	 * http://localhost:8787/kk/one
	 * 
	 * 测试生成模板
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/one")
	public String hello(Model model)throws Exception{
		model.addAttribute("username", "wangwu");
		//
		//
		//这个是用来测试freemarker和aop整合的
		//
		//
		System.out.println("================这个是用来测试freemarker和aop整合的");
		service.add();
		return "hello";
	}
	
}
