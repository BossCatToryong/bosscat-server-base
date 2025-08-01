package com.next.app.api.user.controller;


import com.next.app.api.user.entity.Business;
import com.next.app.api.user.service.BusinessService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Businesss")
@Tag(name = "Business Controller", description = "상품 관리 API")
@CrossOrigin(origins = "http://localhost:3000")
public class BusinessController {

    private final BusinessService BusinessService;

    public BusinessController(BusinessService BusinessService) {
        this.BusinessService = BusinessService;
    }

    @GetMapping
    public List<Business> getAllBusinesss() {
        return BusinessService.getAllBusinesss();
    }
    @GetMapping("/{id}")
    public Business getBusinessById(@PathVariable Long id) {
        return BusinessService.getBusinessById(id);
    }
    @PostMapping
    public Business createBusiness(@RequestBody Business Business) {
        return BusinessService.createBusiness(Business);
    }
    @PutMapping("/{id}")
    public Business updateBusiness(@PathVariable Long id, @RequestBody Business Business) {
        return BusinessService.updateBusiness(id, Business);
    }
    @DeleteMapping("/{id}")
    public void deleteBusiness(@PathVariable Long id) {
        BusinessService.deleteBusiness(id);
    }
}