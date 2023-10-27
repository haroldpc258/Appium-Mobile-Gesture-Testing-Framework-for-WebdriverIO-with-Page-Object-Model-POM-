package com.globant.tests;

import com.globant.screens.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WDIO_Tests extends BaseMobileTest {

    @Test
    public void testMenuBarNavigation() {
        HomeScreen homeScreen = loadFirstScreen();
        Assert.assertTrue(homeScreen.IsScreenAvailable());
        WebviewScreen webviewScreen = homeScreen.pressWebviewBtn();
        Assert.assertTrue(webviewScreen.IsScreenAvailable());
        LoginScreen loginScreen = webviewScreen.pressLoginBtn();
        Assert.assertTrue(loginScreen.IsScreenAvailable());
        FormsScreen formsScreen = loginScreen.pressFormsBtn();
        Assert.assertTrue(formsScreen.IsScreenAvailable());
        SwipeScreen swipeScreen = formsScreen.pressSwipeBtn();
        Assert.assertTrue(swipeScreen.IsScreenAvailable());
        DragScreen dragScreen = swipeScreen.pressDragBtn();
        Assert.assertTrue(dragScreen.IsScreenAvailable());
        homeScreen = dragScreen.pressHomeBtn();
        Assert.assertTrue(homeScreen.IsScreenAvailable());
    }

    @Test
    public void testSignUp() {
        HomeScreen homeScreen = loadFirstScreen();
        LoginScreen loginScreen = homeScreen.pressLoginBtn();
        loginScreen.signUp();
        Assert.assertEquals(loginScreen.getAlertText(),"Signed Up!\n" +
                "You successfully signed up!");
    }

    @Test
    public void testLogin() {
        HomeScreen homeScreen = loadFirstScreen();
        LoginScreen loginScreen = homeScreen.pressLoginBtn();
        loginScreen.signIn();
        Assert.assertEquals(loginScreen.getAlertText(), "Success\n" +
                "You are logged in!");
    }

    @Test
    public void testSwipeLeft() {
        HomeScreen home = loadFirstScreen();
        SwipeScreen swipeScreen = home.pressSwipeBtn();
        swipeScreen.leftSwipe();
        Assert.assertTrue(swipeScreen.leftSwipeGesturedWasPerformed());
    }

    @Test
    public void testSwipeUp() {
        HomeScreen home = loadFirstScreen();
        SwipeScreen swipeScreen = home.pressSwipeBtn();
        swipeScreen.upSwipe();
        Assert.assertTrue(swipeScreen.upSwipeGesturedWasPerformed());
    }

    @Test
    public void testDrag() {
        HomeScreen home = loadFirstScreen();
        DragScreen dragScreen = home.pressDragBtn();
        dragScreen.solvePuzzle();
        Assert.assertEquals(dragScreen.getCongratulationsText(), "Congratulations");
    }

    @Test
    public void testScroll() {
        HomeScreen home = loadFirstScreen();
        WebviewScreen webviewScreen = home.pressWebviewBtn();
        webviewScreen.downScroll();
    }
}
