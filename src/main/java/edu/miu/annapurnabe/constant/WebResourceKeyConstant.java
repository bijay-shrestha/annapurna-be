package edu.miu.annapurnabe.constant;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
public class WebResourceKeyConstant {

    public static final String API_V1_BASE = "/api/v1";

    public interface UserResourceConstant {
        String USER_BASE = "/users";
        String USER_ID = "/{userId}";
    }

    public interface MealResourceConstant{
        String MEAL_BASE="/meals";
        String MEAL_ID="/{mealId}";
    }
}
