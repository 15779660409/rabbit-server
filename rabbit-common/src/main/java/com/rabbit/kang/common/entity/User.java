package com.rabbit.kang.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author kanghaijun
 * @create 2019/6/25
 * @describe
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable{

    private static final long serialVersionUID = -153276801871945015L;

    private Integer id;

    private String name;
}
