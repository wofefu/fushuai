package com.cdchen.auth.repository;

import com.cdchen.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {

    List<Role> findByIdIn(Long[] ids);//相当于自动生成 select * from role where id in(....)
}
