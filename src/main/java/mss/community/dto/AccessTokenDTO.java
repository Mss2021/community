package mss.community.dto;

import lombok.Data;

/**
 *Created by MSS on 2021/3/26
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
