package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "SayWattBlueWheelBot")
public class SayWattBlackTeleOp extends LinearOpMode {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    private DcMotor duckWheelLeft;
    private DcMotor duckWheelRight;
    private DcMotor arm;
    private CRServo grabber;
    private DcMotor armExtension;

    @Override
    public void runOpMode() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        duckWheelLeft = hardwareMap.get(DcMotor.class, "duckWheelLeft");
        duckWheelRight = hardwareMap.get(DcMotor.class, "duckWheelRight");
        arm = hardwareMap.get(DcMotor.class, "arm");
        grabber = hardwareMap.get(CRServo.class, "grabber");
        armExtension = hardwareMap.get(DcMotor.class, "armExtension");


        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {
            double SpeedOfRobotUpDown = 0.8;
            double SpeedOfRobotLeftRight = 0.8;
            double SpeedOfRobotArm = 1;
            if (gamepad1.x) {
                telemetry.addLine("Drive: Fast Speed");
                SpeedOfRobotLeftRight = 100;
                SpeedOfRobotUpDown = 100;
            } else {
                telemetry.addLine("Drive: Default Speed");
                SpeedOfRobotLeftRight = 0.8;
                SpeedOfRobotUpDown = 0.8;
            }
            if (gamepad2.a) {
                telemetry.addLine("Arm: Slow Speed");
                SpeedOfRobotArm = 0.75;
            } else {
                telemetry.addLine("Arm: Default Speed");
                SpeedOfRobotArm = 0.9;
            }

            if( gamepad1.a && gamepad1.x) {
                telemetry.addLine("DuckWheel: Left");
                duckWheelRight.setPower(-0.9);
                duckWheelLeft.setPower(-0.9);
            } else if (gamepad1.a)  {
                telemetry.addLine("DuckWheel: Right");
                duckWheelRight.setPower(0.9);
                duckWheelLeft.setPower(0.9);
            } else {
                telemetry.addLine("DuckWheel: None");
                duckWheelRight.setPower(0);
                duckWheelLeft.setPower(0);
            }
            telemetry.update();

            if (gamepad2.dpad_up) {
                arm.setPower(SpeedOfRobotArm);
            } else {
                arm.setPower(0);
            }
            if (gamepad2.dpad_down) {
                arm.setPower(-SpeedOfRobotArm);
            } else {
                arm.setPower(0);
            }

            if (gamepad2.left_bumper) {
                armExtension.setPower(0.8);
            } else if (gamepad2.right_bumper) {
                armExtension.setPower(-0.8);
            } else {
                armExtension.setPower(0);
            }

            if (gamepad2.right_trigger > 0) {
                grabber.setPower(1);
            } else if (gamepad2.left_trigger > 0) {
                grabber.setPower(-1);
            } else {
                grabber.setPower(0);
            }

            if (gamepad1.dpad_up  && gamepad1.x) {
                frontLeft.setPower(0.6);
                frontRight.setPower(0.6);
                backLeft.setPower(0.6);
                backRight.setPower(0.6);
            } else {
                if (gamepad1.dpad_down) {
                    frontLeft.setPower(SpeedOfRobotUpDown);
                    frontRight.setPower(SpeedOfRobotUpDown);
                    backLeft.setPower(SpeedOfRobotUpDown);
                    backRight.setPower(SpeedOfRobotUpDown);
                } else if (gamepad1.dpad_down&& gamepad1.x) {
                    frontLeft.setPower(0.6);
                    frontRight.setPower(0.6);
                    backLeft.setPower(0.6);
                    backRight.setPower(0.6);
                } else {
                    if (gamepad1.dpad_up) {
                        frontLeft.setPower(-SpeedOfRobotUpDown);
                        frontRight.setPower(-SpeedOfRobotUpDown);
                        backLeft.setPower(-SpeedOfRobotUpDown);
                        backRight.setPower(-SpeedOfRobotUpDown);
                    } else {
                        if (gamepad1.dpad_up&& gamepad1.x){
                            frontLeft.setPower(-0.6);
                            frontRight.setPower(-0.6);
                            backLeft.setPower(-0.6);
                            backRight.setPower(-0.6);
                        }
                            if (gamepad1.dpad_left) {
                                frontRight.setPower(-SpeedOfRobotLeftRight);
                                frontLeft.setPower(SpeedOfRobotLeftRight);
                                backRight.setPower(-SpeedOfRobotLeftRight);
                                backLeft.setPower(SpeedOfRobotLeftRight);
                            } else if (gamepad1.dpad_right) {
                                frontRight.setPower(SpeedOfRobotLeftRight);
                                frontLeft.setPower(-SpeedOfRobotLeftRight);
                                backRight.setPower(SpeedOfRobotLeftRight);
                                backLeft.setPower(-SpeedOfRobotLeftRight);
                            } else {
                                frontLeft.setPower(0);
                                frontRight.setPower(0);
                                backLeft.setPower(0);
                                backRight.setPower(0);
                                if (gamepad1.right_bumper) {
                                    frontRight.setPower(0.9);
                                    frontLeft.setPower(-0.9);
                                    backRight.setPower(-0.9);
                                    backLeft.setPower(0.9);
                                } else if (gamepad1.left_bumper) {
                                    frontRight.setPower(-0.9);
                                    frontLeft.setPower(0.9);
                                    backRight.setPower(0.9);
                                    backLeft.setPower(-0.9);
                                }
                            }
                        }
                    }
                }
            }
            telemetry.update();
        }
    }