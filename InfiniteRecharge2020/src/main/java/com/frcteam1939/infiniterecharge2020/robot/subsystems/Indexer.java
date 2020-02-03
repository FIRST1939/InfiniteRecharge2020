/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Indexer extends Subsystem {
  private TalonSRX talonAcross = new TalonSRX(RobotMap.indexTalon1);
  private TalonSRX talonUp = new TalonSRX(RobotMap.indexTalon2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
