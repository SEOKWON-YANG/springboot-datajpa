package com.example.springbootdatajpa.repository;

import com.example.springbootdatajpa.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MemoRepositoryTest {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testInsert(){

        IntStream.rangeClosed(1,100).forEach(i->{
            Memo memo = Memo.builder().memoText("Test"+i).build();
            memoRepository.save(memo);
        });

    }

    @Test
    public void testSelect(){

        //데이터베이스에 존재하는 mno
        Long mno = 1L;

        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("=======");
        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Transactional
    @Test
    public void testSelect2(){

        //데이터베이스에 존재하는 mno
        Long mno = 1L;

        Memo memo = memoRepository.getOne(mno);

        System.out.println("=======");
        System.out.println(memo);
    }

    @Test
    public void testUpdate(){
        Memo memo = Memo.builder().mno(1L).memoText("test2").build();

        System.out.println(memoRepository.save(memo));
    }

    @Test
    public void testDelete(){

        Long mno = 1L;
        memoRepository.deleteById(mno);
    }
}