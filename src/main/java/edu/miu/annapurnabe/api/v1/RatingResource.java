package edu.miu.annapurnabe.api.v1;

import edu.miu.annapurnabe.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.API_V1_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.RatingResourceConstant.RATING_BASE;

/**
 * @author bijayshrestha on 7/6/22
 * @project annapurna-be
 */
@RestController
@RequestMapping(API_V1_BASE + RATING_BASE)
public class RatingResource {

    private final RatingService ratingService;

    public RatingResource(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public ResponseEntity<List<String>> testRating(){
        return ResponseEntity.ok(ratingService.getRatings());

    }

    @PostMapping
    public String testPostRating(){
        return "I am POST acccessible!";
    }
}
