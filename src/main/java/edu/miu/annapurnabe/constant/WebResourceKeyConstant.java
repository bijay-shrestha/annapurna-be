package edu.miu.annapurnabe.constant;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
public class WebResourceKeyConstant {

    public static final String API_V1_BASE = "/api/v1";
    public static final String TEST = "/test";

    public interface UserResourceConstant {
        String USER_BASE = "/users";
        String USER_ID = "/{userId}";
    }

    public interface MealResourceConstant{
        String MEAL_BASE="/meals";
        String MEAL_ID="/{mealId}";
    }

    public interface RatingResourceConstant{
        String RATING_BASE="/ratings";
        String RATING_ID="/{ratingId}";
    }

    public interface LoginResourceConstant{
        String REFRESH_TOKEN="/token/refresh";
    }

    public interface DailyMealResourceConstant{
        String DAILY_MEALS="/daily-meals";
    }
    public interface DailyMealRatingResourceConstant{
        String DAILY_MEALS_RATING="/daily-meals/rating";
    }

}
