package com.in28minutes.rest.webservices.restfulwebservices.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import com.in28minutes.rest.webservices.restfulwebservices.user.UserDaoService;

public class PostDaoService {

	private Integer countPost=0;
	
	
@Autowired
public UserDaoService service;

private static List<Post> posts= new ArrayList<>();

	static {
	//posts.add(1,"Eduardo", new Date(),"Postagem 1 do Eduardo");
	}
	
	public List<Post> listAllPosts(){
		return posts;
	}
	
	
	public List<Post> listPostUser(Integer id) {
		List<Post> listPost = new ArrayList<>();
		
		for(Post post:posts) {
			if(post.getId()==id) {
				listPost.add(post);
			}
		}
		
		return listPost;
	}
	
	public void savePostUser(Integer idUser, String mensagem) {
		User user = service.findUser(idUser) ;
//		posts.add(countPost++, user, mensagem);
		
	}

}
