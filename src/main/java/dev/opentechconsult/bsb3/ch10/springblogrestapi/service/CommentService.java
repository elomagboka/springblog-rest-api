package dev.opentechconsult.bsb3.ch10.springblogrestapi.service;

import dev.opentechconsult.bsb3.ch10.springblogrestapi.domain.Comment;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.domain.Post;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.dto.CommentDto;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.exception.SpringBlogException;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.mapper.CommentMapper;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.repository.CommentRepository;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public List<CommentDto> findByPost(String slug) {
        Post post = getPostBySlug(slug);
        return post.getComments()
                .stream()
                .map(commentMapper::mapToCommentDto)
                .toList();
    }

    public void create(CommentDto commentDto, String slug) {
        Comment comment = commentMapper.mapToComment(commentDto);
        comment.setCreatedOn(LocalDateTime.now());
        comment.setUpdatedOn(LocalDateTime.now());
        Post postBySlug = getPostBySlug(slug);
        comment.setPost(postBySlug);
        commentRepository.save(comment);
        postBySlug.getComments().add(comment);
        postRepository.save(postBySlug);
    }

    private Post getPostBySlug(String slug) {
        return postRepository.findBySlug(slug)
                .orElseThrow(() -> new SpringBlogException("Cannot find post by slug - " + slug));
    }
}
