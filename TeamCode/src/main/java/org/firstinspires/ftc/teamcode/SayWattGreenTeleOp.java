package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.motors.GoBILDA5201Series;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "SayWattGreenTeleOp)")
public class SayWattGreenTeleOp extends LinearOpMode {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;

    @Override
    public void runOpMode() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");

        // Put initialization blocks here.
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {
            double SpeedOfRobot = 0.1;
            double SpeedOfRobotArm = 1;
            if (gamepad1.b) {
                telemetry.addLine("Drive: Slowed Speed");
                SpeedOfRobot = 0.05;
            } else {
                telemetry.addLine("Drive: Default Speed");
                SpeedOfRobot = 0.1;
            }
            if (gamepad2.b) {
                telemetry.addLine("Arm: Slowed Speed");
                SpeedOfRobotArm = 0.6;
            } else {
                telemetry.addLine("Arm: Default Speed");
                SpeedOfRobotArm = 1;
            }
            telemetry.update();



            {

                if (gamepad1.x && gamepad1.dpad_up) {
                    frontLeft.setPower(0.6);
                    frontRight.setPower(-0.6);
                    backLeft.setPower(0.6);
                    backRight.setPower(0.6);
                } else {
                    if (gamepad1.dpad_up) {
                        frontLeft.setPower(SpeedOfRobot);
                        frontRight.setPower(SpeedOfRobot);
                        backLeft.setPower(SpeedOfRobot);
                        backRight.setPower(SpeedOfRobot);
                    } else if (gamepad1.x && gamepad1.dpad_down) {
                        frontLeft.setPower(0.3);
                        frontRight.setPower(-0.3);
                        backLeft.setPower(-0.3);
                        backRight.setPower(0.3);
                    } else {
                        if (gamepad1.dpad_down) {
                            frontLeft.setPower(-SpeedOfRobot);
                            frontRight.setPower(-SpeedOfRobot);
                            backLeft.setPower(-SpeedOfRobot);
                            backRight.setPower(-SpeedOfRobot);
                        } else {
                            if (gamepad1.right_bumper) {
                                frontRight.setPower(0.1);
                                frontLeft.setPower(-0.1);
                                backRight.setPower(-0.1);
                                backLeft.setPower(0.1);
                            } else if (gamepad1.left_bumper) {
                                frontRight.setPower(-0.1);
                                frontLeft.setPower(0.1);
                                backRight.setPower(0.1);
                                backLeft.setPower(-0.1);
                            } else {
                                if (gamepad1.dpad_right) {
                                    frontRight.setPower(-SpeedOfRobot);
                                    frontLeft.setPower(SpeedOfRobot);
                                    backRight.setPower(-SpeedOfRobot);
                                    backLeft.setPower(SpeedOfRobot);
                                } else if (gamepad1.dpad_left) {
                                    frontRight.setPower(SpeedOfRobot);
                                    frontLeft.setPower(-SpeedOfRobot);
                                    backRight.setPower(SpeedOfRobot);
                                    backLeft.setPower(-SpeedOfRobot);
                                } else {
                                    frontLeft.setPower(0);
                                    frontRight.setPower(0);
                                    backLeft.setPower(0);
                                    backRight.setPower(0);
                                }

                            }
                        }
                    }
                }
                telemetry.update();
            }
        }
    }}