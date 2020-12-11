# notification

Problem Statement 
Most applications have the need to implement notifications for a variety of use cases and
scenarios. Create a centralized generic service for notification that can be used by a variety
consuming application for their notification needs e.g. an incident workflow system may use
this system when each incident ticket moves from one state to another, similarly a order
management system may use this service to notify the customer of the status of the order
whenever it changes.

The system should allow for the following capabilities: 
 
1. Accept messages including from, to and subject 
2. Ability to notify on multiple channels (e.g email, slack, you can stub out/mock if
required) 
3. Deliver messages in correct order for each consumer of this



# Tech Stack:

* JDK 11 or Higher
* Spring Boot
* Apache Camel

# Tools Used

* Rabbit MQ
* Slack
* Spring Source Tool Suite

# SetUp

1. Download and install rabbit mq server 
2. Download and install Spring Source tool suite
3. Download and install slack 

