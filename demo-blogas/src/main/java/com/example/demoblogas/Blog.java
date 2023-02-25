package com.example.demoblogas.blog;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @Column
    @NonNull
    @NotEmpty(message = "Blog title cannot be empty")
    private String title;

    @Column(columnDefinition = "blob")
    @NonNull
    @Size(
            min=50,
            message = "Text lenght is too short"
    )
    private String text;

    @Column
    @NonNull

    @NotEmpty(message = "Blog imageUrl cannot be empty")
    private String imageUrl;


    @Override
    public String toString() {
        return String.format("Blog: id=%s, title=%s, text=%s, imageUrl=%s", id, title, text, imageUrl);
    }
}
