package com.ApexSolution.postgresql.DataAccess.Entity.Repository;

import com.ApexSolution.postgresql.DataAccess.Entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Query("SELECT MAX(r.report_id) FROM Report r")
    Integer findMaxReportId();

}
