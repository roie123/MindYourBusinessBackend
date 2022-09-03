package com.example.CONTROLLERS;

import com.example.MODELS.Appointment;
import com.example.MODELS.Client;
import com.example.MODELS.Employee;
import com.example.MODELS.SomeService;
import com.example.SERVICES.AppointmentService;
import com.example.SERVICES.ClientService;
import com.example.SERVICES.EmployeeService;
import com.example.SERVICES.SomeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping(path = "/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final SomeServiceService someServiceService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, EmployeeService employeeService, ClientService clientService, EmployeeService employeeService1, SomeServiceService someServiceService) {
        this.appointmentService = appointmentService;
        this.clientService = clientService;
        this.employeeService = employeeService1;
        this.someServiceService = someServiceService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Appointment>> findAllAppointment(){
        List<Appointment> appointments =appointmentService.findAllAppointment();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PostMapping(path = "/add/{clientId}/{employeeId}/{someServiceId}")
        public ResponseEntity<Appointment> scheduleAppointment(@PathVariable("clientId") Long clientId,@PathVariable("employeeId") Long employeeId,@PathVariable("someServiceId") Long someServiceId){
        Appointment appointment1= new Appointment();
        Client client = clientService.findById(clientId);
        Employee employee =employeeService.findById(employeeId);
        SomeService someService=someServiceService.findById(someServiceId);
        appointment1.setClient(client);
        appointment1.setEmployee(employee);
        appointment1.setSomeService(someService);
        appointmentService.addAppointment(appointment1);
        return new ResponseEntity<>(appointment1,HttpStatus.CREATED);
    }

    @PostMapping(path = "/add_random")
    public ResponseEntity<Appointment> addRandomAppointment(){
        Appointment appointment =new Appointment();
        Random random =new Random();

        LocalDateTime localDateTime=LocalDateTime.now();
        appointment.setEmployee(employeeService.findRandomEmployee());
        appointment.setClient(clientService.findRandomClient());
        appointment.setSomeService(someServiceService.findRandomService());
        appointment.setLocalDateTime(localDateTime.plusDays(random.nextInt(3,45)).plusHours(random.nextInt(20))); //RANDOM DATE AND TIME
        appointmentService.addAppointment(appointment);
        return new ResponseEntity<Appointment>(appointment,HttpStatus.CREATED);
    }


    //TODO make a randomizer for appointments

}


















































