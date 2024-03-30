package com.example.demoimage.Entity;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Entity
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ImageData")
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;

    private String contentType;
   // private String userNames;

    private String email;
    private String password;
}
