package sp.config;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @GetMapping("/")
  public String index(Authentication authentication) {
    org.apache.commons.ssl.TrustMaterial t=null;
    return authentication == null ? "index" : "redirect:/user.html";
  }

  @GetMapping({"user", "/user.html"})
  public String user(Authentication authentication, ModelMap modelMap) {
    modelMap.addAttribute("user", authentication.getPrincipal());
    return "user";
  }

}
