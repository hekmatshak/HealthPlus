package com.example.healthplus;

import android.support.annotation.IdRes;
import android.view.View;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

//This is our table name
@Table(name = "Patients")
public class _3a_Patient extends Model {

    @Column(name = "First Name")
    public String fName;

    @Column(name = "Last Name")
    public String lName;

    @Column(name = "Age")
    public int age;

    @Column(name = "Diagnosis")
    public String diagnosis;

    @Column(name = "Treatment")
    public String treatment;

    public _3a_Patient(String fName, String lName, int age, String diagnosis, String treatment, String painEvaluation) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.painEvaluation = painEvaluation;
    }

    @Column(name = "Pain Evaluation")
    public String painEvaluation;
}