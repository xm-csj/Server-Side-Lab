package com.stu212306105.helloserver.controller;

import com.stu212306105.helloserver.common.Result;
import com.stu212306105.helloserver.model.dto.ChatRequestDTO;
import com.stu212306105.helloserver.model.vo.ChatResponseVO;
import com.stu212306105.helloserver.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public Result<ChatResponseVO> chat(@RequestBody ChatRequestDTO requestDTO) {
        ChatResponseVO responseVO = chatService.chat(requestDTO);
        return Result.success(responseVO);
    }
}