package com.cdchen.auth.service;

import com.cdchen.auth.entity.Secret;

import java.util.List;

public interface SecretService {

    List<Secret> byUserId(Long userId);
}
