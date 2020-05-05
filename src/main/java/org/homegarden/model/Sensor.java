package org.homegarden.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "sensor")
public class Sensor implements Serializable {
    @JsonbProperty("id")
    private int id;
    private Date timestamp;
@JsonbProperty("sensorValue")
    private int sensorValue;

    @ManyToOne
    private SensorGroup sensorGroup;

    public Sensor() {
        this.timestamp = new Date();
    }
    public Sensor(int id) {
        this.id = id;
        this.timestamp = new Date();
    }
    public Sensor(int id, int sensorValue) {
        this.id = id;
        this.timestamp = new Date();
        this.sensorValue = sensorValue;
    }

    @Id
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getSensorValue() {
        return this.sensorValue;
    }

    public void setSensorValue(int sensorValue) {
        this.sensorValue = sensorValue;
    }


    public SensorGroup getSensorGroup() {
        return this.sensorGroup;
    }

    public void setSensorGroup(SensorGroup sensorGroup) {
        this.sensorGroup = sensorGroup;
    }
}
