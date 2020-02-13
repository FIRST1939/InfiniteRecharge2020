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

public class Climber extends Subsystem {
  private TalonSRX climberTalon = new TalonSRX(RobotMap.climberFalcon);
  private TalonSRX gondolaSnowblower = new TalonSRX(RobotMap.gondolaTalon);

  @Override
  public void initDefaultCommand() {
  }

  //Brake Mode
  public void enableBrakeModeClimber(){
    climberTalon.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeModeClimber(){
    climberTalon.setNeutralMode(NeutralMode.Coast);
  }

  public void enableBrakeModeGondola(){
    gondolaSnowblower.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeModeGondola(){
    gondolaSnowblower.setNeutralMode(NeutralMode.Coast);
  }
  
}