package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private final RecipeRepository recipeRepository;
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.info("hello slf4j");
        Set<Recipe> recipeSet =new HashSet<>();
        recipeRepository.findAll().iterator().
                forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long Id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(Id);
        if (recipeOptional.isPresent())
            return recipeOptional.get();
        else
            return null;
    }
}
