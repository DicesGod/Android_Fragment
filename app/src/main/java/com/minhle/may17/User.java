package com.minhle.may17;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // @NonNull private long id;

    private String firstName;
    private String lastName;

}



