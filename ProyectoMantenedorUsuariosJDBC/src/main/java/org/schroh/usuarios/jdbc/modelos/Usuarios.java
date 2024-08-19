package org.schroh.usuarios.jdbc.modelos;

public class Usuarios {
    private Long id;
    private String username;
    private String password;
    private String email;

    public Usuarios(){}
    public Usuarios(String email, Long id, String password, String username) {
        this.email = email;
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return id + " | " +
                email + " | " +
                username + " | " +
                password + "\n";
    }
}