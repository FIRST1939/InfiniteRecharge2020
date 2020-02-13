/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
  private TalonFX  leftBackFalcon = new TalonFX(RobotMap.leftBackFalcon);
  private TalonFX  leftFrontFalcon = new TalonFX(RobotMap.leftFrontFalcon);
  private TalonFX  rightBackFalcon = new TalonFX(RobotMap.rightBackFalcon);
  private TalonFX  rightFrontfalcon = new TalonFX(RobotMap.rightFrontFalcon);

  @Override
  public void initDefaultCommand() {
  }

  //Brake Mode
  public void enableBrakeModeDrivetrain(){
    leftBackFalcon.setNeutralMode(NeutralMode.Brake);
    leftFrontFalcon.setNeutralMode(NeutralMode.Brake);
    rightBackFalcon.setNeutralMode(NeutralMode.Brake);
    rightFrontfalcon.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeModeDrivetrain(){
    leftBackFalcon.setNeutralMode(NeutralMode.Coast);
    leftFrontFalcon.setNeutralMode(NeutralMode.Coast);
    rightBackFalcon.setNeutralMode(NeutralMode.Coast);
    rightFrontfalcon.setNeutralMode(NeutralMode.Coast);
  }
  
}