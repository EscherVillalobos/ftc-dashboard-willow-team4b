package org.firstinspires.ftc.teamcode.PrimitveTypes.Exercise_4_6_JacksonR;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Exercise_4_6_JacksonR extends OpMode {
    @Override
    public void init(){

    }
    @Override
    public void loop(){
        double forwardSpeed = gamepad1.left_stick_y;
        double gamepadX = gamepad1.left_stick_x;
        double gamepadY = gamepad1.left_stick_y;

        if (!gamepad1.a){
            forwardSpeed *= 0.5;
        }
        else {
            gamepadX= gamepad1.left_stick_y;
            gamepadY= gamepad1.left_stick_x;
        }
        telemetry.addData("Forward Speed", forwardSpeed);
        telemetry.addData("Stick X", gamepadX);
        telemetry.addData("Stick Y", gamepadY);

    }
}
