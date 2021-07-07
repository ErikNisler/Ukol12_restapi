package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class SpringController {


    /*@GetMapping("api/vehicles")
    public String getVehicles(@RequestParam(required = false) Integer page){
        return "Strana "+page;
    }*/

    /**Get vehicle*/
    @GetMapping("api/vehicle/{vehicleId}")
    public String getVehicleById(@PathVariable Integer vehicleId){
        return "Vehicle ID "+vehicleId;
    }

    /**Update vehicle*/
    @PutMapping("api/vehicle/{vehicleId}")
    public Vehicle updateVehicleById(@PathVariable Integer vehicleId, @RequestBody Vehicle vehicle){
        return vehicle;
    }

    /**Delaying*/
    @GetMapping("api/vehicle")
    public String getVehicleDelayed(@RequestParam Integer delay) {
        Vehicle vehicle = new Vehicle();
        try {
            Thread.sleep(delay * 1000);
            vehicle.setModel("Škoda");
            vehicle.setBrand("Fabia");
            return vehicle.toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return vehicle.toString();
    }

    @PostMapping("api/vehicles")
    public Vehicle postVehicle(@RequestBody Vehicle vehicle){
        return vehicle;
    }
}
