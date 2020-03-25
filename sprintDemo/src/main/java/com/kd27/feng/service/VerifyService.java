package com.kd27.feng.service;

import com.kd27.feng.entity.VerifyResult;

import java.util.Map;

public interface VerifyService {
     Map<String, String> buildHttpHeader();
     VerifyResult verify(String paths);
}
