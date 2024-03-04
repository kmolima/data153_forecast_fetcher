/**
 * Locationforecast
 * Weather forecast for a specified place
 *
 * The version of the OpenAPI document: 2.0
 * Contact: weatherapi-adm@met.no
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package no.hvl.dat153.forecastfetcher.data;

import java.util.*;
import no.hvl.dat153.forecastfetcher.data.ForecastMeta;
import no.hvl.dat153.forecastfetcher.data.ForecastTimeStep;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Forecast {
  
  @SerializedName("meta")
  private ForecastMeta meta = null;
  @SerializedName("timeseries")
  private List<ForecastTimeStep> timeseries = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public ForecastMeta getMeta() {
    return meta;
  }
  public void setMeta(ForecastMeta meta) {
    this.meta = meta;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<ForecastTimeStep> getTimeseries() {
    return timeseries;
  }
  public void setTimeseries(List<ForecastTimeStep> timeseries) {
    this.timeseries = timeseries;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Forecast forecast = (Forecast) o;
    return (this.meta == null ? forecast.meta == null : this.meta.equals(forecast.meta)) &&
        (this.timeseries == null ? forecast.timeseries == null : this.timeseries.equals(forecast.timeseries));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.meta == null ? 0: this.meta.hashCode());
    result = 31 * result + (this.timeseries == null ? 0: this.timeseries.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Forecast {\n");
    
    sb.append("  meta: ").append(meta).append("\n");
    sb.append("  timeseries: ").append(timeseries).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
