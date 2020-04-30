
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private static int POSITION = 0;

    private ListNeighbourActivity mActivity;
    private List<Neighbour> mNeighbourList = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
    private NeighbourApiService mApiService = DI.getNeighbourApiService();
    private List<Neighbour> FavList = mApiService.getFav();

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(withId(R.id.list_neighbours))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(withId(R.id.list_neighbours))
                .perform(actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT - 1));
    }

    /**
     * When we click on a neighbour, display Specific Neighbour detail screen
     */
    @Test
    public void onClickSpecificNeighbour_DetailScreenDisplayed() {
        //Click on the item
        onView(withId(R.id.list_neighbours)).
                perform(actionOnItemAtPosition(0, click()));
        //Go to the Specific Neighbour Activity
        onView(withId(R.id.specificneighbour_layout)).check(matches(isDisplayed()));
    }

    /**
     * When we click on a neighbour, display the right name
     */
    @Test
    public void checkIfSpecificNeighbourNameIsDisplayed() {
        //A Neighbour for the test
        Neighbour neighbour = mNeighbourList.get(POSITION);
        //Click on this neighbour
        onView(withId(R.id.list_neighbours)).
                perform(actionOnItemAtPosition(POSITION, click()));
        //Have the good name on SpecificNeighbour fragment
        onView(withId(R.id.nameavatar_txt)).check(matches(withText(neighbour.getName())));
    }

    /**
     * The FavList's size == number of Favorites Neighbours
     */
    @Test
    public void checkIfFavTabIsDisplayingFavList() {
        onView(withId(R.id.list_neighbours))
               .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        //Click on Fav btn to add neighbour to favorites
        onView((withId(R.id.fav_btn)))
               .perform(click());

        // Go back on neighbour list view and to favorites list view
        pressBack();

        //Swipe left on the View Pager to access to Favorites tab
       onView(withId(R.id.main_content)).perform(swipeLeft());

        // Neighbour should appear in the list of favorites neighbours
        onView(withId(R.id.fav_list_neighbour_layout))
                .check(withItemCount(1));



}}
