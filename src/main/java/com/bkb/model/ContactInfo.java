package com.bkb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String adress;
    private String plz;
    private String ort;
    private String birthday;


} 