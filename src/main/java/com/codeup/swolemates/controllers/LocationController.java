package com.codeup.swolemates.controllers;


import com.codeup.swolemates.dao.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class LocationController {
        private final LocationRepository locationDao;

        @Autowired
        public LocationController(LocationRepository locationDao) {
            this.locationDao = locationDao;
        }
    }

//    var unirest = require("unirest");
//
//    var req = unirest("GET", "https://redline-redline-zipcode.p.rapidapi.com/rest/multi-info.json/08057%252C08055/degrees");
//
//    private var unirest(String get, String s) {
//    }
//
//req.headers({
//        "x-rapidapi-host": "redline-redline-zipcode.p.rapidapi.com",
//                "x-rapidapi-key": "SIGN-UP-FOR-KEY"
//    });
//
//
//req.end(function (res) {
//        if (res.error) throw new Error(res.error);
//
//        console.log(res.body);
//    });
//}
