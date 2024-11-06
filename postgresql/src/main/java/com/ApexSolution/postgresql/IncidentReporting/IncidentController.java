package com.ApexSolution.postgresql.IncidentReporting;

import com.ApexSolution.postgresql.DataAccess.Entity.Incident;
import com.ApexSolution.postgresql.IncidentReporting.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @PostMapping("/addOrUpdateIncident")
    public ResponseEntity<Incident> addOrUpdateIncident(@RequestBody IncidentDTO incidentDTO) {
        Incident incident = incidentService.addOrUpdateIncident(incidentDTO);
        return ResponseEntity.ok(incident);
    }
}
