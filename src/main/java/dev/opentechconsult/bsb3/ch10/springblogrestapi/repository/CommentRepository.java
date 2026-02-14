package dev.opentechconsult.bsb3.ch10.springblogrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.opentechconsult.bsb3.ch10.springblogrestapi.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
