package com.killpekeinside.util;

import lombok.Data;

/**
 * Created by catmo_000 on 9/6/2015.
 */
@Data
public class Pair<F,S> {
    final F first;
    final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
}
