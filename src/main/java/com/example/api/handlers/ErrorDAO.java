package com.example.api.handlers;


import com.example.api.exceptions.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDAO {
    private Integer httpCode;
    private ErrorCodes codes;
    private  String message;
    private List<String> error=new ArrayList<>();
}
