package com.github.vaibhavsinha.kong.model.common;

import java.util.List;

import lombok.Data;

/**
 * @author yihe.gao
 */
@Data
public class CommonList<T> {
    List<T> data;
}
