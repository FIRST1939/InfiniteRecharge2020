/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import com.frcteam1939.infiniterecharge2020.util.Constants.DriveConstants;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  private WPI_TalonFX frontLeft = new WPI_TalonFX(RobotMap.leftFrontFalcon);
  private WPI_TalonFX backLeft = new WPI_TalonFX(RobotMap.leftBackFalcon);
  private WPI_TalonFX frontRight = new WPI_TalonFX(RobotMap.rightFrontFalcon);
  private WPI_TalonFX backRight = new WPI_TalonFX(RobotMap.rightBackFalcon);

  private final SpeedControllerGroup leftDrive = new SpeedControllerGroup(frontLeft,backLeft);
  private final SpeedControllerGroup rightDrive = new SpeedControllerGroup(frontRight,backRight);


  // The robot's drive
  private final DifferentialDrive differentialDrive = new DifferentialDrive(leftDrive, rightDrive);
 
  
  // The gyro sensor
  AHRS navx = new AHRS(SPI.Port.kMXP);

  // Odometry class for tracking robot pose
  private final DifferentialDriveOdometry m_odometry;

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {

    //2048 units per revolution.
    //If polling the velocity, the velocity will be in units of change-in-pos/100-miliseconds.
    // Sets the distance per pulse for the encoders
   /* m_leftEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
    m_rightEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);*/

    resetEncoders();
    m_odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(getHeading()));
  }

  @Override
  public void periodic() {
    // Update the odometry in the periodic block
    m_odometry.update(Rotation2d.fromDegrees(getHeading()), frontLeft.getSelectedSensorPosition(), frontRight.getSelectedSensorPosition());
  }

  /**
   * Returns the currently-estimated pose of the robot.
   *
   * @return The pose.
   */
  public Pose2d getPose() {
    return m_odometry.getPoseMeters();
  }

  /**
   * Returns the current wheel speeds of the robot.
   *
   * @return The current wheel speeds.
   */
  public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    //If polling the velocity, the velocity will be in units of change-in-pos/100-miliseconds.
    return new DifferentialDriveWheelSpeeds(frontLeft.getSelectedSensorVelocity(),frontRight.getSelectedSensorVelocity());
  }

  /**
   * Resets the odometry to the specified pose.
   *
   * @param pose The pose to which to set the odometry.
   */
  public void resetOdometry(Pose2d pose) {
    resetEncoders();
    m_odometry.resetPosition(pose, Rotation2d.fromDegrees(getHeading()));
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
    differentialDrive.arcadeDrive(fwd, rot);
  }

  /**
   * Controls the left and right sides of the drive directly with voltages.
   *
   * @param leftVolts  the commanded left output
   * @param rightVolts the commanded right output
   */

  /**
   * Resets the drive encoders to currently read a position of 0.
   */
  public void resetEncoders() {
    frontLeft.setSelectedSensorPosition(0);
    frontRight.setSelectedSensorPosition(0);
  }

  /**
   * Gets the average distance of the two encoders.
   *
   * @return the average of the two encoder readings
   */
  public double getAverageEncoderDistance() {
    return ((frontLeft.getSelectedSensorPosition() + frontRight.getSelectedSensorPosition())/2);
  }

  /**
   * Gets the left drive encoder.
   *
   * @return the left drive encoder
   */
  /*public Encoder getLeftEncoder() {
    return m_leftEncoder;
  }*/

  /**
   * Gets the right drive encoder.
   *
   * @return the right drive encoder
   */
  /*
  public Encoder getRightEncoder() {
    return m_rightEncoder;
  }*/

  /**
   * Sets the max output of the drive.  Useful for scaling the drive to drive more slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    
    differentialDrive.setMaxOutput(maxOutput);
  }

  /**
   * Zeroes the heading of the robot.
   */
  public void zeroHeading() {
    navx.reset();
  }

  /**
   * Returns the heading of the robot.
   *
   * @return the robot's heading in degrees, from -180 to 180
   */
  public double getHeading() {
    return Math.IEEEremainder(navx.getYaw(), 360) * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
  }

  /**
   * Returns the turn rate of the robot.
   *
   * @return The turn rate of the robot, in degrees per second
   */
  public double getTurnRate() {
    return navx.getRate() * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
  }
}
