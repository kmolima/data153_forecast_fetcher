# openapi-android-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-android-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.openapitools:openapi-android-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

- target/openapi-android-client-1.0.0.jar
- target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import no.hvl.dat153.forecastfetcher.rest.DataApi;

public class DataApiExample {

    public static void main(String[] args) {
        DataApi apiInstance = new DataApi();
        Float lat = null; // Float | Latitude
        Float lon = null; // Float | Longitude
        String format = null; // String | format code (file extension)
        Integer altitude = null; // Integer | Whole meters above sea level
        try {
            String result = apiInstance.classicFormatGet(lat, lon, format, altitude);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataApi#classicFormatGet");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost/weatherapi/locationforecast/2.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DataApi* | [**classicFormatGet**](docs/DataApi.md#classicFormatGet) | **GET** /classic.{format} | 
*DataApi* | [**classicGet**](docs/DataApi.md#classicGet) | **GET** /classic | 
*DataApi* | [**compactFormatGet**](docs/DataApi.md#compactFormatGet) | **GET** /compact.{format} | 
*DataApi* | [**compactGet**](docs/DataApi.md#compactGet) | **GET** /compact | 
*DataApi* | [**completeFormatGet**](docs/DataApi.md#completeFormatGet) | **GET** /complete.{format} | 
*DataApi* | [**completeGet**](docs/DataApi.md#completeGet) | **GET** /complete | 
*DataApi* | [**statusFormatGet**](docs/DataApi.md#statusFormatGet) | **GET** /status.{format} | 
*DataApi* | [**statusGet**](docs/DataApi.md#statusGet) | **GET** /status | 
*MetadataApi* | [**changelogGet**](docs/MetadataApi.md#changelogGet) | **GET** /changelog | 
*MetadataApi* | [**healthzGet**](docs/MetadataApi.md#healthzGet) | **GET** /healthz | 
*MetadataApi* | [**schemaGet**](docs/MetadataApi.md#schemaGet) | **GET** /schema | 


## Documentation for Models

 - [Forecast](docs/Forecast.md)
 - [ForecastMeta](docs/ForecastMeta.md)
 - [ForecastSummary](docs/ForecastSummary.md)
 - [ForecastTimeInstant](docs/ForecastTimeInstant.md)
 - [ForecastTimePeriod](docs/ForecastTimePeriod.md)
 - [ForecastTimeStep](docs/ForecastTimeStep.md)
 - [ForecastTimeStepData](docs/ForecastTimeStepData.md)
 - [ForecastTimeStepDataInstant](docs/ForecastTimeStepDataInstant.md)
 - [ForecastTimeStepDataNext12Hours](docs/ForecastTimeStepDataNext12Hours.md)
 - [ForecastTimeStepDataNext1Hours](docs/ForecastTimeStepDataNext1Hours.md)
 - [ForecastTimeStepDataNext6Hours](docs/ForecastTimeStepDataNext6Hours.md)
 - [ForecastUnits](docs/ForecastUnits.md)
 - [METJSONForecast](docs/METJSONForecast.md)
 - [PointGeometry](docs/PointGeometry.md)
 - [WeatherSymbol](docs/WeatherSymbol.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

weatherapi-adm@met.no

