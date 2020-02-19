/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import com.frcteam1939.infiniterecharge2020.robot.commands.turret.TurretGamepadControl;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Turret extends SubsystemBase {

  private TalonSRX talon = new TalonSRX(RobotMap.turretTalon);

  private DutyCycleEncoder encoder = new DutyCycleEncoder(RobotMap.turretThroughBoreEncoder);

  private DigitalInput hallEffectClockwise = new DigitalInput(RobotMap.turretClockwiseStopHallEffect);
  private DigitalInput hallEffectCounterClockwise = new DigitalInput(RobotMap.turretCounterclockwiseStopHallEffect);

  public Turret(){
    talon.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {
  }

  // Positive is clockwise
  public void set(double value){
    talon.set(ControlMode.PercentOutput, value);
  }

  public void enableBrakeMode(){
    talon.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    talon.setNeutralMode(NeutralMode.Coast);
  }

  public double getPosition(){
    return encoder.getDistance();
  }

  public boolean isAtClockwiseLimit(){
    return hallEffectClockwise.get();
  }

  public boolean isAtCounterClockwiseLimit(){
    return hallEffectCounterClockwise.get();
  }
}