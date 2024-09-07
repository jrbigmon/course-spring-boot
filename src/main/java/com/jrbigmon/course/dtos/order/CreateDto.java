package com.jrbigmon.course.dtos.order;

public class CreateDto {
  private String moment;

  public CreateDto(String moment) {
    this.moment = moment;
  }

  public String getMoment() {
    return moment;
  }

  public void setMoment(String moment) {
    this.moment = moment;
  }
}
