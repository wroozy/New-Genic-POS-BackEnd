package lk.wroozy.newgeniccomputer.controller;

import lk.wroozy.newgeniccomputer.dto.request.AdminRequestDTO;
import lk.wroozy.newgeniccomputer.jwt.AuthenticationRequest;
import lk.wroozy.newgeniccomputer.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> adminSignUp(@RequestBody AdminRequestDTO adminRequestDTO){
        LOGGER.info("request - admin | adminSignUp | adminRequestDTO: {}",adminRequestDTO);
        ResponseEntity<?> adminSignUp = adminService.adminSignUp(adminRequestDTO);
        LOGGER.info("response - admin | adminSignUp | adminSignUp: {}",adminSignUp.getBody());
        return adminSignUp;
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> adminSignIn(@RequestBody AuthenticationRequest authenticationRequest){
        LOGGER.info("request - admin | adminSignIn | authenticationRequest: {}",authenticationRequest);
        ResponseEntity<?> adminSignIn = adminService.adminSingIn(authenticationRequest);
        LOGGER.info("response - admin | adminSignIn | adminSignIn: {}",adminSignIn.getBody());
        return adminSignIn;
    }
}