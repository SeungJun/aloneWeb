package com.hong.study.springboot.service.posts;

import com.hong.study.springboot.domain.posts.Posts;
import com.hong.study.springboot.domain.posts.PostsRepository;
import com.hong.study.springboot.web.dto.PostsResponseDto;
import com.hong.study.springboot.web.dto.PostsSaveRequestDto;
import com.hong.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// final이 선언된 모든 필드를 인자값으로하는 생성자를 대신 생성해줌
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 . id =" +id));
        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id ="+id));

        return new PostsResponseDto(entity);
    }
}