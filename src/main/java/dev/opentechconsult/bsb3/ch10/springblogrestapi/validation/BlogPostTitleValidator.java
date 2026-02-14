package dev.opentechconsult.bsb3.ch10.springblogrestapi.validation;

import org.thymeleaf.util.StringUtils;

import dev.opentechconsult.bsb3.ch10.springblogrestapi.dto.PostDto;
import dev.opentechconsult.bsb3.ch10.springblogrestapi.service.PostService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public record BlogPostTitleValidator(PostService postService) 
implements ConstraintValidator<BlogPostTitleAlreadyExists, PostDto> {

    @Override
    public void initialize(BlogPostTitleAlreadyExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PostDto post, ConstraintValidatorContext context) {
        if (!StringUtils.isEmpty(post.getTitle()) && postService.postExistsWithTitle(post.getTitle())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{TitleAlreadyExists}")
                    .addPropertyNode("title")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}
