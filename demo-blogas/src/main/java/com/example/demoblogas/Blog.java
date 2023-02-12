package com.example.demoblogas;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Blog {

    @NonNull
    private final int id;
    @NonNull
    private final String title;
    @NonNull
    private final String image;
    @NonNull
    private final String content;

}
