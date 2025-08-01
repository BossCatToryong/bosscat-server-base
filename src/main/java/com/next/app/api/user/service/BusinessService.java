package com.next.app.api.user.service;


import com.next.app.api.user.entity.Business;
import com.next.app.api.user.repository.BusinessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BusinessService {
    // 상품 전체 조회
    public List<Business> getAllBusinesss() {
        return BusinessRepository.findAll();
    }
    // 상품 단건 조회
    public Business getBusinessById(Long id) {
        return BusinessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found with id: " + id));
    }
    // 상품 생성
    public Business createBusiness(Business Business) {
        return BusinessRepository.save(Business);
    }
    // 상품 수정
    public Business updateBusiness(Long id, Business updatedBusiness) {
        Business Business = BusinessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found with id: " + id));
        Business.setName(updatedBusiness.getName());
        Business.setPrice(updatedBusiness.getPrice());
        Business.setDescription(updatedBusiness.getDescription());
        return BusinessRepository.save(Business);
    }
    // 상품 삭제
    public void deleteBusiness(Long id) {
        BusinessRepository.deleteById(id);
    }


    @Autowired
    private BusinessRepository BusinessRepository;




}




