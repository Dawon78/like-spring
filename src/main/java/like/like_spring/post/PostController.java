package like.like_spring.post;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/api/posts")
    public Post create(@RequestBody Post post) {
        return postService.save(post);

    }

    @GetMapping("/api/posts")
    public List<Post> findAll() {
        return  postService.findAll();
    }

    @GetMapping("/api/posts/{id}")
    public Post findById(@PathVariable Long id){
        return  postService.findById(id);
    }

    @DeleteMapping("/api/posts/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }

    @PutMapping("/api/posts/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post updatedPost) {
        return postService.update(id, updatedPost);
    }

}
