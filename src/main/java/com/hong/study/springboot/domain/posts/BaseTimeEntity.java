package com.hong.study.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
// JPA entity 클래스들이 이 클래스를 상속할 경우 필드들도 칼럼으로 인식
@MappedSuperclass
// Auditing기능을 포함
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    // Entity 가 생성되어 저장될때 시간이 자동으로 생김
    @CreatedDate
    private LocalDateTime createdDate;

    // 조회한 Entity의 값을 변경할때 시간이 자동 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
