package com.org.emprunt.DTO;

import java.io.Serializable;


public class EmpruntEvent implements Serializable {
    private Long empruntId;    // ID de l'emprunt généré en base [cite: 57]
    private Long userId;       // ID de l'utilisateur [cite: 58]
    private Long bookId;       // ID du livre [cite: 59]
    private String eventType;  // Toujours "EMPRUNT_CREATED" [cite: 60]
    private String timestamp;  // Date au format ISO [cite: 63]

    public EmpruntEvent() {}

    public EmpruntEvent(Long empruntId, Long userId, Long bookId, String eventType, String timestamp) {
        this.empruntId = empruntId;
        this.userId = userId;
        this.bookId = bookId;
        this.eventType = eventType;
        this.timestamp = timestamp;
    }

    // Getters et Setters nécessaires pour la sérialisation JSON
    public Long getEmpruntId() { return empruntId; }
    public void setEmpruntId(Long empruntId) { this.empruntId = empruntId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}