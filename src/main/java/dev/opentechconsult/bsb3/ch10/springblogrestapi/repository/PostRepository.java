package dev.opentechconsult.bsb3.ch10.springblogrestapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.opentechconsult.bsb3.ch10.springblogrestapi.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    boolean existsByTitle(String title);
    Optional<Post> findBySlug(String slug);

}
