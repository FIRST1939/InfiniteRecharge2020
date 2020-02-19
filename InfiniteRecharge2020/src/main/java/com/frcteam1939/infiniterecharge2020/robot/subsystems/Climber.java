/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import com.frcteam1939.infiniterecharge2020.robot.commands.climber.ClimberGamepadControl;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {

  private TalonFX climberTalon = new TalonFX(RobotMap.climberFalcon);
  private TalonSRX gondolaTalon = new TalonSRX(RobotMap.gondolaTalon);

  private DoubleSolenoid climberBrake = new DoubleSolenoid(RobotMap.climberBrakeSolenoidForward, RobotMap.climberBrakeSolenoidReverse);

  public Climber(){
    climberTalon.enableVoltageCompensation(true);
    climberTalon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    climberTalon.setInverted(true);
    gondolaTalon.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {
  }

  // Positive is up
  public void setClimber(double value){
    climberTalon.set(ControlMode.PercentOutput, value);
  }

  // Positive is left
  public void setGondola(double value){
    gondolaTalon.set(ControlMode.PercentOutput, value);
  }

  public void climberBrakeExtend(){
    climberBrake.set(DoubleSolenoid.Value.kForward);
  }

  public void climberBrakeRetract(){
    climberBrake.set(DoubleSolenoid.Value.kReverse);
  }

  public void enableBrakeModeClimber(){
    climberTalon.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeModeClimber(){
    climberTalon.setNeutralMode(NeutralMode.Coast);
  }

  public void enableBrakeModeGondola(){
    gondolaTalon.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeModeGondola(){
    gondolaTalon.setNeutralMode(NeutralMode.Coast);
  }
}