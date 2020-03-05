/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.drivetrain;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveByJoystick extends CommandBase {

  private static double DEAD_BAND = 0.1;
  private static double ROTATE_DEAD_BAND = 0.15;

  public DriveByJoystick() {
    addRequirements(Robot.drivetrain);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double move = Robot.oi.left.getY();
	double rotate = Robot.oi.right.getX();

	boolean slowDown = Robot.oi.left.getRawButton(1) || Robot.oi.right.getRawButton(1);
	boolean shooter = Robot.oi.right.getRawButton(8) || Robot.oi.right.getRawButton(9);

    if (Math.abs(move) < DEAD_BAND) {
			move = 0;
		} else {
			if (slowDown) {
				move = map(move, 0, 0.5);
			} else {
				move = map(move, 0, 1.0);
			}
		}

		if (Math.abs(rotate) < ROTATE_DEAD_BAND) {
			rotate = 0;
		} else {
			if (slowDown) {
				rotate = map(rotate, 0, 0.3);
			} else {
				rotate = map(rotate, 0, 0.45);
			}
		}

		Robot.drivetrain.drive(move, rotate);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
	private static double map(double x, double out_min, double out_max) {
		return map(x, DEAD_BAND, 1.0, out_min, out_max);
	}

	private static double map(double x, double in_min, double in_max, double out_min, double out_max) {
		boolean negative = x < 0;
		double newValue = (Math.abs(x) - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
		if (negative) {
			return -newValue;
		} else {
			return newValue;
		}
	}
}
