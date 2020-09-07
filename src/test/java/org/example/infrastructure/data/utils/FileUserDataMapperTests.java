package org.example.infrastructure.data.utils;

import org.example.infrastructure.data.FileUserDataMapper;
import org.example.infrastructure.data.User;
import org.example.infrastructure.data.UserNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileUserDataMapperTests {

    private FileUserDataMapper dataMapper = new FileUserDataMapper();

    User expected = new User("7"," test7", "test7@gmail.com","zxcvbn");

    @Test
    public void testFindUserByExistingEmail(){

        assertEquals("Found User is incorrect", expected, dataMapper.findUserByEmail("test7@gmail.com"));

    }
    @Test(expected = UserNotFoundException.class)
    public void testFindUserByNonExistingEmail(){

        dataMapper.findUserByEmail("test00@gmail.com");

    }
    @Test
    public void testFindUserByExistingUsername(){

        assertEquals("Found User is incorrect", expected, dataMapper.findUserByUserName("test7"));

    }
    @Test(expected = UserNotFoundException.class)
    public void testFindUserByNonExistingUsername(){

        dataMapper.findUserByUserName("test00");

    }

}
