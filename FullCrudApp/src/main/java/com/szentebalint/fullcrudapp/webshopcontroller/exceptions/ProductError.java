package com.szentebalint.fullcrudapp.webshopcontroller.exceptions;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductError {

    private int status;

    private String message;

    private long timeStamp;

}
