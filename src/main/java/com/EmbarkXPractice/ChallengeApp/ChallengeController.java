package com.EmbarkXPractice.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChallengeController {

    private ChallengeService challengeService ;

    public ChallengeController(ChallengeService challengeService)
    {
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges()
    {
        return challengeService.getAllChallenges();
    }

    @PostMapping("/challenges")
    public ResponseEntity<String> createChallenge(@RequestBody Challenge challenge)
    {
        boolean isChalllengeAdded = challengeService.addChallenges(challenge);

         if(isChalllengeAdded)
             return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);

             return new ResponseEntity<>("Challenge not added",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallengebyMonth(@PathVariable String month)
    {
        Challenge challenge = challengeService.getChallenge(month);

        if(challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge challenge)
    {
        boolean isChallengeUpdated = challengeService.updateChallenge(id, challenge);

        if(isChallengeUpdated)
            return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);

        return new ResponseEntity<>("Challenge not updated", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id)
    {
        boolean isDeleted = challengeService.deleteChallenge(id);

        if(isDeleted)
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

        return new ResponseEntity<>("Not deleted Successfully", HttpStatus.BAD_REQUEST);
    }






}
