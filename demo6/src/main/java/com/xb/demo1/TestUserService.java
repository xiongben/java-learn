package com.xb.demo1;

import org.junit.Test;

public class TestUserService {
    @Test
    public void TestSelectNames() {
        UserService userService = new UserService();
        userService.selectNames();

    }
}
