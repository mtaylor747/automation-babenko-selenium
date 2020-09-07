package org.example.infrastructure.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUserDataMapper implements UserDataMapper {

    private List<User> Users = new ArrayList<>();

    public FileUserDataMapper() {

        try{
            BufferedReader rb = new BufferedReader(new FileReader(new File("Users.txt")));

            String line;
            while((line = rb.readLine())!= null){

                String[] parts = line.split(",");
                Users.add(new User(parts[0], parts[1], parts[2], parts[3]));

            }
        }catch(Exception ex){
            throw new RuntimeException("Something went wrong reading the file");
        }
    }
    @Override
    public User findUserByEmail(String email) {

        for(User u: Users){
            if(u != null && u.getEmail().equals(email)){
                return u;
            }
        }
        throw new UserNotFoundException("User with email" + email + "was not found.");
    }

    @Override
    public User findUserByUserName(String username) {
        for(User u: Users){
            if(u != null && u.getUsername().equals(username)){
                return u;
            }
        }
        throw new UserNotFoundException("User with username" + username + "was not found.");
    }

    public List<User> getAll(){
        return Users;
    }
}
