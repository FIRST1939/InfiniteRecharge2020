/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.intake;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeGamepadControl extends CommandBase {

  public IntakeGamepadControl() {
    addRequirements(Robot.intake);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.oi.gamepad.leftTrigger.get()){
      Robot.intake.setRoller(0.8);
    }
    else {
      Robot.intake.setRoller(0);
    }
    if (Robot.oi.gamepad.start.get()){
      Robot.intake.extendIntake();
    }

    if (Robot.oi.gamepad.back.get()){
      Robot.intake.retractIntake();
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
