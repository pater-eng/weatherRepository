package de.application.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weatherdata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String name;
	private Date timezone;
	private Date dt;
	private String base;
	private int visibility;
	private Long cod;

	private double lon;
	private double lat;

	private String countryCode;
	private long sunrise;
	private long sunset;

	
	private String icon;
	
	private String description;

	private double temperature;
	private Integer pressure;
	private Integer humidity;
	private double temp_min;
	private double temp_max;

	private Double speed;

	private Integer deg;

//	@JsonInclude()
//	@javax.persistence.Transient
//	private Object value;

	@JsonInclude()
	@Column(name = "favorite")
	private boolean isFavorite;

	public Weatherdata(long id, String name, Date timezone, Date dt, String base, int visibility, Long cod, double lon,
			double lat, String countryCode, long sunrise, long sunset, String geIcon, String description,
			double temperature, Integer pressure, Integer humidity, double temp_min, double temp_max, Double speed,
			Integer deg) {
		super();
		this.id = getId();
		this.name = getName();
		this.timezone = getTimezone();
		this.dt = getDt();
		this.base = getBase();
		this.visibility = getVisibility();
		this.cod = getCod();
		this.lon = getLon();
		this.lat = getLat();
		this.countryCode = getCountryCode();
		this.sunrise = getSunrise();
		this.sunset = getSunset();
		this.icon = getIcon();
		this.description = getDescription();
		this.temperature = getTemperature();
		this.pressure = getPressure();
		this.humidity = getHumidity();
		this.temp_min = getTemp_min();
		this.temp_max = getTemp_max();
		this.speed = getSpeed();
		this.deg = getDeg();
	}

	public String getIcon() {
		return icon;
	}

	public Weatherdata(long id, String name, Date timezone, Date dt, String base, int visibility, long cod, double lon,
			double lat) {
		super();
		this.id = id;
		this.name = name;
		this.timezone = timezone;
		this.dt = dt;
		this.base = base;
		this.visibility = visibility;
		this.cod = cod;
		this.lon = lon;
		this.lat = lat;
	}

	public Weatherdata() {
		super();
	}

	public String getName() {
		return name;
	}

	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("lat")
	public double getLat() {
		return lat;
	}

	@JsonSetter("lat")
	public void setLat(double lat) {
		this.lat = lat;
	}

	@JsonProperty("lon")
	public double getLon() {
		return lon;
	}

	@JsonSetter("lon")
	public void setLon(double lon) {
		this.lon = lon;
	}

	public long getId() {
		return id;
	}

	@JsonProperty
	public void setId(long id) {
		this.id = id;
	}

	public Date getTimezone() {
		return timezone;
	}

	@JsonProperty
	public void setTimezone(Date timezone) {
		this.timezone = timezone;
	}

	public String getBase() {
		return base;
	}

	@JsonProperty
	public void setBase(String base) {
		this.base = base;
	}

	public int getVisibility() {
		return visibility;
	}

	@JsonProperty
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public Date getDt() {
		return dt;
	}

	@JsonProperty
	public void setDt(Date dt) {
		this.dt = dt;
	}

	public Long getCod() {
		return cod;
	}

	@JsonProperty
	public void setCod(Long cod) {
		this.cod = cod;
	}

	@JsonProperty("sunrise")
	public long getSunrise() {
		return this.sunrise;
	}

	@JsonSetter("sunrise")
	public void setSunrise(long timestamp) {
		this.sunrise = timestamp;
	}

	@JsonProperty("sunset")
	public long getSunset() {
		return this.sunset;
	}

	@JsonSetter("sunset")
	public void setSunset(long timestamp) {
		this.sunset = timestamp;
	}

	@JsonProperty("country")
	public String getCountryCode() {
		return this.countryCode;
	}

	@JsonSetter("country")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	@JsonProperty("icon")
	public String geIcon() {
		return this.icon;
	}

	@JsonSetter("icon")
	public void setIcon(String icon) {
		this.icon = icon;
	}


	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonSetter("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("temp")
	public double getTemperature() {
		return temperature;
	}

	@JsonSetter("temp")
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@JsonProperty("pressure")
	public Integer getPressure() {
		return pressure;
	}

	@JsonSetter("pressure")
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	@JsonProperty("humidity")
	public Integer getHumidity() {
		return humidity;
	}

	@JsonSetter("humidity")
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	@JsonProperty("temp_min")
	public double getTemp_min() {
		return temp_min;
	}

	@JsonSetter("temp_min")
	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}

	@JsonProperty("temp_max")
	public double getTemp_max() {
		return temp_max;
	}

	@JsonSetter("temp_max")
	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}

	@JsonProperty("speed")
	public Double getSpeed() {
		return speed;
	}

	@JsonSetter("speed")
	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	

	@JsonProperty("deg")
	public Integer getDeg() {
		return deg;
	}

	@JsonSetter("deg")
	public void setDeg(Integer deg) {
		this.deg = deg;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;

	}

	@JsonProperty("sys")
	public void setSys(Map<String, Object> sys) {
		setCountryCode((String) sys.get("country"));
		setSunrise((int) sys.get("sunrise"));
		setSunset((int) sys.get("sunset"));

	}

	@JsonProperty("coord")
	public void setCoord(Map<String, Object> coord) {
		// setLon((Integer) coord.get("lon"));// für Hamburg mit Integer sein
		setLon((double) coord.get("lon"));
		setLat((double) coord.get("lat"));
		// setLat((Integer) coord.get("lat")); // Mainz muss Integer sein
	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setDescription((String) weather.get("description"));
		setIcon((String) weather.get("icon"));
	}

	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		setTemperature((double) main.get("temp"));
		setPressure((Integer) main.get("pressure"));
		setHumidity((Integer) main.get("humidity"));
		setTemp_min((double) main.get("temp_min"));
		setTemp_max((double) main.get("temp_max"));
	}

	@JsonProperty("wind")
	public void setWind(Map<String, Object> wind) {

		// if (speed instanceof Double) {

		setSpeed((Double) wind.get("speed"));
		// setSpeed((Integer) wind.get("speed")); // für Douala muss Integer sein
		// } else if (speedy instanceof Integer) {
		//
		// setSpeedy((Integer) wind.get("speed"));
		//
		// }
		setDeg((Integer) wind.get("deg"));

	}

	@Override
	public String toString() {
		return "Weatherdata [id=" + id + ", name=" + name + ", timezone=" + timezone + ", dt=" + dt + ", base=" + base
				+ ", visibility=" + visibility + ", cod=" + cod + ", lon=" + lon + ", lat=" + lat + ", countryCode="
				+ countryCode + ", sunrise=" + sunrise + ", sunset=" + sunset + ", icon="
				+ icon + ", description=" + description + ", temperature=" + temperature
				+ ", pressure=" + pressure + ", humidity=" + humidity + ", temp_min=" + temp_min + ", temp_max="
				+ temp_max + ", speed=" + speed + ", deg=" + deg + "]";
	}
}
