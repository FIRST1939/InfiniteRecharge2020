/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.turret;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnToTarget extends CommandBase {

  boolean done = false;

  public TurnToTarget() {
    addRequirements(Robot.turret);
  }

  @Override
  public void initialize() {
    Robot.limelightTurret.setPipeline(0);
    Robot.turret.anglePID.reset();
    Robot.turret.anglePID.setSetpoint(0);
  }

  @Override
  public void execute() {

    double output;
    
    /*if (Robot.turret.anglePID.atSetpoint()){
      output = 0;
      done = true;
    }
    else {
      output = Robot.turret.anglePID.calculate(Robot.limelightTurret.getHorizontalAngleError());
    }*/

    output = -Robot.turret.anglePID.calculate(Robot.limelightTurret.getHorizontalAngleError());

    SmartDashboard.putNumber("Turret PID Output", output);
    System.out.println("Turret PID Output: " + output);

    Robot.turret.set(output);
    
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
