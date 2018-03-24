package com.robinliew.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robinliew.data.ContactRepository;
import com.robinliew.domain.Contact;


/**
 * 自动配置的说明：以下两种方式都会触发自动装配
 * 1.Spring Boot Starter会触发自动配置。
 * 例如，在Spring Boot应用中，如果我们想要使用Spring MVC的话，所需要做的仅仅是将Web Starter作为依赖放入构建中，它会自动添加Spring MVC依赖。
 * 如果Spring Boot 的Web自动配置探测到Spring MVC位于类路径下，它会自动配置支持Spring MVC的多个bean，包括视图解析器、资源处理器以及消息转换器（等等）。
 * 
 * 2.我们用Thymeleaf代替JSP，依靠Spring Boot自动配置，我们只需要将Thymeleaf添加到项目的类路径中。如果Spring Boot探测到Thymeleaf位于类路径中，
 * 它就会推断我们需要使用Thymeleaf实现Spring MVC的视图功能，并自动配置这些bean。
 * 
 * @author RobinLiew
 *
 */
@Controller
public class ContactsController {
	
//	private ContactRepository contactRepo;
//	
//	@Autowired
//	public ContactsController(ContactRepository contactRepo) {
//		super();
//		this.contactRepo = contactRepo;
//	}

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(Map<String,Object> model){
//		List<Contact> contacts=contactRepo.findAll();
//		model.put("contacts", contacts);
		return "home";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public String submit(Contact contact){
//		contactRepo.save(contact);
		return "redirect:/";
	}
}
