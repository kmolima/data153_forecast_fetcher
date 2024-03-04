# MetadataApi

All URIs are relative to *http://localhost/weatherapi/locationforecast/2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**changelogGet**](MetadataApi.md#changelogGet) | **GET** /changelog | 
[**healthzGet**](MetadataApi.md#healthzGet) | **GET** /healthz | 
[**schemaGet**](MetadataApi.md#schemaGet) | **GET** /schema | 



## changelogGet

> changelogGet()



RSS feed of changes to this product

### Example

```java
// Import classes:
//import no.hvl.dat153.forecastfetcher.rest.MetadataApi;

MetadataApi apiInstance = new MetadataApi();
try {
    apiInstance.changelogGet();
} catch (ApiException e) {
    System.err.println("Exception when calling MetadataApi#changelogGet");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## healthzGet

> healthzGet()



Check health status for product

### Example

```java
// Import classes:
//import no.hvl.dat153.forecastfetcher.rest.MetadataApi;

MetadataApi apiInstance = new MetadataApi();
try {
    apiInstance.healthzGet();
} catch (ApiException e) {
    System.err.println("Exception when calling MetadataApi#healthzGet");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## schemaGet

> schemaGet()



Schema for XML data

### Example

```java
// Import classes:
//import no.hvl.dat153.forecastfetcher.rest.MetadataApi;

MetadataApi apiInstance = new MetadataApi();
try {
    apiInstance.schemaGet();
} catch (ApiException e) {
    System.err.println("Exception when calling MetadataApi#schemaGet");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

