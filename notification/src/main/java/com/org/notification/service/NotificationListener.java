package com.org.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.org.notification.DTO.EmpruntEvent;
@Service
public class NotificationListener {

    @KafkaListener(topics = "emprunt-created", groupId = "notification-group")
    public void handleNotification(EmpruntEvent event) {
        System.out.println("=================================================");
        System.out.println("NOTIFICATION REÇUE : Emprunt n°" + event.getEmpruntId());
        System.out.println("Utilisateur ID : " + event.getUserId());
        System.out.println("Livre ID : " + event.getBookId());
        System.out.println("Date : " + event.getTimestamp());
        System.out.println("=================================================");
    }
}