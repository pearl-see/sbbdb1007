package com.mysite.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/messages")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/{id}")
	@ResponseBody
	public Message getMessage(@PathVariable("id") Integer id) {
		// Integer id = 1;
		return messageService.getMessage(id);
	}
	
	@GetMapping("/create")
	public String create() {
		return "create-message";
	}

	@PostMapping
	@ResponseBody
	public void createMessage(@RequestBody Message message) {
		messageService.createMessage(message);
	}
	
	@GetMapping
	public String getMessages(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			Model model) {
		PageDTO pageData = messageService.getPagedData(page, size);
		model.addAttribute("pageData", pageData);
		return "messages";
	}
	
	@GetMapping("/api")
	@ResponseBody
	public List<Message> getMessagesLimit10() {
		return messageService.getMessagesLimit10();
	}
}
