package edu.miu.annapurnabe.service.impl;

import edu.miu.annapurnabe.dto.request.DailyMealRatingRequestDTO;
import edu.miu.annapurnabe.dto.response.DailyMealRatingResponseDTO;
import edu.miu.annapurnabe.dto.response.DailyMealResponseDTO;
import edu.miu.annapurnabe.dto.response.UserResponseDTO;
import edu.miu.annapurnabe.exception.DataNotFoundException;
import edu.miu.annapurnabe.model.DailyMeal;
import edu.miu.annapurnabe.model.DailyMealRating;
import edu.miu.annapurnabe.model.Rating;
import edu.miu.annapurnabe.model.User;
import edu.miu.annapurnabe.repository.DailyMealRatingRepository;
import edu.miu.annapurnabe.repository.DailyMealRepository;
import edu.miu.annapurnabe.repository.UserRepository;
import edu.miu.annapurnabe.service.DailyMealRatingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static edu.miu.annapurnabe.constant.ExceptionMessageConstant.*;
import static edu.miu.annapurnabe.model.DailyMealRating.DAILY_MEAL_RATING_SUCCESS_MESSAGE;

/**
 * @author bijayshrestha on 7/11/22
 * @project annapurna-be
 */
@Service
@Transactional
public class DailyMealRatingServiceImpl implements DailyMealRatingService {
    private final DailyMealRepository dailyMealRepository;
    private final UserRepository userRepository;
    private final DailyMealRatingRepository dailyMealRatingRepository;
    private final ModelMapper modelMapper;

    public DailyMealRatingServiceImpl(DailyMealRepository dailyMealRepository,
                                      UserRepository userRepository,
                                      DailyMealRatingRepository dailyMealRatingRepository, ModelMapper modelMapper) {
        this.dailyMealRepository = dailyMealRepository;
        this.userRepository = userRepository;
        this.dailyMealRatingRepository = dailyMealRatingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DailyMealRatingResponseDTO addDailyMealRating(DailyMealRatingRequestDTO dailyMealRatingRequestDTO)
            throws DataNotFoundException {
        User user = userRepository.findById(dailyMealRatingRequestDTO.getUserId()).orElseThrow(
                ()-> new DataNotFoundException(USER_NOT_FOUND, USER_NOT_FOUND_DEVELOPER_MESSAGE));
        DailyMeal dailyMeal = dailyMealRepository.findById(dailyMealRatingRequestDTO.getDailyMealId()).orElseThrow(
                ()->new DataNotFoundException(DAILY_MEAL_NOT_FOUND, DAILY_MEAL_NOT_FOUND_DEVELOPER_MESSAGE));

        saveDailyMealRating(dailyMealRatingRequestDTO, user, dailyMeal);
        return prepareDailyMealRatingResponse(dailyMealRatingRequestDTO, user);
    }

    private DailyMealRatingResponseDTO prepareDailyMealRatingResponse(DailyMealRatingRequestDTO dailyMealRatingRequestDTO,
                                                                      User user) {
        String message = user.getFullName() + DAILY_MEAL_RATING_SUCCESS_MESSAGE;
        DailyMealRatingResponseDTO dailyMealRatingResponseDTO = modelMapper.map(
                dailyMealRatingRequestDTO, DailyMealRatingResponseDTO.class);
        dailyMealRatingResponseDTO.setMessage(message);
        return dailyMealRatingResponseDTO;
    }

    private void saveDailyMealRating(DailyMealRatingRequestDTO dailyMealRatingRequestDTO,
                                     User user, DailyMeal dailyMeal) {
        DailyMealRating dailyMealRating = new DailyMealRating(dailyMeal, new Date(), List.of(user),
                Rating.getByName(dailyMealRatingRequestDTO.getRating()));
        dailyMealRatingRepository.save(dailyMealRating);
    }
}
