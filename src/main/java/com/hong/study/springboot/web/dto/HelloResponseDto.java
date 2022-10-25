package com.hong.study.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 생성된 모든 필드의 get 메소드를 생성해줍니다.
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
