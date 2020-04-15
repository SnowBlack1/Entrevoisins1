
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
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
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.contrib.ViewPagerActions.scrollRight;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasChildCount;
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

        //Empty fav list
        onView(withId(R.id.container)).perform(scrollRight());
        FavList.clear();
        onView(ViewMatchers.withId(R.id.fav_neighbour_layout)).check(withItemCount(0));

        //Add 5 Neighbours in the Favorite List and check the List's size
        for (int i = 0; i < 5; i++) {
            mApiService.addFav(mNeighbourList.get(i));
        }

        //The FavList have 5 Neighbours
        onView(ViewMatchers.withId(R.id.fav_neighbour_layout)).check(withItemCount(5));
    }


}
