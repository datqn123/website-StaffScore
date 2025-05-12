package com.example.rate.models.contract;

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
public class ContractResponse {
    @Id
    String id;
    User user;
    String position;
    String contractName;
    Date start;
    Date end;
}
