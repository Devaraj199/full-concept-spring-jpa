package com.devamasterjpa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@DiscriminatorValue("V")
//@PrimaryKeyJoinColumn(name = "video_id")
//@Polymorphism(type = PolymorphismType.EXPLICIT) exclude parent property
public class Video extends Resource{
    private Integer length;
}
