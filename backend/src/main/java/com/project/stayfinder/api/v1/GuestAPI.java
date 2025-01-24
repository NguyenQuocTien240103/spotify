package com.project.stayfinder.api.v1;

import com.project.stayfinder.entity.Guest;
import com.project.stayfinder.payload.request.CreateAccountRequest;
import com.project.stayfinder.payload.request.UpdateAccountRequest;
import com.project.stayfinder.service.GuestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guests")
public class GuestAPI {
    private final GuestService guestService;

    @GetMapping
    ResponseEntity<List<Guest>> getAllGuests() {
        return ResponseEntity.ok(guestService.getAll());
    }

    @PostMapping
    ResponseEntity<Guest> createGuest(@RequestBody @Valid CreateAccountRequest request) {
        return ResponseEntity.ok(guestService.createAccount(request));
    }

    @PutMapping("/{id}")
    ResponseEntity<Guest> updateGuest(@RequestBody @Valid UpdateAccountRequest request, @PathVariable String id) {
        return ResponseEntity.ok(guestService.updateAccount(id, request));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteGuest(@PathVariable String id) {
        guestService.deleteAccount(id);
        return ResponseEntity.ok("Deleted account: " + id);
    }
}
