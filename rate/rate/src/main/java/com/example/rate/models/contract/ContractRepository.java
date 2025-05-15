package com.example.rate.models.contract;

import com.example.rate.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {
    boolean existsBycontractName(String contractName);

    Optional<Contract> findByUser_Id(String userId);
    Optional<Contract> findByUser(User user);
}
