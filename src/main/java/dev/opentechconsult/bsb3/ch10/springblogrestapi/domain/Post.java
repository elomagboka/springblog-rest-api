package dev.opentechconsult.bsb3.ch10.springblogrestapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String body;
    private String slug;
    @Enumerated(EnumType.STRING)
    @Column(name = "post_status")
    private PostStatus postStatus;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
    @OneToMany(mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Comment> comments;
}
