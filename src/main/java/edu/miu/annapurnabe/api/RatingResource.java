package edu.miu.annapurnabe.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.API_V1_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.RatingResourceConstant.RATING_BASE;

/**
 * @author bijayshrestha on 7/6/22
 * @project annapurna-be
 */
@RestController
@RequestMapping(API_V1_BASE + RATING_BASE)
public class RatingResource {

    @GetMapping
    public String testRating(){
        return "I am GET acccessible!";
    }

    @PostMapping
    public String testPostRating(){
        return "I am POST acccessible!";
    }
}
