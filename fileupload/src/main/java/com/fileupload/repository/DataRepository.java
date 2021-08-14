package com.fileupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fileupload.dao.Datadao;

@Repository
public interface DataRepository extends JpaRepository<Datadao, Long>{

}
