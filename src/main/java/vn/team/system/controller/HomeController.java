package vn.team.system.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vn.team.system.repository.UserRepo;

@RestController
@RequiredArgsConstructor
public class HomeController {

  private final UserRepo userRepo;
  private final Gson gson;

  @GetMapping(value = "home")
  @ResponseBody
  public String display() {
    return gson.toJson(userRepo.getAll());
  }
}
