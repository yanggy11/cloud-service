package com.yanggy.cloud.service;


import com.yang.cloud.dto.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by yangguiyun on 2017/10/18.
 */
public interface IDynamicTreeService {
    @PreAuthorize("hasAuthority('P_INDEX')")
    ResponseEntity<?> getAllTrees();
}
