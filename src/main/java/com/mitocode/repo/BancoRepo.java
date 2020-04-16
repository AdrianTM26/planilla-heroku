package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Banco;

public interface BancoRepo extends JpaRepository<Banco, Integer>{

}
