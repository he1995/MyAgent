package com.example.myagent.mask;

import com.example.myagent.message.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/mask")
public class MaskController {

    @Autowired
    private MaskRepository maskRepository;

    @PostMapping(path="/add_all") // Map ONLY POST Requests
    public @ResponseBody String addAllMasks (@RequestBody List<Mask> maskList) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        for (Mask mask : maskList) {
            for (ChatMessage chatMessage : mask.getContext()) {
                chatMessage.setMask(mask);
            }
        }
        maskRepository.saveAll(maskList);
        return "saved";
    }

    @GetMapping("all")
    public Iterable<Mask> getAllMasks() {
        return maskRepository.findAll();
    }
}
