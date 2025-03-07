package com.example.kitchensinkDemo.controller;

import com.example.kitchensinkDemo.model.Member;
import com.example.kitchensinkDemo.service.MemberRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/kitchensink")
public class MemberController {

    private final MemberRegistration memberRegistration; // this is equivalent to studentservice

    @Autowired
    public MemberController(MemberRegistration memberRegistration) {
        this.memberRegistration = memberRegistration;
    }

    @GetMapping(value = "/members")
    public List<Member> listAllMembers() {
        return memberRegistration.getMembers();
    }

    @GetMapping(path = "/{id:[0-9][0-9]*}")
    public Member getMemberById(@PathVariable("id") Long id) {
        Optional<Member> member = memberRegistration.getMemberById(id);

        if (!member.isPresent()) {
            throw new MyCustomException("Member not found", 404);
        }
        return member.get();
    }

//    @PostMapping(value = "/register", consumes ="application/json")
//    public void createMember(@RequestBody Member member) throws Exception {
//        try {
//            System.out.println(member);
//            memberRegistration.addNewMember(member);
//
//        } catch (Exception e) {
//            String message = getRootErrorMessage(e);
//        }
//    }

    @PostMapping(value = "/register", consumes ="application/x-www-form-urlencoded")
    public String createMember(Member member) throws Exception {
        try {
            System.out.println(member);
            memberRegistration.addNewMember(member);

        } catch (Exception e) {
            String message = getRootErrorMessage(e);
        }
        return "Spring Boot Application - Member Registration Successful";
    }

    private String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        String errorMessage = "Registration failed. See server log for more information";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }

}