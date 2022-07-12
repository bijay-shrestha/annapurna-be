package edu.miu.annapurnabe.service.impl;

import edu.miu.annapurnabe.model.Rating;
import edu.miu.annapurnabe.service.RatingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author bijayshrestha on 7/11/22
 * @project annapurna-be
 */
@Service
@Transactional
public class RatingServiceImpl implements RatingService {
    @Override
    public List<String> getRatings() {
        return Stream.of(Rating.values())
                .map(Rating::getValue)
                .collect(Collectors.toList());
    }
}
