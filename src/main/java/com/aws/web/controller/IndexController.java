package com.aws.web.controller;

import com.aws.config.auth.LoginUser;
import com.aws.config.auth.dto.SessionUser;
import com.aws.service.posts.PostsService;
import com.aws.web.dto.PostsResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController
{
    private final PostsService postsService;


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null)
        {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }


    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
    }


    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model)
    {
        PostsResponseDTO dto = postsService.findById(id);

        model.addAttribute("post", dto);

        return "posts-update";
    }



}
