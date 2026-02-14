package dev.opentechconsult.bsb3.ch10.springblogrestapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.opentechconsult.bsb3.ch10.springblogrestapi.domain.Post;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.dto.PostDto;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.exception.SpringBlogException;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.mapper.PostMapper;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostDto save(PostDto postDto) {
        Post post = postMapper.mapToPost(postDto);
        post.setCreatedOn(LocalDateTime.now());
        post.setUpdatedOn(LocalDateTime.now());
        Post savedPost = postRepository.save(post);
        postDto.setId(savedPost.getId());
        return postDto;
    }

    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(postMapper::mapToPostDto)
                .toList();
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.existsByTitle(title);
    }

    public PostDto update(PostDto postDto) {
        Post savedPost = postRepository.findById(postDto.getId())
                .orElseThrow(() -> new SpringBlogException("Cannot find Post with Id: " + postDto.getId()));
        Post post = postMapper.mapToPost(postDto);
        post.setId(savedPost.getId());
        post.setUpdatedOn(LocalDateTime.now());
        postRepository.save(post);
        return postDto;
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public PostDto findBySlud(String slug) {
        Post post = postRepository.findBySlug(slug)
                .orElseThrow(() -> new SpringBlogException("Cannot find Post with Slug: " + slug));
        return postMapper.mapToPostDto(post);
    }
}
