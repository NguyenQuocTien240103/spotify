package com.project.stayfinder.service;

import com.project.stayfinder.entity.Guest;
import com.project.stayfinder.exception.AppException;
import com.project.stayfinder.exception.Error;
import com.project.stayfinder.mapper.AccountMapper;
import com.project.stayfinder.payload.request.CreateAccountRequest;
import com.project.stayfinder.payload.request.UpdateAccountRequest;
import com.project.stayfinder.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuestService {
    private final GuestRepository guestRepository;
    private final AccountMapper accountMapper;

    public List<Guest> getAll() {
        return guestRepository.findAll();
    }

    public Guest createAccount(CreateAccountRequest request) {
        if (guestRepository.existsByEmail(request.getEmail()))
            throw new AppException(Error.EMAIL_EXISTED);
        Guest guest = accountMapper.toGuest(request);
        return guestRepository.save(guest);
    }

    public Guest updateAccount(String id, UpdateAccountRequest request) {
        Guest guest = guestRepository.findById(id).orElseThrow(()->new AppException(Error.USER_NOT_FOUND));
        accountMapper.toGuest(guest, request);
        return guestRepository.save(guest);
    }

    public void deleteAccount(String id) {
        guestRepository.delete(guestRepository.findById(id).orElseThrow(()->new AppException(Error.USER_NOT_FOUND)));
    }
}
