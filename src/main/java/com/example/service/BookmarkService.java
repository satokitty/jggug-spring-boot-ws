/*
 * Copyright (c) 2014. satokitty
 *
 * Licensed under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package com.example.service;

import com.example.domain.Bookmark;
import com.example.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookmarkService {
    @Autowired
    BookmarkRepository bookmarkRepository;

    public List<Bookmark> findAll() {
        return bookmarkRepository.findAll();
    }

    public Bookmark save(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }

    public void delete(Long id) {
        bookmarkRepository.delete(id);
    }
}
