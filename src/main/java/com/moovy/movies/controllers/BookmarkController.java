package com.moovy.movies.controllers;

import com.moovy.movies.models.Bookmark;
import com.moovy.movies.repository.BookmarksRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookmarkController {

    private BookmarksRepository bookmarksRepository;

    public BookmarkController(BookmarksRepository bookmarksRepository) {
        this.bookmarksRepository = bookmarksRepository;
    }

    @GetMapping("/dashboard")
    public String bookmarksIndex(Model model) {
        List<Bookmark> bookmarksList = bookmarksRepository.findAll();
        model.addAttribute("bookmarks", bookmarksList);
        model.addAttribute("noBookmarksFound", bookmarksList.size()==0);
        return "index";
    }

    @GetMapping("/bookmarks/save")
    public String showCreateForm(Model model) {
        model.addAttribute("bookmark", new Bookmark());
        return "bookmarks/save";
    }

    @PostMapping("/bookmarks/save")
    public String create(@ModelAttribute Bookmark bookmarkToBeSaved) {
        Bookmark savedBookmark = bookmarksRepository.save(bookmarkToBeSaved);
        return "redirect:/dashboard";
    }
}
