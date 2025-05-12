package com.example.rate.models.report;

import com.example.rate.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequest {
    String id;
    String user;
    String targetId;
    Double dedicationScore;
    Double teamworkScore;
    Double complianceScore;
}
