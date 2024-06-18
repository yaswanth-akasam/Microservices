
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Comments;
import com.example.service.CommentService;


@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	CommentService service;
	
	@Value("${server.port}")
	public String port;
	
	
	@GetMapping("/port")
	public String getPort() {
		return "Comment Service at Server Port :"+port;
	}
	
	@GetMapping("/all")
	public List<Comments> showAllPosts(){
		return service.showAllComments();
	}

	@PostMapping("/add")
	public Comments addPost(@RequestBody Comments comment) {
		return service.addComment(comment);
	}
	
	// http://localhost:8082/comments/postid/101
	@GetMapping("/postid/{pid}")
	public List<Comments> getCommentsByPid(@PathVariable int pid){
		return service.getAllCommentsByPid(pid);
	}
	
	@GetMapping("/commentid/{cid}")
	public List<Comments> getCommentsByCid(@PathVariable int cid){
		return service.getAllCommentsByPid(cid);
	}

}
