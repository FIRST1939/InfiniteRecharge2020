/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.turret.TurretGamepadControl;


public class Turret extends Subsystem {
  
  private TalonSRX victor = new TalonSRX(RobotMap.turretTalon);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TurretGamepadControl());
  }

  public void set (double value){
    victor.set(ControlMode.PercentOutput, value);
  }
}