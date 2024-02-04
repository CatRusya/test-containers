package org.example.testcontainers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1024)
    private String title;

    @Column(length = 1024)
    private String text;

    private long viewsAmount;

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
