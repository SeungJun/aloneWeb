package com.hong.study.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Db Layer 접근자
// Entity 클래스, PK 타입
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
