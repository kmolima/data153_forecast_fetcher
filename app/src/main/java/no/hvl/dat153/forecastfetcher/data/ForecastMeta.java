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

import no.hvl.dat153.forecastfetcher.data.ForecastUnits;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class ForecastMeta {
  
  @SerializedName("units")
  private ForecastUnits units = null;
  @SerializedName("updated_at")
  private String updatedAt = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public ForecastUnits getUnits() {
    return units;
  }
  public void setUnits(ForecastUnits units) {
    this.units = units;
  }

  /**
   * Update time for this forecast
   **/
  @ApiModelProperty(required = true, value = "Update time for this forecast")
  public String getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ForecastMeta forecastMeta = (ForecastMeta) o;
    return (this.units == null ? forecastMeta.units == null : this.units.equals(forecastMeta.units)) &&
        (this.updatedAt == null ? forecastMeta.updatedAt == null : this.updatedAt.equals(forecastMeta.updatedAt));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.units == null ? 0: this.units.hashCode());
    result = 31 * result + (this.updatedAt == null ? 0: this.updatedAt.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ForecastMeta {\n");
    
    sb.append("  units: ").append(units).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}