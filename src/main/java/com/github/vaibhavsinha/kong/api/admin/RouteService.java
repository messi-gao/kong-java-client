package com.github.vaibhavsinha.kong.api.admin;

import com.github.vaibhavsinha.kong.model.admin.route.Route;
import com.github.vaibhavsinha.kong.model.common.CommonList;

public interface RouteService {

    Route addRoute(Route route);
    void deleteRoute(String id);

    CommonList<Route> listRoutesByService(String id);
}