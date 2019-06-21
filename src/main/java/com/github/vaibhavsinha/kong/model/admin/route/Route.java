package com.github.vaibhavsinha.kong.model.admin.route;

import java.util.List;

import com.github.vaibhavsinha.kong.model.admin.service.Service;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Route {

    private String id;
    private List<String> protocols;
    private List<String> methods;
    private List<String> hosts;
    private List<String> paths;
    @SerializedName("strip_path")
    private Boolean stripPath;
    @SerializedName("preserve_host")
    private Boolean preserveHost;
    private Service service;
    @SerializedName("created_at")
    private Long createdAt;
    @SerializedName("updated_at")
    private Long updatedAt;
}