/*
 * Copyright (c) 2014. satokitty
 *
 * Licensed under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package com.example.api;

import com.example.domain.Bookmark;
import com.example.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/bookmarks")
public class BookmarkRestController {
    @Autowired
    BookmarkService bookmarkService;

    @RequestMapping(method = RequestMethod.GET)
    List<Bookmark> getBookmarks() {
        return bookmarkService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Bookmark postBookmarks(@Validated @RequestBody Bookmark bookmark) {
        return bookmarkService.save(bookmark);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBookmarks(@PathVariable("id") Long id) {
        bookmarkService.delete(id);
    }
}
