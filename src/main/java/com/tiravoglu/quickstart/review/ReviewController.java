package com.tiravoglu.quickstart.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{id}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long id){
        return new ResponseEntity<>(reviewService.getAllReviews(id), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long id, @RequestBody Review review){
        boolean created= reviewService.addReview(id,review);
        if(created)
            return new ResponseEntity<>("Review added successfully",HttpStatus.CREATED);
        return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long id, @PathVariable Long reviewId)
    {
        return new ResponseEntity<>(reviewService.getReview(id,reviewId),HttpStatus.OK);

    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long id,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review)
    {
        boolean isReviewUpdated= reviewService.updateReview(id,reviewId,review);
        if(isReviewUpdated)
        {
            return new ResponseEntity<>("Review updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not updated",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id,
                                               @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReview(id,reviewId);

        if(isReviewDeleted)
        {
            return new ResponseEntity<>("Review deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not deleted",HttpStatus.NOT_FOUND);

    }
}
