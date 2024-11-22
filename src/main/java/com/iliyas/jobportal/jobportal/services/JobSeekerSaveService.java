package com.iliyas.jobportal.jobportal.services;

import com.iliyas.jobportal.jobportal.entity.JobPostActivity;
import com.iliyas.jobportal.jobportal.entity.JobSeekerProfile;
import com.iliyas.jobportal.jobportal.entity.JobSeekerSave;
import com.iliyas.jobportal.jobportal.repository.JobSeekerSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerSaveService {
    private JobSeekerSaveRepository jobSeekerSaveRepository;


    public JobSeekerSaveService(JobSeekerSaveRepository jobSeekerSaveRepository) {
        this.jobSeekerSaveRepository = jobSeekerSaveRepository;
    }

    public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId){
        return jobSeekerSaveRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerSave> getJobCandidates(JobPostActivity job){
        return jobSeekerSaveRepository.findByJob(job);
    }
}
