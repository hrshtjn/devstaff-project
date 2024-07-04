# Spring Boot Application with Swagger Integration

This repository contains a Spring Boot application that integrates Swagger for API documentation.

## Prerequisites

- Java 17
- Maven or Gradle (depending on your build tool preference)
- IDE (IntelliJ IDEA, Eclipse, etc.)

## Getting Started

### Clone the Repository

Clone this repository to your local machine:

- git clone git@github.com:hrshtjn/devstaff-project.git
- cd devstaff-project

## To view Reports
- Open reportByCrop.html to view report by crop name
- Open reportByFarm.html to view report by farm name

- Please note: to modify query parameters, edit the respective html files.

## API Endpoints
- Planted Endpoint
- POST http://localhost:8080/api/planted: Submit planted data for a farm.

Sample request body-

{
  "name": "MyFarm",
  "field": {
    "name": "Field1"
  },
  "crop": {
    "name": "Potato"
  },
  "season": {
    "name": "Summer2023"
  },
  "plantingArea": 10,
  "expectedProduct": 20.0,
  "actualProduct": 0.0
}


- Harvested Endpoint
- POST http://localhost:8080/api/harvested: Submit harvested data for a farm.

{
  "name": "MyFarm",
  "field": {
    "name": "Field1"
  },
  "crop": {
    "name": "Potato"
  },
  "season": {
    "name": "Summer2023"
  },
  
  "actualProduct": 50.0
}


- Crop Reports Endpoint
GET http://localhost:8080/api/reports/crop?cropName=Corn&seasonName=Spring2023: Get crop reports for a specific crop and season.

- Farm Reports Endpoint
GET http://localhost:8080/api/reports/farm?name=MyFarm2&seasonName=Spring2023: Get farm reports for a specific farm and season.


