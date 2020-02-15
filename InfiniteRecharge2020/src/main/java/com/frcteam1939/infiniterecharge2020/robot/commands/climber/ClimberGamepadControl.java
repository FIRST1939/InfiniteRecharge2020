/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.climber;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimberGamepadControl extends CommandBase {

  public ClimberGamepadControl() {
    addRequirements(Robot.climber);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double climberValue = Robot.oi.gamepad.getLeftY();
    double gondolaValue = Robot.oi.gamepad.getLeftX();
    Robot.climber.setClimber(climberValue);
    Robot.climber.setGondola(gondolaValue);

    if (Robot.oi.gamepad.start.get()){
      Robot.climber.climberBrakeExtend();
    }

    if (Robot.oi.gamepad.back.get()){
      Robot.climber.climberBrakeRetract();
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
