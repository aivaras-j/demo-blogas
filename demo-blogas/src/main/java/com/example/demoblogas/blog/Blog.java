package com.example.demoblogas.blog;


import com.example.demoblogas.comments.Comment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.aspectj.bridge.IMessage;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NonNull
    @NotEmpty(message = "Blog title cannot be empty")
    private String title;

    @Column(columnDefinition = "blob")
    @NonNull
    @Size(
            min=5,
            message = "Text lenght is too short. Must be minimum 5 text simbols."
    )
    private String text;

    @Column(columnDefinition = "blob")
    @NonNull
    @NotEmpty(message = "Blog imageUrl cannot be empty")
    private String imageUrl;

    @OneToMany(mappedBy = "blog", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet();

    public Blog() {
    }


    public Blog(@NonNull String title, @NonNull String text, @NonNull String imageUrl) {
        this.title = title;
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setBlog(this);
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Set<Comment> getComment() {
        return comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", comments=" + comments +
                '}';
    }

    //    @Override
//    public String toString() {
//        return String.format("Blog: id=%s, title=%s, text=%s, imageUrl=%s", id, title, text, imageUrl);
//    }
}
