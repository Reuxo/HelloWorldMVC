package com.minaev.HelloWorldMVC.controllers;
import com.minaev.HelloWorldMVC.entities.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.LinkedList;

@Controller
public class AddFirstContactController {

    public static LinkedList<Contact> contactList = new LinkedList<>();

    private static int getNextId() {
        if (contactList.isEmpty()) return 0;
        else return contactList.getLast().getId() + 1;
    }

    public static void addContact(Contact contact) {
        contact.setId(getNextId());
        contactList.add(contact);
    }


    @GetMapping("/addContact")
    public String addContact(@RequestParam String name,
                             @RequestParam String phone,
                             @RequestParam String email,
                             @RequestParam String blogLink,
                             @RequestParam String comment,
                             Model model) {
        generateContactList();
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        model.addAttribute("email", email);
        model.addAttribute("blogLink", blogLink);
        model.addAttribute("comment", comment);
        addContact(new Contact(name, phone, email, blogLink, comment));
        model.addAttribute("list", contactList);
        Contact.print(contactList);
        return "frontContact";
    }

    public static int[] getIds() {
        int[] ids = new int[contactList.size()];
        for (int i = 0; i < contactList.size(); i++)
            ids[i] = contactList.get(i).getId();
        System.out.println(Arrays.toString(ids));
        return ids;
    }
    private static int getContactIdByEntityId(int id) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public static Contact getContactById(int id) {
        return contactList.get(getContactIdByEntityId(id));
    }

    public void generateContactList() {
        addContact(new Contact("Alex", "+71112223344", "alex@gmail.com", "a.com", ""));
        addContact(new Contact("Alex", "+72223334455", "a2@gmail.com", "a2.com", "friend"));
        addContact(new Contact("Bob", "+73334445566", "b@gmail.com", "b.com", "school"));
        addContact(new Contact("Nick", "+74445556677", "n@gmail.com", "n.com", ""));
        addContact(new Contact("Nick", "+75556667788", "n2@gmail.com", "n2.com", "university"));
        addContact(new Contact("Paula", "+76667778899", "p@gmail.com", "p.com", "cutie"));
    }

    public static void updateContact(Contact contact) {
        int contactListId = getContactIdByEntityId(contact.getId());
        if (contactListId == -1)
            return;
        contactList.get(contactListId).setName(contact.getName());
        contactList.get(contactListId).setPhone(contact.getPhone());
        contactList.get(contactListId).setEmail(contact.getEmail());
        contactList.get(contactListId).setBlogLink(contact.getBlogLink());
        contactList.get(contactListId).setComment(contact.getComment());

   }



}
