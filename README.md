# conductor-with-spring-boot
Conductor workflow with spring boot

To run the project, the cab booking workflow needs to be loaded onto the Conductor server. The workflow configuration can be found in

``
resource/workflow/cab_service_booking_wf.json
``

### Starting the Cab Booking Workflow

To start the cab booking workflow, you need to send the following HTTP request to the Conductor server.

##### HTTP Request

``` http request
POST http://localhost:8081/api/v1/cab
Content-Type: application/json

{
  "pickUpLocation": "KTM",
  "dropOffLocation": "BKT",
  "riderId": "123"
}

```