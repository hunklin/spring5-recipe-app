package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import guru.springframework.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeControllerTest {
    RecipeController recipeController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipeService);
    }

    @Test
    public void getRecipes() throws Exception{

        String a = "recipes";

        HashSet<Recipe> recipes = new HashSet<>();
        when(model.addAttribute(a, recipes)).thenReturn(model);
        when(recipeService.getRecipes()).thenReturn(recipes);

        String returnValue = recipeController.getRecipe(model);
        assertEquals(returnValue, "recipe");
        verify(model, times(1)).addAttribute(a, recipes);
        verify(recipeService, times(1)).getRecipes();
    }
}