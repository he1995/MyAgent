package com.example.myagent.mask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mask")
public class MaskController {

    @Autowired
    private MaskRepository maskRepository;

    @GetMapping("all")
    public Iterable<Mask> getAllMasks() {
        return maskRepository.findAll();
    }
}
