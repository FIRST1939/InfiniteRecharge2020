/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.intake;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;

public class IntakeGamepadControl extends CommandBase {

  boolean wasWait = false;
  public IntakeGamepadControl() {
    addRequirements(Robot.intake);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    /*if (Robot.oi.xboxController.getLeftTriggerButton()){
      if(!wasWait){
        Robot.intake.extendIntake();
        Timer.delay(.5);
        Robot.intake.setRoller(.6);
        wasWait = true;
      }
      else{
        Robot.intake.setRoller(.6);
        Robot.intake.extendIntake();

      }
    }
    else {
      wasWait = false;
      Robot.intake.retractIntake();
      Robot.intake.setRoller(0);
    }
    */

    //Robot.oi.xboxController.leftTrigger.whenActive(new IntakePowerCell());
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
