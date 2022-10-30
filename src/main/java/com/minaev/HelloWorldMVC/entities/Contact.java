package com.minaev.HelloWorldMVC.entities;

import java.util.LinkedList;

public class Contact {
    int id;
    String name;
    String phone;
    String email;
    String blogLink;
    String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBlogLink() {
        return blogLink;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBlogLink(String blogLink) {
        this.blogLink = blogLink;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Contact(String name, String phone, String email, String blogLink, String comment) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.blogLink = blogLink;
        this.comment = comment;
    }

    public String string() {
        return ("{" + id + "," + name + ", " + phone + ", " + email + ", " + blogLink + ", " + comment + "}\n");
    }

    public static void print(LinkedList<Contact> list) {
        String str = "";
        for (Contact c : list)
            str = str.concat(c.string());
        System.out.println(str);
    }

}

