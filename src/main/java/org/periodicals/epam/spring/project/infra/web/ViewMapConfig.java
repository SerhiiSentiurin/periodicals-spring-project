package org.periodicals.epam.spring.project.infra.web;

import org.periodicals.epam.spring.project.logic.entity.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class ViewMapConfig {

    private final Map<UserRole, String> mapView;

    public ViewMapConfig(Map<UserRole, String> mapView1){
        mapView1=Map.of(UserRole.ADMIN, "/app/admin/adminHome.jsp", UserRole.READER, "/app/reader/readerHome.jsp");
        this.mapView= mapView1;
    }

    public String get(UserRole userRole) {
        return mapView.get(userRole);
    }

//    @Bean
//    public Map<UserRole,String> setViewMap(Map<UserRole, String> mapView){
//        mapView = Map.of(UserRole.ADMIN, "/app/admin/adminHome.jsp", UserRole.READER, "/app/reader/readerHome.jsp");
//    return mapView;
//    }
}
