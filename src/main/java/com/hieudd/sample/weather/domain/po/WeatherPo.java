package com.oddle.app.weather.domain.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "W_WEATHER")
public class WeatherPo {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "city_id")
    private String cityId;

    @Column(name = "temp")
    private double temp;

    @Column(name = "feels_like")
    private double feelsLike;

    @Column(name = "temp_min")
    private double tempMin;

    @Column(name = "temp_max")
    private double tempMax;

    @Column(name = "pressure")
    private double pressure;

    @Column(name = "humidity")
    private double humidity;

    @Column(name = "wind_speed")
    private double windSpeed;

    @Column(name = "wind_deg")
    private double windDeg;

    @Column(name = "date")
    private Date date;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    private Date updatedAt;
}
