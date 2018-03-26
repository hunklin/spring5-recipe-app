package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class RecipeController {
    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/show/{id:\\d}")
    public String getRecipe(@PathVariable("id") String id,
                            Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        log.info("d = " + recipeService.findById(new Long(id)).getDescription());
        return "recipe/show";
    }

}
