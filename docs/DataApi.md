# DataApi

All URIs are relative to *http://localhost/weatherapi/locationforecast/2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**classicFormatGet**](DataApi.md#classicFormatGet) | **GET** /classic.{format} | 
[**classicGet**](DataApi.md#classicGet) | **GET** /classic | 
[**compactFormatGet**](DataApi.md#compactFormatGet) | **GET** /compact.{format} | 
[**compactGet**](DataApi.md#compactGet) | **GET** /compact | 
[**completeFormatGet**](DataApi.md#completeFormatGet) | **GET** /complete.{format} | 
[**completeGet**](DataApi.md#completeGet) | **GET** /complete | 
[**statusFormatGet**](DataApi.md#statusFormatGet) | **GET** /status.{format} | 
[**statusGet**](DataApi.md#statusGet) | **GET** /status | 



## classicFormatGet

> String classicFormatGet(lat, lon, format, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:
//import no.hvl.dat153.forecastfetcher.rest.DataApi;

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
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude | [default to null]
 **lon** | **Float**| Longitude | [default to null]
 **format** | **String**| format code (file extension) | [default to null] [enum: xml]
 **altitude** | **Integer**| Whole meters above sea level | [optional] [default to null]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/xml


## classicGet

> String classicGet(lat, lon, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:
//import no.hvl.dat153.forecastfetcher.rest.DataApi;

DataApi apiInstance = new DataApi();
Float lat = null; // Float | Latitude
Float lon = null; // Float | Longitude
Integer altitude = null; // Integer | Whole meters above sea level
try {
    String result = apiInstance.classicGet(lat, lon, altitude);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DataApi#classicGet");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude | [default to null]
 **lon** | **Float**| Longitude | [default to null]
 **altitude** | **Integer**| Whole meters above sea level | [optional] [default to null]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/xml


## compactFormatGet

> METJSONForecast compactFormatGet(lat, lon, format, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:
//import no.hvl.dat153.forecastfetcher.rest.DataApi;

DataApi apiInstance = new DataApi();
Float lat = null; // Float | Latitude
Float lon = null; // Float | Longitude
String format = null; // String | format code (file extension)
Integer altitude = null; // Integer | Whole meters above sea level
try {
    METJSONForecast result = apiInstance.compactFormatGet(lat, lon, format, altitude);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DataApi#compactFormatGet");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude | [default to null]
 **lon** | **Float**| Longitude | [default to null]
 **format** | **String**| format code (file extension) | [default to null] [enum: json]
 **altitude** | **Integer**| Whole meters above sea level | [optional] [default to null]

### Return type

[**METJSONForecast**](METJSONForecast.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8


## compactGet

> METJSONForecast compactGet(lat, lon, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:
//import no.hvl.dat153.forecastfetcher.rest.DataApi;

DataApi apiInstance = new DataApi();
Float lat = null; // Float | Latitude
Float lon = null; // Float | Longitude
Integer altitude = null; // Integer | Whole meters above sea level
try {
    METJSONForecast result = apiInstance.compactGet(lat, lon, altitude);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DataApi#compactGet");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude | [default to null]
 **lon** | **Float**| Longitude | [default to null]
 **altitude** | **Integer**| Whole meters above sea level | [optional] [default to null]

### Return type

[**METJSONForecast**](METJSONForecast.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8


## completeFormatGet

> METJSONForecast completeFormatGet(lat, lon, format, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:
//import no.hvl.dat153.forecastfetcher.rest.DataApi;

DataApi apiInstance = new DataApi();
Float lat = null; // Float | Latitude
Float lon = null; // Float | Longitude
String format = null; // String | format code (file extension)
Integer altitude = null; // Integer | Whole meters above sea level
try {
    METJSONForecast result = apiInstance.completeFormatGet(lat, lon, format, altitude);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DataApi#completeFormatGet");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude | [default to null]
 **lon** | **Float**| Longitude | [default to null]
 **format** | **String**| format code (file extension) | [default to null] [enum: json]
 **altitude** | **Integer**| Whole meters above sea level | [optional] [default to null]

### Return type

[**METJSONForecast**](METJSONForecast.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8


## completeGet

> METJSONForecast completeGet(lat, lon, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:
//import no.hvl.dat153.forecastfetcher.rest.DataApi;

DataApi apiInstance = new DataApi();
Float lat = null; // Float | Latitude
Float lon = null; // Float | Longitude
Integer altitude = null; // Integer | Whole meters above sea level
try {
    METJSONForecast result = apiInstance.completeGet(lat, lon, altitude);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DataApi#completeGet");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude | [default to null]
 **lon** | **Float**| Longitude | [default to null]
 **altitude** | **Integer**| Whole meters above sea level | [optional] [default to null]

### Return type

[**METJSONForecast**](METJSONForecast.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8


## statusFormatGet

> String statusFormatGet(format)



Weather forecast for a specified place

### Example

```java
// Import classes:
//import no.hvl.dat153.forecastfetcher.rest.DataApi;

DataApi apiInstance = new DataApi();
String format = null; // String | format code (file extension)
try {
    String result = apiInstance.statusFormatGet(format);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DataApi#statusFormatGet");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **format** | **String**| format code (file extension) | [default to null] [enum: json]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8


## statusGet

> String statusGet()



Weather forecast for a specified place

### Example

```java
// Import classes:
//import no.hvl.dat153.forecastfetcher.rest.DataApi;

DataApi apiInstance = new DataApi();
try {
    String result = apiInstance.statusGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DataApi#statusGet");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8

