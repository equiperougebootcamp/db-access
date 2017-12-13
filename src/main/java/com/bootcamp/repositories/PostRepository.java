package com.bootcamp.repositories;

import com.bootcamp.entities.Post;

public class PostRepository extends BaseRepository<Post> {
    public PostRepository(String persistUnit, Class entityClass) {
        super(persistUnit, entityClass);
    }
}
