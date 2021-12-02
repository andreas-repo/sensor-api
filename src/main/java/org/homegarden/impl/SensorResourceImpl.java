package org.homegarden.impl;

import org.homegarden.api.SensorResource;
import org.homegarden.model.Sensor;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

public class SensorResourceImpl implements SensorResource {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public Response getSensor(int id) {
        Sensor sensor = entityManager.find(Sensor.class, id);
        String result = null;
        Response response = null;
        if(sensor != null) {
            Jsonb jsonb = JsonbBuilder.create();
            result = jsonb.toJson(sensor);
            response = Response.ok(result).status(200).build();
        }else {
            response = Response.ok("Sensor doesnt exist.").status(204).build();
        }
        return response;
    }

    @Transactional
    @Override
    public Response setSensor(Sensor sensor) {
        Sensor foundSensor = entityManager.find(Sensor.class, sensor.getId());
        Response response = null;
        if (foundSensor == null) {
            entityManager.persist(sensor);
            response= Response.ok("New Sensor created.").status(201).build();
        } else {
            foundSensor.setSensorValue(sensor.getSensorValue());
            entityManager.persist(foundSensor);
            response= Response.ok("Sensor updated.").status(209).build();
        }
        return Response.ok().build();
    }
}
