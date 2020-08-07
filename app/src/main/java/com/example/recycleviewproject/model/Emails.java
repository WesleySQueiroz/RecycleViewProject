package com.example.recycleviewproject.model;

import java.util.Arrays;
import java.util.List;

public class Emails {

    public static List<Email> fakeEmails(){

        return Arrays.asList(
                Email.EmailBuilder.builder()
                        .setUser("Facebook - 01")
                        .setSubject("Facebook Teste")
                        .setPreview("Este é u mteste de lista do facebook")
                        .setDate("06 Ago")
                        .setSelected(false)
                        .setStarted(false)
                        .setUnread(false)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Facebook - 02")
                        .setSubject("Facebook Teste")
                        .setPreview("Este é u mteste de lista do facebook")
                        .setDate("05 Ago")
                        .setSelected(false)
                        .setStarted(true)
                        .setUnread(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Facebook - 03")
                        .setSubject("Facebook Teste")
                        .setPreview("Este é u mteste de lista do facebook")
                        .setDate("04 Ago")
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Facebook - 04")
                        .setSubject("Facebook Teste")
                        .setPreview("Este é u mteste de lista do facebook")
                        .setDate("05 Ago")
                        .setSelected(false)
                        .setStarted(true)
                        .setUnread(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Facebook - 05")
                        .setSubject("Facebook Teste")
                        .setPreview("Este é u mteste de lista do facebook")
                        .setDate("05 Ago")
                        .setSelected(false)
                        .setStarted(true)
                        .setUnread(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Facebook - 06")
                        .setSubject("Facebook Teste")
                        .setPreview("Este é u mteste de lista do facebook")
                        .setDate("05 Ago")
                        .setSelected(false)
                        .setStarted(true)
                        .setUnread(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Facebook - 07")
                        .setSubject("Facebook Teste")
                        .setPreview("Este é u mteste de lista do facebook")
                        .setDate("05 Ago")
                        .setSelected(false)
                        .setStarted(true)
                        .setUnread(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Facebook - 08")
                        .setSubject("Facebook Teste")
                        .setPreview("Este é u mteste de lista do facebook")
                        .setDate("05 Ago")
                        .setSelected(false)
                        .setStarted(true)
                        .setUnread(true)
                        .build()
        );

    }



}
