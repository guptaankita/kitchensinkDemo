package com.example.kitchensinkDemo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MemberDiffblueTest {
    /**
     * Test getters and setters.
     * <ul>
     *   <li>When {@code Name}.</li>
     * </ul>
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Member#Member(String, String, String)}
     *   <li>{@link Member#setEmail(String)}
     *   <li>{@link Member#setId(Long)}
     *   <li>{@link Member#setName(String)}
     *   <li>{@link Member#setPhoneNumber(String)}
     *   <li>{@link Member#toString()}
     *   <li>{@link Member#getEmail()}
     *   <li>{@link Member#getId()}
     *   <li>{@link Member#getName()}
     *   <li>{@link Member#getPhoneNumber()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters; when 'Name'")
    @Tag("MaintainedByDiffblue")
    void testGettersAndSetters_whenName() {
        // Arrange and Act
        Member actualMember = new Member("Name", "jane.doe@example.org", "6625550144");
        actualMember.setEmail("jane.doe@example.org");
        actualMember.setId(1L);
        actualMember.setName("Name");
        actualMember.setPhoneNumber("6625550144");
        String actualToStringResult = actualMember.toString();
        String actualEmail = actualMember.getEmail();
        Long actualId = actualMember.getId();
        String actualName = actualMember.getName();

        // Assert
        assertEquals("6625550144", actualMember.getPhoneNumber());
        assertEquals("Member{id=1, name='Name', email='jane.doe@example.org', phoneNumber='6625550144'}",
                actualToStringResult);
        assertEquals("Name", actualName);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, actualId.longValue());
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Member#Member()}
     *   <li>{@link Member#setEmail(String)}
     *   <li>{@link Member#setId(Long)}
     *   <li>{@link Member#setName(String)}
     *   <li>{@link Member#setPhoneNumber(String)}
     *   <li>{@link Member#toString()}
     *   <li>{@link Member#getEmail()}
     *   <li>{@link Member#getId()}
     *   <li>{@link Member#getName()}
     *   <li>{@link Member#getPhoneNumber()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    @Tag("MaintainedByDiffblue")
    void testGettersAndSetters() {
        // Arrange and Act
        Member actualMember = new Member();
        actualMember.setEmail("jane.doe@example.org");
        actualMember.setId(1L);
        actualMember.setName("Name");
        actualMember.setPhoneNumber("6625550144");
        String actualToStringResult = actualMember.toString();
        String actualEmail = actualMember.getEmail();
        Long actualId = actualMember.getId();
        String actualName = actualMember.getName();

        // Assert
        assertEquals("6625550144", actualMember.getPhoneNumber());
        assertEquals("Member{id=1, name='Name', email='jane.doe@example.org', phoneNumber='6625550144'}",
                actualToStringResult);
        assertEquals("Name", actualName);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, actualId.longValue());
    }

    /**
     * Test getters and setters.
     * <ul>
     *   <li>When one.</li>
     * </ul>
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Member#Member(Long, String, String, String)}
     *   <li>{@link Member#setEmail(String)}
     *   <li>{@link Member#setId(Long)}
     *   <li>{@link Member#setName(String)}
     *   <li>{@link Member#setPhoneNumber(String)}
     *   <li>{@link Member#toString()}
     *   <li>{@link Member#getEmail()}
     *   <li>{@link Member#getId()}
     *   <li>{@link Member#getName()}
     *   <li>{@link Member#getPhoneNumber()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters; when one")
    @Tag("MaintainedByDiffblue")
    void testGettersAndSetters_whenOne() {
        // Arrange and Act
        Member actualMember = new Member(1L, "Name", "jane.doe@example.org", "6625550144");
        actualMember.setEmail("jane.doe@example.org");
        actualMember.setId(1L);
        actualMember.setName("Name");
        actualMember.setPhoneNumber("6625550144");
        String actualToStringResult = actualMember.toString();
        String actualEmail = actualMember.getEmail();
        Long actualId = actualMember.getId();
        String actualName = actualMember.getName();

        // Assert
        assertEquals("6625550144", actualMember.getPhoneNumber());
        assertEquals("Member{id=1, name='Name', email='jane.doe@example.org', phoneNumber='6625550144'}",
                actualToStringResult);
        assertEquals("Name", actualName);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, actualId.longValue());
    }
}
