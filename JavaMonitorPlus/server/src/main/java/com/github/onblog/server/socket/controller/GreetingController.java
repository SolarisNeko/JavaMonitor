package com.github.onblog.server.socket.controller;


import com.github.onblog.server.database.entity.ClassLoadEntity;
import com.github.onblog.server.database.entity.GcEntity;
import com.github.onblog.server.database.entity.ThreadEntity;
import com.github.onblog.server.database.service.ClassService;
import com.github.onblog.server.database.service.GcService;
import com.github.onblog.server.database.service.ThreadService;
import com.github.onblog.server.view.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Create by Martin 2018/6/19/019 23:49
 */
@Controller
public class GreetingController {

    @Autowired
    private GcService gcService;
    @Autowired
    private ClassService classService;
    @Autowired
    private ThreadService threadService;

    @MessageMapping("/gc")
    @SendTo("/topic/gc")
    public List<GcEntity> socketGc(Message message) throws Exception {
        return gcService.findAllByAddressAndName(message.getAddress(),message.getPid());
    }

    @MessageMapping("/class")
    @SendTo("/topic/class")
    public List<ClassLoadEntity> socketClass(Message message) throws Exception {
        return classService.findAllByAddressAndName(message.getAddress(),message.getPid());
    }

    @MessageMapping("/thread")
    @SendTo("/topic/thread")
    public List<ThreadEntity> socketThread(Message message) throws Exception {
        return threadService.findAllByAddressAndName(message.getAddress(),message.getPid());
    }

}
