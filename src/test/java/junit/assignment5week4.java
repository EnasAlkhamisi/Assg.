package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class assignment5week4 extends test.junit.Test {
    @Test
    public void FacebookCookieExample () throws InterruptedException {
        // Navigate to Facebook login page
        driver.get("https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2F");

        // Get all cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }

        // Add a new cookie
        Cookie newCookie = new Cookie("myCookie", "123456");
        driver.manage().addCookie(newCookie);

        // Delete a specific cookie by name
        driver.manage().deleteCookieNamed("myCookie");

        // Delete all cookies
        driver.manage().deleteAllCookies();


    }

    }
