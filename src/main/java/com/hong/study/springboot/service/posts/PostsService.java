package com.hong.study.springboot.service.posts;

import com.hong.study.springboot.domain.posts.Posts;
import com.hong.study.springboot.domain.posts.PostsRepository;
import com.hong.study.springboot.web.dto.PostsListResponseDto;
import com.hong.study.springboot.web.dto.PostsResponseDto;
import com.hong.study.springboot.web.dto.PostsSaveRequestDto;
import com.hong.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) // 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 속도 개선
    public List<PostsListResponseDto> findAllDesc(){
        // postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 Dto로 변환 후 List로 반ghks
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));

        postsRepository.delete(posts);
    }


}
