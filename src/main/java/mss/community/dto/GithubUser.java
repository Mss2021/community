package mss.community.dto;

import lombok.Data;

/**
 *Created by MSS on 2021/3/26
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl; //驼峰命名也可以，fastJson做了增强，自动将下划线转成驼峰命名
}
