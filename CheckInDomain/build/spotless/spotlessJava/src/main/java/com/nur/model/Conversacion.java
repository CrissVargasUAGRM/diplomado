package com.nur.model;

import com.nur.core.AggregateRoot;
import java.time.LocalDate;
import java.util.UUID;

public class Conversacion extends AggregateRoot {
  public LocalDate fechaInicio;
  public LocalDate fechaFin;
  public StatusConversation status;

  public LocalDate getFechaInicio() {
    return fechaInicio;
  }

  public LocalDate getFechaFin() {
    return fechaFin;
  }

  public StatusConversation getStatus() {
    return status;
  }

  public void setStatus(StatusConversation status) {
    this.status = status;
  }

  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public void setFechaFin(LocalDate fechaFin) {
    this.fechaFin = fechaFin;
  }

  public Conversacion() {
    id = UUID.randomUUID();
    this.fechaInicio = LocalDate.now();
    this.fechaFin = null;
    this.status = StatusConversation.ACTIVA;
  }

  public Conversacion(UUID id, LocalDate fechaInicio) {
    this.setId(id);
    this.fechaInicio = fechaInicio;
    this.deprecatedConversation();
  }

  public void deprecatedConversation() {
    if (status != StatusConversation.ACTIVA) {
      throw new IllegalArgumentException("La conversacion ya fue deprecada o cancelada");
    }
    this.status = StatusConversation.OLVIDADA;
    this.fechaFin = LocalDate.now();
  }
}
