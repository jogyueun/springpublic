package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor // 생성자 롬복으로 추가
@NoArgsConstructor  // 기본 생성자 롬복으로 추가
@ToString           // @toString 메서드 롬복으로 기본 추가
@Entity             // 현재 클래스가 엔티티 라는 것을 명시
@Getter             // getter 메서드 롬복으로 추가
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;


    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }
}
