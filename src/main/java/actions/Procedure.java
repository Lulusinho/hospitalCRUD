package actions;

import Person.*;

public class Procedure {
  public Pacient pacient;
  public Doctor doc;
  public String date;
  public double durationtime;
  public double cost;
  public String type;
  public String room;

  public Procedure(Procedure builder) {
    this.pacient = new Pacient(builder.pacient);
    this.doc = new Doctor(builder.doc);
    this.date = new String(builder.date);
    this.durationtime = builder.durationtime;
    this.cost = builder.cost;
    this.type = new String(builder.type);
    this.room = new String(builder.room);
  }

  private Procedure(ProcedureBuilder builder) {
    this.pacient = builder.pacient;
    this.doc = builder.doc;
    this.date = builder.date;
    this.durationtime = builder.durationtime;
    this.cost = builder.cost;
    this.type = builder.type;
    this.room = builder.room;
  }

  public static class ProcedureBuilder {
    private String type;
    private double cost;
    private Pacient pacient;
    private Doctor doc;
    private String date;
    private double durationtime;
    private String room;

    public ProcedureBuilder setType(String type) {
      type.toUpperCase();
      if (type.equals("FARINGOPLASTIA") || type.equals("NEUROCIRURGIA")) {
        this.type = type;
        return this;
      }
      throw new RuntimeException();
    }

    public ProcedureBuilder setPacient(Pacient pacient) {
      this.pacient = pacient;
      return this;

    }

    public ProcedureBuilder setroom(String str) {
      this.room = new String(str);
      return this;

    }

    public ProcedureBuilder setDate(String Date) {
      this.date = Date;
      return this;

    }

    public ProcedureBuilder setCost(double minutesDuration, double costpminut) {
      this.durationtime = minutesDuration;
      this.cost = minutesDuration * costpminut;
      return this;

    }

    public ProcedureBuilder setDoctor(Doctor doc) {
      this.doc = doc;
      return this;

    }

    public Procedure build() {
      return new Procedure(this);
    }
  }
}
