package com.example.wehelie.homeworkv2;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction editTextName = onView(
                allOf(withId(R.id.editText), withText("Name"), isDisplayed()));
                editTextName.check(matches(isDisplayed()));

        ViewInteraction editTextEmail = onView(
                allOf(withId(R.id.email), withText("Email"), isDisplayed()));
                editTextEmail.check(matches(isDisplayed()));

        ViewInteraction editTextUsername = onView(
                allOf(withId(R.id.username), withText("Username"), isDisplayed()));
                editTextUsername.check(matches(isDisplayed()));

        ViewInteraction editTextAge = onView(
                allOf(withId(R.id.age), withText("Age"), isDisplayed()));
                editTextAge.check(matches(isDisplayed()));

        ViewInteraction textViewCalendar = onView(
                allOf(withId(R.id.seedate), withText("date of birth"), isDisplayed()));
                textViewCalendar.check(matches(isDisplayed()));

    }

}
