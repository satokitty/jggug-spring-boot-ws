/*
 * Copyright (c) 2014. satokitty
 *
 * Licensed under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package com.example.domain;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Bookmark {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 0, max = 255)
    private String name;

    @NotNull
    @Size(min = 0, max = 255)
    @URL
    private String url;
}
