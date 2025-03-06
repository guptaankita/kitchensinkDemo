package com.example.kitchensinkDemo.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.kitchensinkDemo.data.MemberRepository;
import com.example.kitchensinkDemo.model.Member;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MemberRegistration.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class MemberRegistrationDiffblueTest {
    @Autowired
    private MemberRegistration memberRegistration;

    @MockBean
    private MemberRepository memberRepository;

    @MockBean
    private Validator validator;

    /**
     * Test {@link MemberRegistration#getMemberById(Long)}.
     * <ul>
     *   <li>Then return {@link Optional} with {@link Member#Member()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#getMemberById(Long)}
     */
    @Test
    @DisplayName("Test getMemberById(Long); then return Optional with Member()")
    @Tag("MaintainedByDiffblue")
    void testGetMemberById_thenReturnOptionalWithMember() {
        // Arrange
        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        member.setId(1L);
        member.setName("Name");
        member.setPhoneNumber("6625550144");
        Optional<Member> ofResult = Optional.of(member);
        when(memberRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Optional<Member> actualMemberById = memberRegistration.getMemberById(1L);

        // Assert
        verify(memberRepository).findById(eq(1L));
        assertSame(ofResult, actualMemberById);
    }

    /**
     * Test {@link MemberRegistration#getMemberById(Long)}.
     * <ul>
     *   <li>Then throw {@link IllegalStateException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#getMemberById(Long)}
     */
    @Test
    @DisplayName("Test getMemberById(Long); then throw IllegalStateException")
    @Tag("MaintainedByDiffblue")
    void testGetMemberById_thenThrowIllegalStateException() {
        // Arrange
        when(memberRepository.findById(Mockito.<Long>any())).thenThrow(new IllegalStateException("foo"));

        // Act and Assert
        assertThrows(IllegalStateException.class, () -> memberRegistration.getMemberById(1L));
        verify(memberRepository).findById(eq(1L));
    }

    /**
     * Test {@link MemberRegistration#addNewMember(Member)}.
     * <ul>
     *   <li>Given {@link MemberRepository} {@link CrudRepository#save(Object)} return {@link Member#Member()}.</li>
     *   <li>Then calls {@link CrudRepository#save(Object)}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#addNewMember(Member)}
     */
    @Test
    @DisplayName("Test addNewMember(Member); given MemberRepository save(Object) return Member(); then calls save(Object)")
    @Tag("MaintainedByDiffblue")
    void testAddNewMember_givenMemberRepositorySaveReturnMember_thenCallsSave() {
        // Arrange
        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        member.setId(1L);
        member.setName("Name");
        member.setPhoneNumber("6625550144");
        when(memberRepository.save(Mockito.<Member>any())).thenReturn(member);
        Optional<Member> emptyResult = Optional.empty();
        when(memberRepository.findByEmail(Mockito.<String>any())).thenReturn(emptyResult);

        Member member2 = new Member();
        member2.setEmail("jane.doe@example.org");
        member2.setId(1L);
        member2.setName("Name");
        member2.setPhoneNumber("6625550144");

        // Act
        memberRegistration.addNewMember(member2);

        // Assert
        verify(memberRepository).findByEmail(eq("jane.doe@example.org"));
        verify(memberRepository).save(isA(Member.class));
    }

    /**
     * Test {@link MemberRegistration#addNewMember(Member)}.
     * <ul>
     *   <li>Then throw {@link IllegalStateException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#addNewMember(Member)}
     */
    @Test
    @DisplayName("Test addNewMember(Member); then throw IllegalStateException")
    @Tag("MaintainedByDiffblue")
    void testAddNewMember_thenThrowIllegalStateException() {
        // Arrange
        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        member.setId(1L);
        member.setName("Name");
        member.setPhoneNumber("6625550144");
        Optional<Member> ofResult = Optional.of(member);
        when(memberRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);

        Member member2 = new Member();
        member2.setEmail("jane.doe@example.org");
        member2.setId(1L);
        member2.setName("Name");
        member2.setPhoneNumber("6625550144");

        // Act and Assert
        assertThrows(IllegalStateException.class, () -> memberRegistration.addNewMember(member2));
        verify(memberRepository).findByEmail(eq("jane.doe@example.org"));
    }

    /**
     * Test {@link MemberRegistration#addNewMember(Member)}.
     * <ul>
     *   <li>Then throw {@link ValidationException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#addNewMember(Member)}
     */
    @Test
    @DisplayName("Test addNewMember(Member); then throw ValidationException")
    @Tag("MaintainedByDiffblue")
    void testAddNewMember_thenThrowValidationException() {
        // Arrange
        when(memberRepository.findByEmail(Mockito.<String>any())).thenThrow(new ValidationException("An error occurred"));

        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        member.setId(1L);
        member.setName("Name");
        member.setPhoneNumber("6625550144");

        // Act and Assert
        assertThrows(ValidationException.class, () -> memberRegistration.addNewMember(member));
        verify(memberRepository).findByEmail(eq("jane.doe@example.org"));
    }

    /**
     * Test {@link MemberRegistration#emailAlreadyExists(String)}.
     * <ul>
     *   <li>Given {@link Member#Member()} Email is {@code jane.doe@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#emailAlreadyExists(String)}
     */
    @Test
    @DisplayName("Test emailAlreadyExists(String); given Member() Email is 'jane.doe@example.org'; then return 'true'")
    @Tag("MaintainedByDiffblue")
    void testEmailAlreadyExists_givenMemberEmailIsJaneDoeExampleOrg_thenReturnTrue() {
        // Arrange
        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        member.setId(1L);
        member.setName("Name");
        member.setPhoneNumber("6625550144");
        Optional<Member> ofResult = Optional.of(member);
        when(memberRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        boolean actualEmailAlreadyExistsResult = memberRegistration.emailAlreadyExists("jane.doe@example.org");

        // Assert
        verify(memberRepository).findByEmail(eq("jane.doe@example.org"));
        assertTrue(actualEmailAlreadyExistsResult);
    }

    /**
     * Test {@link MemberRegistration#emailAlreadyExists(String)}.
     * <ul>
     *   <li>Given {@link MemberRepository}.</li>
     *   <li>When {@code null}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#emailAlreadyExists(String)}
     */
    @Test
    @DisplayName("Test emailAlreadyExists(String); given MemberRepository; when 'null'; then return 'false'")
    @Tag("MaintainedByDiffblue")
    void testEmailAlreadyExists_givenMemberRepository_whenNull_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(memberRegistration.emailAlreadyExists(null));
    }

    /**
     * Test {@link MemberRegistration#emailAlreadyExists(String)}.
     * <ul>
     *   <li>Then throw {@link IllegalStateException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#emailAlreadyExists(String)}
     */
    @Test
    @DisplayName("Test emailAlreadyExists(String); then throw IllegalStateException")
    @Tag("MaintainedByDiffblue")
    void testEmailAlreadyExists_thenThrowIllegalStateException() {
        // Arrange
        when(memberRepository.findByEmail(Mockito.<String>any())).thenThrow(new IllegalStateException("foo"));

        // Act and Assert
        assertThrows(IllegalStateException.class, () -> memberRegistration.emailAlreadyExists("jane.doe@example.org"));
        verify(memberRepository).findByEmail(eq("jane.doe@example.org"));
    }

    /**
     * Test {@link MemberRegistration#emailAlreadyExists(String)}.
     * <ul>
     *   <li>When empty string.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#emailAlreadyExists(String)}
     */
    @Test
    @DisplayName("Test emailAlreadyExists(String); when empty string; then return 'false'")
    @Tag("MaintainedByDiffblue")
    void testEmailAlreadyExists_whenEmptyString_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(memberRegistration.emailAlreadyExists(""));
    }

    /**
     * Test {@link MemberRegistration#register(Member)}.
     * <ul>
     *   <li>Given {@link MemberRepository} {@link MemberRepository#findByEmail(String)} return empty.</li>
     *   <li>Then calls {@link CrudRepository#save(Object)}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#register(Member)}
     */
    @Test
    @DisplayName("Test register(Member); given MemberRepository findByEmail(String) return empty; then calls save(Object)")
    @Tag("MaintainedByDiffblue")
    void testRegister_givenMemberRepositoryFindByEmailReturnEmpty_thenCallsSave() throws Exception {
        // Arrange
        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        member.setId(1L);
        member.setName("Name");
        member.setPhoneNumber("6625550144");
        when(memberRepository.save(Mockito.<Member>any())).thenReturn(member);
        Optional<Member> emptyResult = Optional.empty();
        when(memberRepository.findByEmail(Mockito.<String>any())).thenReturn(emptyResult);
        when(validator.validate(Mockito.<Member>any(), isA(Class[].class))).thenReturn(new HashSet<>());

        Member member2 = new Member();
        member2.setEmail("jane.doe@example.org");
        member2.setId(1L);
        member2.setName("Name");
        member2.setPhoneNumber("6625550144");

        // Act
        memberRegistration.register(member2);

        // Assert
        verify(memberRepository, atLeast(1)).findByEmail(eq("jane.doe@example.org"));
        verify(validator).validate(isA(Member.class), isA(Class[].class));
        verify(memberRepository).save(isA(Member.class));
    }

    /**
     * Test {@link MemberRegistration#register(Member)}.
     * <ul>
     *   <li>Then throw {@link ConstraintViolationException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#register(Member)}
     */
    @Test
    @DisplayName("Test register(Member); then throw ConstraintViolationException")
    @Tag("MaintainedByDiffblue")
    void testRegister_thenThrowConstraintViolationException() throws Exception {
        // Arrange
        ConstraintViolation<Member> constraintViolation = mock(ConstraintViolation.class);
        when(constraintViolation.getPropertyPath()).thenReturn(PathImpl.createRootPath());
        when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");

        HashSet<ConstraintViolation<Member>> constraintViolationSet = new HashSet<>();
        constraintViolationSet.add(constraintViolation);
        when(validator.validate(Mockito.<Member>any(), isA(Class[].class))).thenReturn(constraintViolationSet);

        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        member.setId(1L);
        member.setName("Name");
        member.setPhoneNumber("6625550144");

        // Act and Assert
        assertThrows(ConstraintViolationException.class, () -> memberRegistration.register(member));
        verify(constraintViolation).getMessage();
        verify(constraintViolation).getPropertyPath();
        verify(validator).validate(isA(Member.class), isA(Class[].class));
    }

    /**
     * Test {@link MemberRegistration#register(Member)}.
     * <ul>
     *   <li>Then throw {@link ConstraintViolationException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#register(Member)}
     */
    @Test
    @DisplayName("Test register(Member); then throw ConstraintViolationException")
    @Tag("MaintainedByDiffblue")
    void testRegister_thenThrowConstraintViolationException2() throws Exception {
        // Arrange
        ConstraintViolation<Member> constraintViolation = mock(ConstraintViolation.class);
        when(constraintViolation.getPropertyPath()).thenReturn(PathImpl.createRootPath());
        when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
        ConstraintViolation<Member> constraintViolation2 = mock(ConstraintViolation.class);
        when(constraintViolation2.getPropertyPath()).thenReturn(PathImpl.createRootPath());
        when(constraintViolation2.getMessage()).thenReturn("Not all who wander are lost");

        HashSet<ConstraintViolation<Member>> constraintViolationSet = new HashSet<>();
        constraintViolationSet.add(constraintViolation2);
        constraintViolationSet.add(constraintViolation);
        when(validator.validate(Mockito.<Member>any(), isA(Class[].class))).thenReturn(constraintViolationSet);

        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        member.setId(1L);
        member.setName("Name");
        member.setPhoneNumber("6625550144");

        // Act and Assert
        assertThrows(ConstraintViolationException.class, () -> memberRegistration.register(member));
        verify(constraintViolation2).getMessage();
        verify(constraintViolation).getMessage();
        verify(constraintViolation2).getPropertyPath();
        verify(constraintViolation).getPropertyPath();
        verify(validator).validate(isA(Member.class), isA(Class[].class));
    }

    /**
     * Test {@link MemberRegistration#register(Member)}.
     * <ul>
     *   <li>Then throw {@link IllegalStateException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#register(Member)}
     */
    @Test
    @DisplayName("Test register(Member); then throw IllegalStateException")
    @Tag("MaintainedByDiffblue")
    void testRegister_thenThrowIllegalStateException() throws Exception {
        // Arrange
        when(validator.validate(Mockito.<Member>any(), isA(Class[].class))).thenThrow(new IllegalStateException("foo"));

        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        member.setId(1L);
        member.setName("Name");
        member.setPhoneNumber("6625550144");

        // Act and Assert
        assertThrows(IllegalStateException.class, () -> memberRegistration.register(member));
        verify(validator).validate(isA(Member.class), isA(Class[].class));
    }

    /**
     * Test {@link MemberRegistration#register(Member)}.
     * <ul>
     *   <li>Then throw {@link ValidationException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#register(Member)}
     */
    @Test
    @DisplayName("Test register(Member); then throw ValidationException")
    @Tag("MaintainedByDiffblue")
    void testRegister_thenThrowValidationException() throws Exception {
        // Arrange
        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        member.setId(1L);
        member.setName("Name");
        member.setPhoneNumber("6625550144");
        Optional<Member> ofResult = Optional.of(member);
        when(memberRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
        when(validator.validate(Mockito.<Member>any(), isA(Class[].class))).thenReturn(new HashSet<>());

        Member member2 = new Member();
        member2.setEmail("jane.doe@example.org");
        member2.setId(1L);
        member2.setName("Name");
        member2.setPhoneNumber("6625550144");

        // Act and Assert
        assertThrows(ValidationException.class, () -> memberRegistration.register(member2));
        verify(memberRepository).findByEmail(eq("jane.doe@example.org"));
        verify(validator).validate(isA(Member.class), isA(Class[].class));
    }

    /**
     * Test {@link MemberRegistration#getMembersOrderedByName()}.
     * <ul>
     *   <li>Then return Empty.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#getMembersOrderedByName()}
     */
    @Test
    @DisplayName("Test getMembersOrderedByName(); then return Empty")
    @Tag("MaintainedByDiffblue")
    void testGetMembersOrderedByName_thenReturnEmpty() {
        // Arrange
        when(memberRepository.findAll(Mockito.<Sort>any())).thenReturn(new ArrayList<>());

        // Act
        List<Member> actualMembersOrderedByName = memberRegistration.getMembersOrderedByName();

        // Assert
        verify(memberRepository).findAll(isA(Sort.class));
        assertTrue(actualMembersOrderedByName.isEmpty());
    }

    /**
     * Test {@link MemberRegistration#getMembersOrderedByName()}.
     * <ul>
     *   <li>Then throw {@link IllegalStateException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#getMembersOrderedByName()}
     */
    @Test
    @DisplayName("Test getMembersOrderedByName(); then throw IllegalStateException")
    @Tag("MaintainedByDiffblue")
    void testGetMembersOrderedByName_thenThrowIllegalStateException() {
        // Arrange
        when(memberRepository.findAll(Mockito.<Sort>any())).thenThrow(new IllegalStateException("name"));

        // Act and Assert
        assertThrows(IllegalStateException.class, () -> memberRegistration.getMembersOrderedByName());
        verify(memberRepository).findAll(isA(Sort.class));
    }

    /**
     * Test {@link MemberRegistration#getMembers()}.
     * <ul>
     *   <li>Given {@link MemberRepository} {@link ListCrudRepository#findAll()} return {@link ArrayList#ArrayList()}.</li>
     *   <li>Then return Empty.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#getMembers()}
     */
    @Test
    @DisplayName("Test getMembers(); given MemberRepository findAll() return ArrayList(); then return Empty")
    @Tag("MaintainedByDiffblue")
    void testGetMembers_givenMemberRepositoryFindAllReturnArrayList_thenReturnEmpty() {
        // Arrange
        when(memberRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<Member> actualMembers = memberRegistration.getMembers();

        // Assert
        verify(memberRepository).findAll();
        assertTrue(actualMembers.isEmpty());
    }

    /**
     * Test {@link MemberRegistration#getMembers()}.
     * <ul>
     *   <li>Then throw {@link IllegalStateException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MemberRegistration#getMembers()}
     */
    @Test
    @DisplayName("Test getMembers(); then throw IllegalStateException")
    @Tag("MaintainedByDiffblue")
    void testGetMembers_thenThrowIllegalStateException() {
        // Arrange
        when(memberRepository.findAll()).thenThrow(new IllegalStateException("foo"));

        // Act and Assert
        assertThrows(IllegalStateException.class, () -> memberRegistration.getMembers());
        verify(memberRepository).findAll();
    }
}
