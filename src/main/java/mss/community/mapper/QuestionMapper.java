package mss.community.mapper;

import mss.community.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by MSS on 2021/4/2
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator=#{userID} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userID") Integer userID, @Param(value = "offset") Integer offset,@Param(value = "size") Integer size);

    @Select("select count(1) from question where creator=#{userID}")
    Integer countByUserId(@Param("userID") Integer userID);

    @Select("select * from question where id=#{id} ")
    Question getById(@Param("id") Integer id);

    @Update("update question set title=#{title},description=#{description},gmt_modified=#{gmtModified},tag=#{tag} where id = #{id}")
    void update(Question question);
}
