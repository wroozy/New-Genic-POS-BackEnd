package lk.wroozy.newgeniccomputer.service.impl;

import lk.wroozy.newgeniccomputer.dto.request.AdminRequestDTO;
import lk.wroozy.newgeniccomputer.dto.response.AdminSignInResponseDTO;
import lk.wroozy.newgeniccomputer.dto.response.AdminSignUpResponseDTO;
import lk.wroozy.newgeniccomputer.entity.AdminEntity;
import lk.wroozy.newgeniccomputer.enums.Role;
import lk.wroozy.newgeniccomputer.exception.CustomException;
import lk.wroozy.newgeniccomputer.jwt.AuthenticationRequest;
import lk.wroozy.newgeniccomputer.jwt.JwtGenerator;
import lk.wroozy.newgeniccomputer.repository.AdminRepository;
import lk.wroozy.newgeniccomputer.service.AdminService;
import lk.wroozy.newgeniccomputer.util.DateConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    private final PasswordEncoder passwordEncoder;
    private AdminRepository adminRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AdminServiceImpl(PasswordEncoder passwordEncoder,
                            AdminRepository adminRepository,
                            ModelMapper modelMapper) {
        this.passwordEncoder = passwordEncoder;
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> adminSignUp(AdminRequestDTO adminRequestDTO) {
        try {
            if (adminRequestDTO != null) {
                AdminEntity byUsername = adminRepository.findByUsername(adminRequestDTO.getUserName());
                if (byUsername != null) {
                    return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
                }
                AdminEntity adminEntity = modelMapper.map(adminRequestDTO, AdminEntity.class);
                adminEntity.setUuid(UUID.randomUUID().toString());
                adminEntity.setPassword(passwordEncoder.encode(adminRequestDTO.getPassword()));
                adminEntity.setRegDate(DateConverter.localDateToSql(LocalDate.now()));
                adminEntity.setRegTime(DateConverter.localTimeToSql(LocalTime.now()));

                AdminEntity admin = adminRepository.save(adminEntity);
                if (admin != null) {
                    AdminSignUpResponseDTO adminSignUpResponseDTO = new AdminSignUpResponseDTO(
                            admin.getUuid(),
                            admin.getUsername(),
                            LocalDate.now(),
                            LocalTime.now()
                    );

                    return new ResponseEntity<>(adminSignUpResponseDTO, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Admin not saved", HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>("Request details not found", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            throw new CustomException("Admin SignUp failed");
        }
    }

    @Override
    public ResponseEntity<?> adminSingIn(AuthenticationRequest authenticationRequest) {
        try {
            if (authenticationRequest.equals(null)) {
                return new ResponseEntity<>("Username & Password not found", HttpStatus.BAD_REQUEST);
            }
            AdminEntity admin = adminRepository.findByUsername(authenticationRequest.getUsername());
            if (admin.equals(null)) {
                return new ResponseEntity<>("User name doesn't match", HttpStatus.UNAUTHORIZED);
            }
            if (passwordEncoder.matches(authenticationRequest.getPassword(), admin.getPassword())) {
                String token = generateToken(admin);
                if (token.equals(null)) {
                    return new ResponseEntity<>("Token not generated", HttpStatus.UNAUTHORIZED);
                }
                AdminSignInResponseDTO signInResponseDTO = new AdminSignInResponseDTO(
                        token,
                        admin.getUuid(),
                        admin.getUsername(),
                        LocalDate.now(),
                        LocalTime.now()
                );
                return new ResponseEntity<>(signInResponseDTO, HttpStatus.OK);
            }
            return new ResponseEntity<>("Invalid user credential", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private String generateToken(AdminEntity adminEntity) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + Role.ADMIN.toString()));
        return JwtGenerator.generateToken(adminEntity.getUsername(), adminEntity.getUuid(), authorities);
    }
}
