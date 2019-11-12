package de.application.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private long id;
	private String name;
	private Date timezone; // timezone
	private Date dt; // dt
	private String base; // Stations
	private int visibility; // Visibility
	private Long cod;

	private double lon; // Geografische Lage der Stadt, Laengengrad
	private double lat; // Geografische Lage der Stadt, Breitengrad

	private String countryCode;
	private long sunrise;
	private long sunset;

	private long weatherId;
	private String icon;
	private String main;
	private String description;

	private double temperature;
	private Integer pressure;
	private Integer humidity;
	private double temp_min;
	private double temp_max;

	private double speed;
	// private Integer speedy;
	private Integer deg;

	public Weatherdata(long id, String name, Date timezone, Date dt, String base, int visibility, Long cod, double lon,
			double lat, String countryCode, long sunrise, long sunset, long weatherId, String icon, String main,
			String description, double temperature, Integer pressure, Integer humidity, double temp_min,
			double temp_max, double speed, Integer deg) {
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
		this.weatherId = weatherId;
		this.icon = getIcon();
		this.main = main;
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
		// TODO Auto-generated constructor stub
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

	// @JsonProperty("id")
	// public long getWeatherId() {
	// return this.weatherId;
	// }
	//
	// @JsonSetter("id")
	// public void setWeatherId(long weatherId) {
	// this.weatherId = weatherId;
	// }

	@JsonProperty("icon")
	public String geIcon() {
		return this.icon;
	}

	@JsonSetter("icon")
	public void setIcon(String icon) {
		this.icon = icon;
	}

	// @JsonProperty("main")
	// public String getWeatherMain() {
	// return weatherMain;
	// }
	//
	// @JsonSetter("main")
	// public void setWeatherMain(String weatherMain) {
	// this.weatherMain = weatherMain;
	// }

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
	public double getSpeed() {
		return speed;
	}

	@JsonSetter("speed")
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	// @JsonProperty("speed")
	// public Integer getSpeedy() {
	// return speedy;
	// }
	//
	// @JsonSetter("speed")
	// public void setSpeedy(Integer speedy) {
	// this.speedy = speedy;
	// }

	@JsonProperty("deg")
	public Integer getDeg() {
		return deg;
	}

	@JsonSetter("deg")
	public void setDeg(Integer deg) {
		this.deg = deg;
	}

	@JsonProperty("sys")
	public void setSys(Map<String, Object> sys) {
		setCountryCode((String) sys.get("country"));
		setSunrise((int) sys.get("sunrise"));
		setSunset((int) sys.get("sunset"));

	}

	@JsonProperty("coord")
	public void setCoord(Map<String, Object> coord) {
		setLon((double) coord.get("lon"));
		setLat((double) coord.get("lat"));
	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		// setWeatherId((long) weather.get("id"));
		// setWeatherMain((String) weather.get("main"));
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
		// yaounde, dortmund...

		// if (speed == Double.valueOf(speed)) {

		setSpeed((double) wind.get("speed"));
		// } else if (speedy == Integer.valueOf(speedy)) {

		// setSpeed((Integer) wind.get("speed"));

		// }
		setDeg((Integer) wind.get("deg"));

	}
}
