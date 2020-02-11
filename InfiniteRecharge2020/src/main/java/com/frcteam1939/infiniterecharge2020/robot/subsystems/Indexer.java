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

public class Indexer extends Subsystem {
  private TalonSRX indexTalon1 = new TalonSRX(RobotMap.indexTalon1);
  private TalonSRX indexTalon2 = new TalonSRX(RobotMap.indexTalon2);

  @Override
  public void initDefaultCommand() {
  }

  //Brake Mode
  public void enableBrakeModeIndex1(){
    indexTalon1.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeModeIndex1(){
    indexTalon1.setNeutralMode(NeutralMode.Coast);
  }

  public void enableBrakeModeIndex2(){
    indexTalon2.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeModeIndex2(){
    indexTalon2.setNeutralMode(NeutralMode.Coast);
  }
  
}