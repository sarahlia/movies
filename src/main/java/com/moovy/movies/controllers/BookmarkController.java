package com.moovy.movies.controllers;

import com.moovy.movies.models.Bookmark;
import com.moovy.movies.repository.BookmarksRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showCreateForm(Model model, @RequestParam(name = "imdbID") String imdbID,
                                 @RequestParam(name = "posterLink") String posterLink,
                                 @RequestParam (name = "title") String title,
                                 @RequestParam (name = "year") String year) {
        model.addAttribute("bookmark", new Bookmark());
        model.addAttribute("imdbID", imdbID);
        model.addAttribute("posterLink", posterLink);
        model.addAttribute("title", title);
        model.addAttribute("year", year);
        return "bookmarks/save";
    }

    @PostMapping("/bookmarks/save")
    public String create(@ModelAttribute Bookmark bookmarkToBeSaved) {
        Bookmark savedBookmark = bookmarksRepository.save(bookmarkToBeSaved);
        return "redirect:/dashboard";
    }

    @GetMapping("/bookmarks/{id}/delete")
    public String showDeleteForm(Model model, @PathVariable long id) {
        Bookmark bookmarkToDelete = bookmarksRepository.getOne(id);
        model.addAttribute("bookmark", bookmarkToDelete);
        return "bookmarks/delete";
    }

    @PostMapping("/bookmarks/{id}/delete")
    public String delete(@PathVariable long id) {
        bookmarksRepository.deleteById(id);
        return "redirect:/dashboard";
    }
}
