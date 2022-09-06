package com.wuhunyu.demo.client.service;

import com.wuhunyu.demo.api.domain.User;
import com.wuhunyu.demo.api.service.UserService;
import com.wuhunyu.rpc.client.utils.InvokeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-06 14:40
 */

@Slf4j(topic = "rpc客户端测试")
class UserServiceImplTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = InvokeUtil.findProxyObj(UserService.class);
    }

    @Test
    void listUsers() {
        List<User> users = userService.listUsers();
        log.info("listUsers: {}", users);
    }

    @Test
    void findUserByUserId() {
        User user = userService.findUserByUserId(1L);
        log.info("findUserByUserId: {}", user);
    }

    @Test
    void insertUser() {
        User user = new User(
                null,
                "田七",
                (byte) 0,
                27,
                LocalDateTime.now());
        Long userId = userService.insertUser(user);
        log.info("insertUser: {}", userId);
    }

    @Test
    void updateUser() {
        User user = new User(
                3L,
                "王五",
                (byte) 0,
                27,
                LocalDateTime.now());
        userService.updateUser(user);
    }

    @Test
    void deleteUserByUseId() {
        userService.deleteUserByUseId(2L);
    }
}