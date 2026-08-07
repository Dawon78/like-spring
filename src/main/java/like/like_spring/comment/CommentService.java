package like.like_spring.comment;

import like.like_spring.post.Post;
import like.like_spring.post.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public Comment save(Long postId, String content, String writer){
        Post post = postRepository.findById(postId).orElseThrow();
        Comment comment = new Comment(content, writer, post);
        return commentRepository.save(comment);
    }

    public List<Comment> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

}
