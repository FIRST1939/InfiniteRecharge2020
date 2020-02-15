/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.controlpanelmanipulator;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlPanelManipulatorGamepadControl extends CommandBase {

  public ControlPanelManipulatorGamepadControl() {
    addRequirements(Robot.controlPanelManipulator);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Robot.oi.gamepad.leftButton.get()){
      Robot.controlPanelManipulator.set(0.5);
    }
    else {
      Robot.controlPanelManipulator.stop();
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
