package mss.community.service;

import mss.community.dto.PaginationDTO;
import mss.community.dto.QuestionDTO;
import mss.community.mapper.QuestionMapper;
import mss.community.mapper.UserMapper;
import mss.community.model.Question;
import mss.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *Created by MSS on 2021/4/5
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size){

        PaginationDTO paginationDTO=new PaginationDTO();
        Integer totalCount= questionMapper.count();
        Integer totalPage;
        if(totalCount %size==0){
            totalPage=totalCount/size;
        }else{
            totalPage=totalCount/size+1;
        }

        if(page<1){
            page=1;
        }
        if(page>totalPage){
            page=totalPage;
        }
        paginationDTO.setPagination(totalPage,page);
        //size*(page-1)
        Integer offset=size*(page-1);
        if(offset<0){
            offset=0;
        }
        List<Question> questions=questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for(Question question:questions){
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public PaginationDTO list(Integer userID, Integer page, Integer size) {
        PaginationDTO paginationDTO=new PaginationDTO();
        Integer totalCount= questionMapper.countByUserId(userID);
        Integer totalPage;
        if(totalCount %size==0){
            totalPage=totalCount/size;
        }else{
            totalPage=totalCount/size+1;
        }

        if(page<1){
            page=1;
        }
        if(page>totalPage){
            page=totalPage;
        }

        paginationDTO.setPagination(totalPage,page);
        //size*(page-1)
        Integer offset=size*(page-1);
        if(offset<0){
            offset=0;
        }
        List<Question> questions=questionMapper.listByUserId(userID,offset,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for(Question question:questions){
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        Question question=questionMapper.getById(id);
        QuestionDTO questionDTO=new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        User user=userMapper.findById(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void creatOrUpdate(Question question) {
        if(question.getId()==null){
            //创建

            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.create(question);
        }else{
            //更新
            question.setGmtModified(System.currentTimeMillis());
            questionMapper.update(question);
        }
    }
}
