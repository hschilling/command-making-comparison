// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The driver's controller
  CommandXboxController m_driverController = new CommandXboxController(0);

  public Shooter shooter;

  public RobotContainer() {
    shooter = new Shooter();

    // Inline command
    m_driverController.a().onTrue(Commands.runOnce( () -> shooter.setSpeed(23.99),shooter));

    // Command in separate file, SetShooterSpeedCommand.java
    m_driverController.a().onTrue( new SetShooterSpeedCommand(shooter, 23.99));

    // Factory Command - see line 24 of Shooter.java
    m_driverController.a().onTrue( shooter.setShooterCommand(23.99));
}

  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new PrintCommand("i am doing nothing");
  }
}