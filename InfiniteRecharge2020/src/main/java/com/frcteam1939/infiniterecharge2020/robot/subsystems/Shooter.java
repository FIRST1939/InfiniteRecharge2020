/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import com.frcteam1939.infiniterecharge2020.robot.commands.shooter.ShooterGamepadControl;

public class Shooter extends SubsystemBase {
  
  private TalonFX shooterTalon1 = new TalonFX(RobotMap.shooterFalcon1);
  private TalonFX shooterTalon2 = new TalonFX(RobotMap.shooterFalcon2);

  private Solenoid bigSolenoid = new Solenoid(RobotMap.shooterHoodBigSolenoid);
  private Solenoid smallSolenoid = new Solenoid(RobotMap.shooterHoodSmallSolenoid);
  
  public Shooter(){
    shooterTalon1.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    shooterTalon2.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    shooterTalon1.enableVoltageCompensation(true);
    shooterTalon2.enableVoltageCompensation(true);

    shooterTalon1.setInverted(true);
    shooterTalon2.setInverted(true);

    shooterTalon2.follow(shooterTalon1);
    disableBrakeMode();
  }

  @Override
  public void periodic() {
  }

  // Positive is out
  public void set(double value){
    shooterTalon1.set(ControlMode.PercentOutput, value);
  }

  public double getSpeed(){
    double speed1 = shooterTalon1.getSelectedSensorVelocity();
    double speed2 = shooterTalon2.getSelectedSensorVelocity();
    return (speed1 + speed2) / 2;
  }

  public double getTemperature(){
    return shooterTalon1.getTemperature();
  }

  public double getOutput(){
    return shooterTalon1.getMotorOutputPercent();
  }

  public void hoodUp(){
    bigSolenoid.set(true);
    smallSolenoid.set(true);
  }

  public void hoodDown(){
    bigSolenoid.set(false);
    smallSolenoid.set(false);
  }

  public void hoodMiddleLow(){
    bigSolenoid.set(false);
    smallSolenoid.set(true);
  }

  public void hoodMiddleHigh(){
    bigSolenoid.set(true);
    smallSolenoid.set(false);
  }
    
  public void enableBrakeMode(){
    shooterTalon1.setNeutralMode(NeutralMode.Brake);
    shooterTalon2.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    shooterTalon1.setNeutralMode(NeutralMode.Coast);
    shooterTalon2.setNeutralMode(NeutralMode.Coast);
  } 
}