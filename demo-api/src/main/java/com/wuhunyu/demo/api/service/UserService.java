package com.wuhunyu.demo.api.service;

import com.wuhunyu.demo.api.domain.User;

import java.util.List;

/**
 * 用户信息处理
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-05 18:39
 */

public interface UserService {

    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    List<User> listUsers();

    /**
     * 根据用户id查询指定用户
     *
     * @param userId 用户id
     * @return 用户信息
     */
    User findUserByUserId(Long userId);

    /**
     * 新增一个用户
     *
     * @param user 用户信息
     * @return 用户
     */
    Long insertUser(User user);

    /**
     * 修改用户
     *
     * @param user 用户信息
     */
    void updateUser(User user);

    /**
     * 根据用户id删除用户
     *
     * @param userId 用户id
     */
    void deleteUserByUseId(Long userId);

}
