package like.like_spring.comment;

import jakarta.persistence.*;
import like.like_spring.post.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String writer;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String content, String writer, Post post){
        this.content = content;
        this.writer = writer;
        this.post = post;
    }

}
