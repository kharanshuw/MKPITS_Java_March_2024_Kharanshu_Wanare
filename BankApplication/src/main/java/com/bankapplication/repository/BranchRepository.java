package com.bankapplication.repository;

import com.bankapplication.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    @Query("select case when count(b) > 0 then true else false end from Branch b where b.ifscCode = :ifscCode")
    boolean existsByIfscCode(@Param("ifscCode") String ifscCode);
    
}
