/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.climber;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimberGamepadControl extends CommandBase {

  boolean isClimbing = false;
  public ClimberGamepadControl() {
    addRequirements(Robot.climber);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    boolean climberUp = Robot.oi.left.getRawButton(3);
    boolean climberDown = Robot.oi.left.getRawButton(2);

    
    boolean brakeExtend = Robot.oi.left.getRawButton(5);
  
    if (climberUp){
      Robot.climber.setClimber(1);
      Robot.climber.climberBrakeRetract();
    }
  
    if (climberDown){
      Robot.climber.setClimber(-1);
      Robot.climber.climberBrakeRetract();
    }
  
    if (!climberUp && !climberDown){
      Robot.climber.setClimber(0);
    }
  
    if (brakeExtend){
      Robot.climber.climberBrakeExtend();
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
