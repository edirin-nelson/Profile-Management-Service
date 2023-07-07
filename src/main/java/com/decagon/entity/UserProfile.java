package com.decagon.entity;

import com.decagon.enums.UserType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table (name = "user_profile")
public class UserProfile {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int profile_id;
    @Column(name = "user_id", columnDefinition = "VARCHAR(255)")
    private String userId;
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(name = "contact_info")
    private String contactInfo;
    @Column(name = "employment_status")
    private String employmentStatus;
    @Column(name = "income")
    private BigDecimal income;
    @Lob
    @Column(name = "verification_document")
    private byte[] identityVerificationDocument;

    private String proofOfAddress;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public UserProfile(UserType userType, String contactInfo, String employmentStatus,
                       BigDecimal income, byte[] identityVerificationDocument,
                       LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = generateUserId();
        this.userType = userType;
        this.contactInfo = contactInfo;
        this.employmentStatus = employmentStatus;
        this.income = income;
        this.identityVerificationDocument = identityVerificationDocument;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserProfile(){
    }

    private String generateUserId() {
        return UUID.randomUUID().toString();
    }
}
