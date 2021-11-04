package com.wildcodeschool.myProject.controller;

import com.wildcodeschool.myProject.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorIncarnation {
    @RequestMapping("/doctor/incarnation/{number}")
    @ResponseBody
    public Doctor index(@PathVariable int number) {

        if (number > 0 && number < 9) {
            // exception 303
            throw new ResponseStatusException(HttpStatus.SEE_OTHER);
        }
        //try {
        switch (number) {
            case 9:
                Doctor doc9 = new Doctor(9, "Christopher Eccleston");
                return doc9;
            case 10:
                Doctor doc10 = new Doctor(10, "David Tennant");
                return doc10;
            case 11:
                Doctor doc11 = new Doctor(11, "Matt Smith");
                return doc11;
            case 12:
                Doctor doc12 = new Doctor(12, "Peter Capaldi");
                return doc12;
            case 13:
                Doctor doc13 = new Doctor(13, "Jodie Whittaker");
                return doc13;
            default:
                // exception 404
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible to retrieve the incarnation " + number);
        }
    }
}

