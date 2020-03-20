package com.cdchen.auth.repository;

import com.cdchen.auth.entity.Secret;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecretRepository extends JpaRepository<Secret,Long> {

    List<Secret>  findByUser_Id(Long userId);
}
