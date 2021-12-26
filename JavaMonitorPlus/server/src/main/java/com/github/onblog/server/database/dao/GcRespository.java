package com.github.onblog.server.database.dao;


import com.github.onblog.server.database.entity.GcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by Martin 2018/11/12 0012 21:38
 */
@Repository
public interface GcRespository extends JpaRepository<GcEntity, Integer> {
    List<GcEntity> findAllByAddressAndName(String address, String name);
}
