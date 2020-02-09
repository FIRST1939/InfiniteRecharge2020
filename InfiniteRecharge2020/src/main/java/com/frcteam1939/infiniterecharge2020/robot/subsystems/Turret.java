/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Turret extends Subsystem {
  private TalonSRX turretSnowblower = new TalonSRX(RobotMap.turretSnowblower);

  @Override
  public void initDefaultCommand() {
  }

  //Brake Mode
  public void enableBrakeModeTurret(){
    turretSnowblower.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeModeTurret(){
    turretSnowblower.setNeutralMode(NeutralMode.Coast);
  }
  
}