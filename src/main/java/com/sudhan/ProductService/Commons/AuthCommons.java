package com.sudhan.ProductService.Commons;

import com.sudhan.ProductService.DTOs.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommons {
  private static RestTemplate restTemplate;

  public AuthCommons(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public static boolean validateToken(String tokenValue) {
    UserDto userDto =
        restTemplate.getForObject(
            "http://localhost:8080/users/validate/" + tokenValue, UserDto.class);
    if (userDto == null) {
      return false;
    }
    return true;
  }
}
