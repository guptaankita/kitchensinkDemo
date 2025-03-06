package com.example.kitchensinkDemo.controller;

import static org.mockito.Mockito.when;

import com.example.kitchensinkDemo.model.Member;
import com.example.kitchensinkDemo.service.MemberRegistration;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MemberController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class MemberControllerDiffblueTest {
    @Autowired
    private MemberController memberController;

    @MockitoBean
    private MemberRegistration memberRegistration;

    /**
     * Test {@link MemberController#listAllMembers()}.
     * <p>
     * Method under test: {@link MemberController#listAllMembers()}
     */
    @Test
    @DisplayName("Test listAllMembers()")
    @Tag("MaintainedByDiffblue")
    void testListAllMembers() throws Exception {
        // Arrange
        when(memberRegistration.getMembers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/kitchensink/members");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Test {@link MemberController#createMember(Member)}.
     * <p>
     * Method under test: {@link MemberController#createMember(Member)}
     */
    @Test
    @DisplayName("Test createMember(Member)")
    @Tag("MaintainedByDiffblue")
    void testCreateMember() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/kitchensink/register");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(memberController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
    }

    /**
     * Test {@link MemberController#getMemberById(Long)}.
     * <p>
     * Method under test: {@link MemberController#getMemberById(Long)}
     */
    @Test
    @DisplayName("Test getMemberById(Long)")
    @Tag("MaintainedByDiffblue")
    void testGetMemberById() throws Exception {
        // Arrange
        Member member = new Member();
        member.setEmail("jane.doe@example.org");
        member.setId(1L);
        member.setName("Name");
        member.setPhoneNumber("6625550144");
        Optional<Member> ofResult = Optional.of(member);
        when(memberRegistration.getMemberById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/kitchensink/{id:[0-9][0-9]*}", 99L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"phoneNumber\":\"6625550144\"}"));
    }
}
