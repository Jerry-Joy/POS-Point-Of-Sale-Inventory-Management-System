package com.elira.pos.service;

import com.elira.pos.exceptions.UserException;
import com.elira.pos.modal.User;
import com.elira.pos.payload.dto.BranchDTO;

import java.util.List;

public interface BranchService {

    BranchDTO createBranch(BranchDTO branchDTO, User user) throws UserException;
    BranchDTO updateBranch(Long id, BranchDTO branchDTO, User user) throws Exception;
    void deleteBranch(Long id) throws Exception;
    List<BranchDTO> getAllBranchesByStoreId(Long storeId);
    BranchDTO getBranchById(Long id) throws Exception;
}
