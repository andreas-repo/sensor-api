# sensor-api project

Sensor API which receives post requests in json format from four ESP32 microcontrollers. The requests contain the id of the sensor/esp32 and the actual humidity value of the earth. The request data gets sent to a H2 or mariadb database where the data gets saved including a timestamp. The API also responds with the database data of a sensor if you send a GET request + sensor id.

## API endpoints
GET http://{hostname}}:8080/sensor/{id}}  <= responds with the sensor value
POST http://{{hostname}}:8080/sensor/  => receives sensor data and saves the data in the database including a timestamp

