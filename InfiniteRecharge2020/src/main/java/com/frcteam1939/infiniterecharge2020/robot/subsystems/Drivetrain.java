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

public class Drivetrain extends Subsystem {
  private TalonSRX leftBackTalon = new TalonSRX(RobotMap.leftBackTalon);
  private TalonSRX leftFrontTalon = new TalonSRX(RobotMap.leftFrontTalon);
  private TalonSRX rightBackTalon = new TalonSRX(RobotMap.rightBackTalon);
  private TalonSRX rightFrontTalon = new TalonSRX(RobotMap.rightFrontTalon);

  @Override
  public void initDefaultCommand() {
  }

  //Brake Mode
  public void enableBrakeModeDrivetrain(){
    leftBackTalon.setNeutralMode(NeutralMode.Brake);
    leftFrontTalon.setNeutralMode(NeutralMode.Brake);
    rightBackTalon.setNeutralMode(NeutralMode.Brake);
    rightFrontTalon.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeModeDrivetrain(){
    leftBackTalon.setNeutralMode(NeutralMode.Coast);
    leftFrontTalon.setNeutralMode(NeutralMode.Coast);
    rightBackTalon.setNeutralMode(NeutralMode.Coast);
    rightFrontTalon.setNeutralMode(NeutralMode.Coast);
  }
  
}