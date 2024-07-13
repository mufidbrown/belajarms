package com.mufid.reviewms.review;

import java.util.List;

public interface ReviewService {

//    List<Review> findAll();
//    void createReview(Review review);
//Review getReviewById(Long id);


    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review getReview(Long reviewId);

    boolean updateReview(Long reviewId, Review review);

    boolean deleteReview(Long reviewId);


}
