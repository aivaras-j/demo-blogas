package com.example.demoblogas;

import com.example.demoblogas.blog.Blog;
import com.example.demoblogas.comments.Comment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class BlogTest {

    @Test
    public void addCommentTest(){
        Comment comment = Mockito.mock(Comment.class);

        Blog blog = new Blog("Test Blog", "This is a test blog", "http://example.com");

        blog.addComment(comment);

        Set<Comment> comments = blog.getComment();
        assertNotNull(comments);
        assertEquals(1, comments.size());
        assertEquals(comment, comments.iterator().next());


    }
}
