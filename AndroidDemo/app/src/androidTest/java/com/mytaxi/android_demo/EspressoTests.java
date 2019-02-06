package com.mytaxi.android_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;

import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class EspressoTests {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureCredentialEntry() {
        onView(withId(R.id.edt_username))
                .perform(typeText("crazydog335"), closeSoftKeyboard());

        onView(withId(R.id.edt_password))
                .perform(typeText("venture"), closeSoftKeyboard());

        onView(withId(R.id.btn_login))
                .perform(click());

        SleepWait(3);

        onView(withId(R.id.textSearch))
                .perform(typeText("Sa"), closeSoftKeyboard());

        onData(anything())
                .inRoot(isPlatformPopup())
                .atPosition(1)
                .perform(click());

        SleepWait(3);

        onView(withId(R.id.fab))
                .perform(click());
    }

    public static void SleepWait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
