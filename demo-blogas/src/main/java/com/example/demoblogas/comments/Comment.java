package com.example.demoblogas.comments;

import com.example.demoblogas.blog.Blog;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.*;

@Entity
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @Size(max = 500)
    private String content;

    @NonNull
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog blog;

    public Comment() {
    }

    public Comment(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
