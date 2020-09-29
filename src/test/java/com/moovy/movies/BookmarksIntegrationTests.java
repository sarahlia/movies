package com.moovy.movies;

import com.moovy.movies.models.Bookmark;
import com.moovy.movies.repository.BookmarksRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoviesApplication.class)
@AutoConfigureMockMvc
public class BookmarksIntegrationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    BookmarksRepository bookmarksRepository;

    @Test
    public void contextLoads() {
        assertNotNull(mvc);
    }

    @Test
    public void testCreateBookmark() throws Exception {
        this.mvc.perform(
                post("/bookmarks/save").with(csrf())
                .param("title", "Mock Movie")
                .param("year", "3000")
                .param("imdbID", "tt0123456")
                .param("posterLink", "https://images.pexels.com/photos/2873486/pexels-photo-2873486.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testBookmarksIndex() throws Exception {
        Bookmark existingBookmark = bookmarksRepository.findAll().get(0);

        this.mvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("favorite")))
                .andExpect(content().string(containsString(existingBookmark.getTitle())));

    }

    @Test
    public void testDeleteBookmark() throws Exception {
        this.mvc.perform(
                post("/bookmarks/save").with(csrf())
                .param("title", "Movie to Delete")
                .param("year", "9999")
                .param("imdbID", "tt7654321"))
            .andExpect(status().is3xxRedirection());

        Bookmark bookmarkToDelete = bookmarksRepository.findByTitle("Movie to Delete");

        this.mvc.perform(
                post("/bookmarks/" + bookmarkToDelete.getId() + "/delete").with(csrf())
                    .param("id", String.valueOf(bookmarkToDelete.getId())))
                .andExpect(status().is3xxRedirection());

    }

}
