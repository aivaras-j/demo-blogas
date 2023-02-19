package com.example.demoblogas;


import jakarta.persistence.*;
import lombok.*;


@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    @Column
    @NonNull
    @Getter
    private String title;

    @Column
    @NonNull
    @Getter
    private String type;

    @Override
    public String toString() {
        return String.format("Blog: id=%s, title=%s, type=%s", id, title, type);
    }
}
