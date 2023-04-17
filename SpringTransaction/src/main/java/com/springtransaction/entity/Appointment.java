package com.springtransaction.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Setter
@Getter
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appointmentNo;

    private Date date;

    private Long doctorNo;

    public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Long appointmentNo, Date date, Long doctorNo, Long patientNo) {
		super();
		this.appointmentNo = appointmentNo;
		this.date = date;
		this.doctorNo = doctorNo;
		this.patientNo = patientNo;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentNo=" + appointmentNo + ", date=" + date + ", doctorNo=" + doctorNo
				+ ", patientNo=" + patientNo + "]";
	}

	public Long getAppointmentNo() {
		return appointmentNo;
	}

	public void setAppointmentNo(Long appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getDoctorNo() {
		return doctorNo;
	}

	public void setDoctorNo(Long doctorNo) {
		this.doctorNo = doctorNo;
	}

	public Long getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(Long patientNo) {
		this.patientNo = patientNo;
	}

	private Long patientNo;

	

}
