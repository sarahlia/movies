package com.moovy.movies.repository;

import com.moovy.movies.models.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarksRepository extends JpaRepository<Bookmark, Long> {

    Bookmark findByTitle(String title);
}
