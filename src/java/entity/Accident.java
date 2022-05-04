/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author chubo
 */
public class Accident {

    private int accidentId;
    private int compe_id;
    private int moto_id;
    private int punish_id;
    private Date accident_date;
    private String damage_percent;
    private String estimated_cost;
    private String note;

    public Accident() {
    }

    public Accident(int accidentId, int compe_id, int moto_id, int punish_id, Date accident_date, String damage_percent, String estimated_cost, String note) {
        this.accidentId = accidentId;
        this.compe_id = compe_id;
        this.moto_id = moto_id;
        this.punish_id = punish_id;
        this.accident_date = accident_date;
        this.damage_percent = damage_percent;
        this.estimated_cost = estimated_cost;
        this.note = note;
    }

    public int getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(int accidentId) {
        this.accidentId = accidentId;
    }

    public int getCompe_id() {
        return compe_id;
    }

    public void setCompe_id(int compe_id) {
        this.compe_id = compe_id;
    }

    public int getMoto_id() {
        return moto_id;
    }

    public void setMoto_id(int moto_id) {
        this.moto_id = moto_id;
    }

    public int getPunish_id() {
        return punish_id;
    }

    public void setPunish_id(int punish_id) {
        this.punish_id = punish_id;
    }

    public Date getAccident_date() {
        return accident_date;
    }

    public void setAccident_date(Date accident_date) {
        this.accident_date = accident_date;
    }

    public String getDamage_percent() {
        return damage_percent;
    }

    public void setDamage_percent(String damage_percent) {
        this.damage_percent = damage_percent;
    }

    public String getEstimated_cost() {
        return estimated_cost;
    }

    public void setEstimated_cost(String estimated_cost) {
        this.estimated_cost = estimated_cost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Accident{" + "accidentId=" + accidentId + ", compe_id=" + compe_id + ", moto_id=" + moto_id + ", punish_id=" + punish_id + ", accident_date=" + accident_date + ", damage_percent=" + damage_percent + ", estimated_cost=" + estimated_cost + ", note=" + note + '}';
    }
    
}
