package com.example.demo.proj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Schedule {
    String time;
    String sport;
    String name;
    String homename;
    String awayname;
    String venue;
    String id;
    int autoId;
    String documentcode;
}
