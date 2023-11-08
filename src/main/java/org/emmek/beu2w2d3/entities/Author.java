package org.emmek.beu2w2d3.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    List<BlogPost> blogPosts;
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String email;
    @JsonFormat(pattern = "dd-MM-YYYY")
    private LocalDate birthDate;
    private String avatar;
}
