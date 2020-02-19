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
import com.frcteam1939.infiniterecharge2020.robot.commands.indexer.IndexerGamepadControl;
import com.playingwithfusion.TimeOfFlight;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
  
  private TalonSRX talonHorizontal = new TalonSRX(RobotMap.indexerHorizontalTalon);
  private TalonSRX talonVertical = new TalonSRX(RobotMap.indexerVerticalTalon);

  private DutyCycleEncoder encoder = new DutyCycleEncoder(RobotMap.indexerVerticalThroughBoreEncoder);
  // Banner sensor, through bore encoder

  private TimeOfFlight distanceSensorTop = new TimeOfFlight(RobotMap.indexerTopDistanceSensor);
  private TimeOfFlight distanceSensorBottom = new TimeOfFlight(RobotMap.indexerBottomDistanceSensor);
  public DigitalInput banner = new DigitalInput(RobotMap.indexerBannerSensor);

  int numBalls;

  public final double INDEXER_SHOOT_SPEED = 1.0;
  public final double INDEXER_HORIONTAL_SPEED = 0.8;
  public final double INDEXER_VERTICAL_SPEED = 0.5;

  public final double DIST_ONE_BALL = .1;
  public final double DIST_DEFAULT = .1;
  public final double DIST_THIRD_BALL = .1;

  public Indexer() {
    talonHorizontal.enableVoltageCompensation(true);
    talonVertical.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {
  }

  public void set(double value){
    talonVertical.set(ControlMode.PercentOutput,value);
    talonHorizontal.set(ControlMode.PercentOutput,value);
  }
  public void stop(){
    talonVertical.set(ControlMode.PercentOutput,0);
    talonHorizontal.set(ControlMode.PercentOutput,0);
  }

  // Positive is in
  public void setHorizontal(double value){
    talonHorizontal.set(ControlMode.PercentOutput,value);
  }

  // Positive is up
  public void setVertical(double value){
    talonVertical.set(ControlMode.PercentOutput,value);
  }

  public void enableBrakeMode(){
    talonVertical.setNeutralMode(NeutralMode.Brake);
    talonHorizontal.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    talonVertical.setNeutralMode(NeutralMode.Coast);
    talonHorizontal.setNeutralMode(NeutralMode.Coast);
  }

  public double getDistanceTop(){
    return distanceSensorTop.getRange();
  }

  public double getDistanceBottom(){
    return distanceSensorBottom.getRange();
  }

  public boolean getBanner(){
    return !banner.get();
  }

  public void addOneBall(){
    numBalls++;
  }
  public int getBalls(){
    return numBalls;
  }

  public double getPosition(){
    return encoder.getDistance();
  }
}
