package com.exporter.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Voloboev
 */

@Entity
@Table(name = "customer")
public class Customer {
    private Integer id;
    private String login;
    private String password;
    private List<ExcelFile> files = new ArrayList<>();

    public Customer() {
    }

    public Customer(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.files = null;
    }



    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "customer_seq")
    @GeneratedValue(generator = "sequence", strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password", nullable = false)
    @Size(min = 6, message = "Bad password length")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<ExcelFile> getFiles() {
        return files;
    }
    public void setFiles(List<ExcelFile> files) {
        this.files = files;
    }
}
