package like.like_spring.post;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post save(Post post){
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById (Long id){
        return postRepository.findById(id).orElseThrow();
    }

    public void delete(Long id){
        postRepository.deleteById(id);
    }

    public  Post update(Long id, Post updatedPost){
        Post post = postRepository.findById(id).orElseThrow();
        post.update(updatedPost.getTitle(), updatedPost.getContent());  // ← 이 줄 추가!
        return postRepository.save(post);
    }
}
