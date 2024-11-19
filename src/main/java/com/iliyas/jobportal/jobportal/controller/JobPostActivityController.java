package com.iliyas.jobportal.jobportal.controller;

import com.iliyas.jobportal.jobportal.entity.JobPostActivity;
import com.iliyas.jobportal.jobportal.entity.Users;
import com.iliyas.jobportal.jobportal.services.JobPostActivityService;
import com.iliyas.jobportal.jobportal.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class JobPostActivityController {
    private final UsersService userService;
    private final JobPostActivityService jobPostActivityService;



    @Autowired
    public JobPostActivityController(UsersService userService, JobPostActivityService jobPostActivityService) {
        this.userService = userService;

        this.jobPostActivityService = jobPostActivityService;
    }

    @GetMapping("/dashboard/")
    public String searchJobs(Model model)
    {
        Object currentUserProfile = userService.getCurrentUserProfile();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!(authentication instanceof AnonymousAuthenticationToken))
        {
            String currentUserName = authentication.getName();
            model.addAttribute("username", currentUserName);
        }
        model.addAttribute("user", currentUserProfile);

        return "dashboard";
    }

    @GetMapping("/dashboard/add")
    public String addJobs(Model model){
        model.addAttribute("jobPostActivity", new JobPostActivity());
        model.addAttribute("user", userService.getCurrentUserProfile());


        return "add-jobs";
    }

    @PostMapping("/dashboard/addNew")
    public String addNew(JobPostActivity jobPostActivity, Model model){
        Users users = userService.getCurrentUser();
        if(users != null){
            jobPostActivity.setPostedById(users);
        }
        jobPostActivity.setPostedDate(new Date());
        model.addAttribute("jobPostActivity", jobPostActivity);
        JobPostActivity saved = jobPostActivityService.addNew(jobPostActivity);





        return "redirect:/dashboard/";
    }



}
