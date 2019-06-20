package com.leansecurity.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leansecurity.main.model.ThongBao;

@Repository("thongbaoRepository")
public interface ThongBaoRepository extends JpaRepository<ThongBao, Integer>{

}
