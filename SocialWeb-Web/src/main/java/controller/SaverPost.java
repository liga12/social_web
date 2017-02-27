package controller;

import java.util.List;
import model.entity.Post;
import model.entity.User;
import service.UserServiceImpl;

public class SaverPost {

  public void savePost(User user){
    UserServiceImpl userService = new UserServiceImpl();
    Post post = new Post();
    List<Post> posts = null;
    user.getPosts().add(post);
    post.setUser(user);
    userService.save(user);
  }

}
