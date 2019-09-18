package ltwu9306.community.community.service;

import ltwu9306.community.community.dto.PageinationDTO;
import ltwu9306.community.community.dto.QuestionDTO;
import ltwu9306.community.community.mapper.QuestionMapper;
import ltwu9306.community.community.mapper.UserMapper;
import ltwu9306.community.community.model.Question;
import ltwu9306.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//用来组装questionMapper和UserMapper

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PageinationDTO list(Integer page, Integer size) {

        PageinationDTO pageinationDTO = new PageinationDTO();
        Integer totoalCount = questionMapper.count();
        pageinationDTO.setPageination(totoalCount,page,size);

        if (page < 1) {
            page = 1;
        }
        if(page > pageinationDTO.getTotalPage()){
            page = pageinationDTO.getTotalPage();
        }
        //size*(page-1)
        Integer offset = size*(page-1);
        List<Question> questions = questionMapper.list(offset ,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for(Question question : questions){
            User user= userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageinationDTO.setQuestions(questionDTOList);

        return pageinationDTO;
    }

}
