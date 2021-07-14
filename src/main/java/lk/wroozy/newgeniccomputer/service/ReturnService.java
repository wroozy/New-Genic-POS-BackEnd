package lk.wroozy.newgeniccomputer.service;

import lk.wroozy.newgeniccomputer.dto.request.ReturnRequestDTO;
import lk.wroozy.newgeniccomputer.entity.ReturnEntity;
import org.springframework.http.ResponseEntity;

public interface ReturnService {

    ResponseEntity<?> placeReturn(ReturnRequestDTO returnRequestDTO);

    ResponseEntity<?> getAllReturns();

    ResponseEntity<?> getReturn(long returnId);

}
