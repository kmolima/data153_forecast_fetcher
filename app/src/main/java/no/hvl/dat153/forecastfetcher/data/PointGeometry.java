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

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class PointGeometry {
  
  @SerializedName("coordinates")
  private List<BigDecimal> coordinates = null;
  public enum TypeEnum {
     Point, 
  };
  @SerializedName("type")
  private TypeEnum type = null;

  /**
   * [longitude, latitude, altitude]. All numbers in decimal.
   **/
  @ApiModelProperty(required = true, value = "[longitude, latitude, altitude]. All numbers in decimal.")
  public List<BigDecimal> getCoordinates() {
    return coordinates;
  }
  public void setCoordinates(List<BigDecimal> coordinates) {
    this.coordinates = coordinates;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PointGeometry pointGeometry = (PointGeometry) o;
    return (this.coordinates == null ? pointGeometry.coordinates == null : this.coordinates.equals(pointGeometry.coordinates)) &&
        (this.type == null ? pointGeometry.type == null : this.type.equals(pointGeometry.type));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.coordinates == null ? 0: this.coordinates.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PointGeometry {\n");
    
    sb.append("  coordinates: ").append(coordinates).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
