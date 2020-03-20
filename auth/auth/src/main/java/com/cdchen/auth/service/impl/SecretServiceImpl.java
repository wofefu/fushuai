package com.cdchen.auth.service.impl;

import com.cdchen.auth.entity.Secret;
import com.cdchen.auth.repository.SecretRepository;
import com.cdchen.auth.service.SecretService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SecretServiceImpl implements SecretService {

    private final SecretRepository secretRepository;

    public SecretServiceImpl(SecretRepository secretRepository) {
        this.secretRepository = secretRepository;
    }

    @Override
    public List<Secret> byUserId(Long userId) {
        return secretRepository.findByUser_Id(userId);
    }
}
