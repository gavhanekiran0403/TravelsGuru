package com.travelsguru.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReviewDto {

    private String reviewId;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;

    private String userId;
    private String travelPackageId;
}
