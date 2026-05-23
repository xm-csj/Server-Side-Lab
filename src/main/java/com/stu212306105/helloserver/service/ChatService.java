package com.stu212306105.helloserver.service;
import com.stu212306105.helloserver.model.dto.ChatRequestDTO;
import com.stu212306105.helloserver.model.vo.ChatResponseVO;

public interface ChatService {
    ChatResponseVO chat(ChatRequestDTO requestDTO);
}