package vn.team.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.team.system.common.info.RestfulCommonResponse;
import vn.team.system.service.intface.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
public class HomeController {

  private final UserService userService;

  @GetMapping(value = "home")
  public RestfulCommonResponse display() {
    return userService.fetchAll();
  }
}
