package com.github.vaibhavsinha.kong;

import java.util.ArrayList;
import java.util.List;

import com.github.vaibhavsinha.kong.model.admin.route.Route;
import com.github.vaibhavsinha.kong.model.admin.service.Service;
import com.github.vaibhavsinha.kong.model.common.CommonList;
import org.junit.Test;

public class ServiceRouteTest extends BaseTest {

    public static final String EXAMPLE_SERVICE = "kong-java-client-test-service";

    @Test
    public void createServiceAndRouteTest() {
        // 新建Service和Route
        Service service = Service.builder().url("http://mockbin.org").name(EXAMPLE_SERVICE).build();
        Service response4service = kongClient.getServiceService().addService(service);
        printJson(response4service);
        List<String> hostList = new ArrayList<>();
        hostList.add("example.com");
        Route route = Route.builder().hosts(hostList).service(Service.builder().id(response4service.getId()).build()).build();
        Route response4route = kongClient.getRouteService().addRoute(route);
        printJson(response4route);
    }

    @Test
    public void deleteServiceAndRouteTest() {
        // 删除Route和Service
        CommonList<Route> commonList = kongClient.getRouteService().listRoutesByService(EXAMPLE_SERVICE);
        List<Route> routeList = commonList.getData();
        if (null != routeList && routeList.size() > 0) {
            for (Route route : routeList) {
                kongClient.getRouteService().deleteRoute(route.getId());
            }
        }
        kongClient.getServiceService().deleteService(EXAMPLE_SERVICE);
    }

    @Test
    public void getServiceAndRouteTest() {
        // 获取
        CommonList<Route> commonList = kongClient.getRouteService().listRoutesByService(EXAMPLE_SERVICE);
        List<Route> routeList = commonList.getData();
        if (null != routeList && routeList.size() > 0) {
            for (Route route : routeList) {
                System.out.println(route);
            }

        }
    }
}