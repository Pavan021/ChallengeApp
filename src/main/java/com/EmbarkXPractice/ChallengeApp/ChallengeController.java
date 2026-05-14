package com.EmbarkXPractice.ChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {

    private List<Challenge> challenges = new ArrayList();

    public ChallengeController()
    {
        Challenge challenge1 = new Challenge(1L, "January", "Start Java Programming");
        challenges.add(challenge1);
    }

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges()
    {
        return challenges;
    }





}
