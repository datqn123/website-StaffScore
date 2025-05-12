package com.example.rate.models.contract;

import com.example.rate.exception.AppException;
import com.example.rate.exception.ErrorCode;
import com.example.rate.mapper.ContractMapper;
import com.example.rate.models.user.User;
import com.example.rate.models.user.UserRepository;
import com.example.rate.models.user.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ContractService {
    ContractRepository contractRepository;
    ContractMapper contractMapper;
    UserRepository userRepository;

    public ContractResponse create(ContractRequest request) {
        Contract contract = contractMapper.toContract(request);
        contract.setContractName("Hop dong lao dong");
        User user = userRepository.findByUsername(request.getUser()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        contract.setUser(user);
        return contractMapper.toContractResponse(contractRepository.save(contract));
    }

    public ContractResponse getOne(String id)  {
        return contractMapper.toContractResponse(contractRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.CONTRACT_NOT_FOUND)));
    }

    public List<Contract> getAll() {
        return contractRepository.findAll();
    }

    void delete(String id) {
        contractRepository.deleteById(id);
    }
}
