package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeListController {
    private RecipeService recipeService;

    @Autowired
    public RecipeListController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"recipe","recipea"})
    public String getRecipe(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipe";
    }
}
