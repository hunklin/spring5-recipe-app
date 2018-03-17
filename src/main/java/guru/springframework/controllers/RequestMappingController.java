package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//== @Controller @ResponseBody
@RequestMapping("/home")
public class RequestMappingController {
    @RequestMapping({"MultiValues", "MultiValues2"})
    String getTest() {
        return "URI:localhost:8080/home/MultiValues2";
    }

    @GetMapping("/getTest")
    //== @RequestMapping(value = "/getTest", method = RequestMethod.GET)
    String getIDByValue(@RequestParam(value = "id", required = false) String id) {
        return "URI:localhost:8080/home/getTest?id=" + id;
    }

    @RequestMapping("/fetch/{id:\\d}/{name}")
    String getDynamicUriValueRegex(
            @PathVariable("id") String id,
            @PathVariable("name") String name) {
        return "URI:localhost:8080/home/fetch/" + id + "/" + name;
    }
}
