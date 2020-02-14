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

import edu.wpi.first.wpilibj.command.Subsystem;


public class Turret extends Subsystem {

  private TalonSRX talon = new TalonSRX(RobotMap.turretTalon);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TurretGamepadControl());
  }

  public void set(double value){
    talon.set(ControlMode.PercentOutput, value);
  }

  public void enableBrakeModeTurret(){
    talon.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeModeTurret(){
    talon.setNeutralMode(NeutralMode.Coast);
  }
}