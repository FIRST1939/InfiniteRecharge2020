


/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import com.playingwithfusion.TimeOfFlight;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
  
  private TalonSRX talonHorizontal = new TalonSRX(RobotMap.indexerHorizontalTalon);
  private TalonSRX talonVertical = new TalonSRX(RobotMap.indexerVerticalTalon);

  private TimeOfFlight distanceSensorHorizontal = new TimeOfFlight(RobotMap.indexerHorizontalDistanceSensor);
  private TimeOfFlight distanceSensorVertical = new TimeOfFlight(RobotMap.indexerVerticalDistanceSensor);

  public Indexer() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void set(double value){
    talonVert.set(ControlMode.PercentOutput,value);
    talonHorz.set(ControlMode.PercentOutput,value);
  }
  public void stop(){
    talonVert.set(ControlMode.PercentOutput,0);
    talonHorz.set(ControlMode.PercentOutput,0);
  }

  public void setHorz(double value){
    talonHorz.set(ControlMode.PercentOutput,value);
  }

  public void setVert(double value){
    talonVert.set(ControlMode.PercentOutput,value);
  }

  public void enableBrakeMode(){
    talonVert.setNeutralMode(NeutralMode.Brake);
    talonHorz.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    talonVert.setNeutralMode(NeutralMode.Coast);
    talonHorz.setNeutralMode(NeutralMode.Coast);
  }

  public double getDistanceVert(){
    return distanceSensorVert.getRange();
  }

  public double getDistanceHorz(){
    return distanceSensorHorz.getRange();
  }
}
