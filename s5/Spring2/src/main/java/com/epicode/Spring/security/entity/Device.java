package com.epicode.Spring.security.entity;

import com.epicode.Spring.security.entity.enums.DeviceStatus;
import com.epicode.Spring.security.entity.enums.DeviceType;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "devices")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "device", discriminatorType = DiscriminatorType.STRING)
public abstract class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Enumerated(EnumType.STRING)
	DeviceType tipo;
	@Enumerated(EnumType.STRING)
	DeviceStatus stato;
	@ManyToOne
	User user;
}
