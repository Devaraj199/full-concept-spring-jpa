package com.devamasterjpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@Table(name = "AUTHOR_TBL")
// Named query
//@NamedQuery(name = "Author.findByNamedQuery",
//query = "select a from Author a where a.age >= :age")
//
//@NamedQuery(name = "Author.updateByNamedQuery",
//        query = "update Author a set a.age = :age")

@NamedQueries({
        @NamedQuery(name = "Author.findByNamedQuery",
                query = "SELECT a FROM Author a WHERE a.age >= :age"),
        @NamedQuery(name = "Author.updateByNamedQuery",
                query = "UPDATE Author a SET a.age = :age")
})

public class Author extends BaseEntity {
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_sequence")
//    @SequenceGenerator(name = "author_sequence",sequenceName = "author_sequence",allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.TABLE,generator = "author_id_gen")
//    @TableGenerator(name = "author_id_gen",
//            table = "id_generator",
//            pkColumnName = "id_name",
//            valueColumnName = "id_value",
//            allocationSize = 1)
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;
//    @Column(updatable = false,nullable = false)
//    private LocalDateTime createdAt;
//    @Column(insertable = false)
//    private LocalDateTime lastModifiedAt;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}