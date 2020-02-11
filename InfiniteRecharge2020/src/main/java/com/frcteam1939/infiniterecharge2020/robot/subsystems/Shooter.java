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

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import frc.robot.commands.shooter.ShooterGamepadControl;

public class Shooter extends Subsystem {
  
  private TalonFX shooterTalon1 = new TalonFX(0);
  private TalonFX shooterTalon2 = new TalonFX(0);

  private DoubleSolenoid solenoid1 = new DoubleSolenoid(2, 3);
  private DoubleSolenoid solenoid2 = new DoubleSolenoid(4, 5);
  
  public Shooter(){
    shooterTalon2.follow(shooterTalon1);
    disableBrakeMode();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ShooterGamepadControl());
  }

  public void set(double value){
    shooterTalon1.set(ControlMode.PercentOutput, value);
  }

  public double getSpeed(){
    return shooterTalon1.getSelectedSensorVelocity();
  }

  public double getTemperature(){
    return shooterTalon1.getTemperature();
  }

  public double getOutput(){
    return shooterTalon1.getMotorOutputPercent();
  }

  public void hoodUp(){
    solenoid1.set(DoubleSolenoid.Value.kForward);
    solenoid2.set(DoubleSolenoid.Value.kForward);
  }

  public void hoodDown(){
    solenoid1.set(DoubleSolenoid.Value.kReverse);
    solenoid2.set(DoubleSolenoid.Value.kForward);
  }

  public void hoodMiddleLow(){
    solenoid1.set(DoubleSolenoid.Value.kForward);
    solenoid2.set(DoubleSolenoid.Value.kReverse);
  }

  public void hoodMiddleHigh(){
    solenoid1.set(DoubleSolenoid.Value.kReverse);
    solenoid2.set(DoubleSolenoid.Value.kReverse);
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