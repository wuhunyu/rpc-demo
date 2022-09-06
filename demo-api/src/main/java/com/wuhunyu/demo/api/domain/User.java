package com.wuhunyu.demo.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户实体
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-05 18:32
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 性别(0: 男; 1: 女)
     */
    private Byte gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 出生日期
     */
    private LocalDateTime birth;

}
