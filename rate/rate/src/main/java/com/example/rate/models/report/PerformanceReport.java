package com.example.rate.models.report;

import com.example.rate.models.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PerformanceReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    String id;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    String targetId;
    Double dedicationScore;
    Double teamworkScore;
    Double complianceScore;
    Date createdAt;
}
