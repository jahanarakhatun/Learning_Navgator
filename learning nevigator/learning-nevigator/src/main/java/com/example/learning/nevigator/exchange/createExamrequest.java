package com.example.learning.nevigator.exchange;

import io.micrometer.common.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class createExamrequest {
    @NonNull
    private long subjectId;

}
