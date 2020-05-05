package org.homegarden.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

@Entity(name = "sensorgroup")
public class SensorGroup implements Serializable {

    private int idOfTent;
    private Collection<Sensor> sensorCollection;

    private SensorGroup sensorGroup;

    public SensorGroup() {
        this.sensorCollection = new HashSet<>();
    }

    public SensorGroup(int idOfTent) {
        this.sensorCollection = new HashSet<>();
        this.idOfTent = idOfTent;
    }

    @Id
    public int getIdOfTent() {
        return this.idOfTent;
    }

    public void setIdOfTent(int idOfTent) {
        this.idOfTent = idOfTent;
    }

    @OneToMany(mappedBy = "sensorGroup")
    public Collection<Sensor> getSensorCollection() {
        return this.sensorCollection;
    }

    public void setSensorCollection(Collection<Sensor> sensorCollection) {
        this.sensorCollection = sensorCollection;
    }

    @ManyToOne
    public SensorGroup getSensorGroup() {
        return this.sensorGroup;
    }

    public void setSensorGroup(SensorGroup sensorGroup) {
        this.sensorGroup = sensorGroup;
    }

    public void addSensor(Sensor sensor) {
        this.sensorCollection.add(sensor);
    }
}
