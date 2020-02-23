/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.turret;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.robot.commands.shooter.SetShooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurretGamepadControl extends CommandBase {

    public TurretGamepadControl() {
      addRequirements(Robot.turret);
    }
  
    @Override
    public void initialize() {
    }
  
    @Override
    public void execute() {

      Robot.oi.gamepad.rightTrigger.whenPressed(new Test());

      if (Robot.turret.isAtClimberPosition()){
        Robot.turret.zeroEncoder();
      }

      double value = Robot.oi.gamepad.getLeftX() * .75;
      Robot.turret.set(value);
    }
  
    @Override
    public void end(boolean interrupted) {
    }
  
    @Override
    public boolean isFinished() {
      return false;
    }
  }
  