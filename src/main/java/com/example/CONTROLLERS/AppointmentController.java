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

    @PostMapping(path = "/add/{clientId}/{employeeId}/{someServiceId}/{hour}/{minute}/{day}/{month}/{year}")
        public ResponseEntity<Appointment> scheduleAppointment(@PathVariable("clientId") Long clientId,@PathVariable("employeeId") Long employeeId,@PathVariable("someServiceId") Long someServiceId,
        @PathVariable("hour") Long hour,@PathVariable("minute")Long minute,@PathVariable("day")Long day,@PathVariable("month")Long month,@PathVariable("year")Long year){
        Appointment appointment1= new Appointment();
        Client client = clientService.findById(clientId);
        Employee employee =employeeService.findById(employeeId);
        SomeService someService=someServiceService.findById(someServiceId);
        appointment1.setClient(client);
        appointment1.setEmployee(employee);
        appointment1.setSomeService(someService);
        try {
            appointment1.setLocalDateTime(LocalDateTime.of(Math.toIntExact(year), Math.toIntExact(month), Math.toIntExact(day), Math.toIntExact(hour), Math.toIntExact(minute)));

        }catch (Exception e){
            return new ResponseEntity<Appointment>(HttpStatus.BAD_REQUEST);
        }
        appointmentService.addAppointment(appointment1);
        return new ResponseEntity<>(appointment1,HttpStatus.CREATED);
    }
//TODO => make the "add" request to be from names, add a query for finding by name with an exeption, maybe only on the employee and not on the client ? to make it more dynamic by not adding every single client.

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

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable("id") Long id){
        this.appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PutMapping(path = "/update")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
        Appointment appointment1 = appointmentService.updateAppointment(appointment);
        return new ResponseEntity<>(appointment1, HttpStatus.OK);
    }

    @PutMapping(path = "/completed_appointment/{id}")
    public ResponseEntity<Appointment> completedAppointment(@PathVariable("id") Long id){
        Appointment appointment=appointmentService.findById(id);
        appointment.setCompleted(true);
        appointmentService.updateAppointment(appointment);
        return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
    }


}


















































