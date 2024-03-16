package service;

import model.Post;

import java.util.List;

public interface PostService {
    Post addPostToUser(Post post);
    Post deletePostById( Long postId);
    List<Post> getAllPostByUserId(Long userId);
}
