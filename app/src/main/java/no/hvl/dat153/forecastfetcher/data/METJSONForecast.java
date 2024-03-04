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

import no.hvl.dat153.forecastfetcher.data.Forecast;
import no.hvl.dat153.forecastfetcher.data.PointGeometry;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class METJSONForecast {
  
  @SerializedName("geometry")
  private PointGeometry geometry = null;
  @SerializedName("properties")
  private Forecast properties = null;
  public enum TypeEnum {
     Feature, 
  };
  @SerializedName("type")
  private TypeEnum type = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public PointGeometry getGeometry() {
    return geometry;
  }
  public void setGeometry(PointGeometry geometry) {
    this.geometry = geometry;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Forecast getProperties() {
    return properties;
  }
  public void setProperties(Forecast properties) {
    this.properties = properties;
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
    METJSONForecast mETJSONForecast = (METJSONForecast) o;
    return (this.geometry == null ? mETJSONForecast.geometry == null : this.geometry.equals(mETJSONForecast.geometry)) &&
        (this.properties == null ? mETJSONForecast.properties == null : this.properties.equals(mETJSONForecast.properties)) &&
        (this.type == null ? mETJSONForecast.type == null : this.type.equals(mETJSONForecast.type));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.geometry == null ? 0: this.geometry.hashCode());
    result = 31 * result + (this.properties == null ? 0: this.properties.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class METJSONForecast {\n");
    
    sb.append("  geometry: ").append(geometry).append("\n");
    sb.append("  properties: ").append(properties).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
