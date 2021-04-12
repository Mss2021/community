package mss.community.model;

import lombok.Data;

/**
 * Created by MSS on 2021/3/30
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
