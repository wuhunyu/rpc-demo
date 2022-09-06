package com.wuhunyu.demo.server.service;

import com.wuhunyu.demo.api.domain.User;
import com.wuhunyu.demo.api.service.UserService;
import com.wuhunyu.rpc.common.sequence.SequenceUtil;
import com.wuhunyu.rpc.server.annotation.RpcServer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 用户信息实现类
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-05 18:46
 */

@RpcServer(UserService.class)
public class UserServiceImpl implements UserService {

    private static final List<User> USERS;

    static {
        USERS = new CopyOnWriteArrayList<>();
        // 填充模拟数据
        LocalDateTime now = LocalDateTime.now();
        USERS.add(new User(
                1L,
                "张三",
                (byte) 0,
                23,
                now));
        USERS.add(new User(
                2L,
                "李四",
                (byte) 0,
                24,
                now));
        USERS.add(new User(
                3L,
                "王麻子",
                (byte) 1,
                25,
                now));
    }

    @Override
    public List<User> listUsers() {
        return USERS;
    }

    @Override
    public User findUserByUserId(Long userId) {
        return USERS.stream()
                .filter(user -> Objects.equals(user.getUserId(), userId))
                .limit(1L)
                .reduce(null, (user1, user2) -> user1 == null ? user2 : user1);
    }

    @Override
    public Long insertUser(User user) {
        long userId = SequenceUtil.nextId();
        user.setUserId(userId);
        USERS.add(user);
        return userId;
    }

    @Override
    public void updateUser(User user) {
        this.deleteUserByUseId(user.getUserId());
        USERS.add(user);
    }

    @Override
    public void deleteUserByUseId(Long userId) {
        User sourceUser = this.findUserByUserId(userId);
        if (sourceUser != null) {
            USERS.remove(sourceUser);
        }
    }
}
