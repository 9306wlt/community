package ltwu9306.community.community.mapper;

import ltwu9306.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_creae,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreae},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
}
