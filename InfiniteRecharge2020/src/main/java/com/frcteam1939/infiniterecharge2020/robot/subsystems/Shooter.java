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

public class Shooter extends Subsystem {
  private TalonSRX shooterTalon1 = new TalonSRX(RobotMap.shooterTalon1);
  private TalonSRX shooterTalon2 = new TalonSRX(RobotMap.shooterTalon2);

  @Override
  public void initDefaultCommand() {
  }

  //Brake Mode
  public void enableBrakeModeShooter(){
    shooterTalon1.setNeutralMode(NeutralMode.Brake);
    shooterTalon2.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeModeShooter(){
    shooterTalon1.setNeutralMode(NeutralMode.Coast);
    shooterTalon2.setNeutralMode(NeutralMode.Coast);
  }
  
}