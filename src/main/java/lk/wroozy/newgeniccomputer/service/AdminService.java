package lk.wroozy.newgeniccomputer.service;

import lk.wroozy.newgeniccomputer.dto.request.AdminRequestDTO;
import lk.wroozy.newgeniccomputer.jwt.AuthenticationRequest;
import org.springframework.http.ResponseEntity;

public interface AdminService {

    ResponseEntity<?> adminSignUp(AdminRequestDTO adminRequestDTO);

    ResponseEntity<?> adminSingIn(AuthenticationRequest authenticationRequest);
}
