package com.example.kitchensinkDemo.service;

import com.example.kitchensinkDemo.data.MemberRepository;
import com.example.kitchensinkDemo.model.Member;
import com.example.kitchensinkDemo.model.MemberEvent;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class MemberRegistration {

    private final MemberRepository memberRepository;

    Logger log = LoggerFactory.getLogger(this.getClass());

    private Validator validator;

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public MemberRegistration(MemberRepository memberRepository, ApplicationEventPublisher eventPublisher, Validator validator) {
        this.memberRepository = memberRepository;
        this.eventPublisher = eventPublisher;
        this.validator = validator;
    }

    public Optional<Member> getMemberById(Long id)
    {
        return memberRepository.findById(id);
    }

    public void addNewMember(Member member) {
        Optional<Member> memberByEmail = memberRepository.findByEmail(member.getEmail());

        if (memberByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        memberRepository.save(member);
        System.out.println(member);
    }

    private void validateMember(Member member) throws ValidationException {
        // Create a bean validator and check for issues.
        Set<ConstraintViolation<Member>> violations = validator.validate(member);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<>(violations));
        }

        // Check the uniqueness of the email address
        if (emailAlreadyExists(member.getEmail())) {
            throw new ValidationException("Unique Email Violation");
        }
    }

    public boolean emailAlreadyExists(String email) {

        if (email != null && email.length() > 0)
        {
            Optional<Member> member = memberRepository.findByEmail(email);
            return member.isPresent();
        }
        return false;
    }

    public void register(Member member) throws Exception {
        validateMember(member);
        log.info("Registering " + member.getName());
        addNewMember(member);
        eventPublisher.publishEvent(new MemberEvent(member, "New member"));
    }

    @EventListener
    public MemberEvent onUserRegistered(MemberEvent memberEvent) {
        log.info("New member " + memberEvent.getMessage());
        return memberEvent;
    }

    public List<Member> getMembersOrderedByName() {
        return memberRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }
}

