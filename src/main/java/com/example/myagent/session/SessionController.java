package com.example.myagent.session;

import com.example.myagent.message.ChatMessage;
import com.example.myagent.message.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/session")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ChatMessageRepository messageRepository;

    @PostMapping(path="/add")
    public String addSession (@RequestBody Session session) {
        sessionRepository.save(session);
        return "Saved";
    }

    @PostMapping(path="/message/add")
    public String addMessage (@RequestParam String sessionId, @RequestBody ChatMessage message) {
        Session session = sessionRepository.findById(sessionId).get();
        message.setSession(session);
        messageRepository.save(message);
        return "Saved";
    }

    @PostMapping(path="/delete")
    public String deleteSession (@RequestParam String sessionId) {
        sessionRepository.deleteById(sessionId);
        return "Deleted";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Session> getAllSessions() {
        return sessionRepository.findAll();
    }
}
