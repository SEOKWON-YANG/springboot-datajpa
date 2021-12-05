package com.example.springbootdatajpa.repository;

import com.example.springbootdatajpa.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {

}
