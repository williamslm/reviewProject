package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatMessageMapper {

    @Select("SELECT * FROM MESSAGES WHERE MESSAGEID = #{messageid} ")
    ChatMessage getMessageById(Integer messageid);

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES (#{username}, #{messagetext})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insertMessage(ChatMessage chatMessage);

    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getAllMessages();
}
