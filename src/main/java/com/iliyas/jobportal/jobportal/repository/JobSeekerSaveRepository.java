package com.iliyas.jobportal.jobportal.repository;

import com.iliyas.jobportal.jobportal.entity.JobPostActivity;
import com.iliyas.jobportal.jobportal.entity.JobSeekerProfile;
import com.iliyas.jobportal.jobportal.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    public List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    public List<JobSeekerSave> findByJob(JobPostActivity job);
}
