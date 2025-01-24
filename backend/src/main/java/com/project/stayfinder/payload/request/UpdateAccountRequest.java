package com.project.stayfinder.payload.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateAccountRequest {
    String email;
    @Size(min = 6, message = "Password must be at least 6 characters")
    String password;
    String fullName;
    String avatarPath;
}
