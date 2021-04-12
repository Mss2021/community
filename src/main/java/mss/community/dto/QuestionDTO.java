package mss.community.dto;

import lombok.Data;
import mss.community.model.User;

/**
 *Created by MSS on 2021/4/5
 */
@Data
public class QuestionDTO {
        private Integer id;
        private String title;
        private String description;
        private String tag;
        private Long gmtCreate;
        private Long gmtModified;
        private Integer creator;
        private Integer viewCount;
        private Integer commentCount;
        private Integer likeCount;
        private User user;
}
