package com.leansecurity.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leansecurity.main.model.MonHoc;

@Repository("monhocRepository")
public interface MonHocRepository extends JpaRepository<MonHoc, Integer> {
}
